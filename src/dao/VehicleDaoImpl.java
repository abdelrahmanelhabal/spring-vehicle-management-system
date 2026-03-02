package dao;
import model.Vehicle;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VehicleDaoImpl implements VehicleDao {
    private Connection connection ;
    private String url ;
    private String username ;
    private String password ;

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getUrl() { return url; }

    public void setUrl(String url) { this.url = url; }

    public void connectToDatabase(){
        try{
            connection = DriverManager.getConnection(url,username,password);
        }
        catch (SQLException e){
            throw new DaoException("Failed to create Database connection",e);
        }
    }

    public void disconnectToDatabase(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        }
        catch (SQLException e){
            throw new DaoException("Failed to close Database connection",e);
        }
    }

    private Vehicle mapRow(ResultSet resultSet) throws SQLException{
        Vehicle vehicle = new Vehicle(
                resultSet.getString("type"),
                resultSet.getDouble("price"),
                resultSet.getString("brand"),
                resultSet.getString("color")
        ){};
        vehicle.setId(resultSet.getLong("id"));

        return vehicle;
    };

    @Override
    public void save(Vehicle vehicle) {
        final String QUERY = "INSERT into Vehicles (type , price , brand , color) VALUES (?,?,?,?)";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,vehicle.getType());
            preparedStatement.setDouble(2,vehicle.getPrice());
            preparedStatement.setString(3,vehicle.getBrand());
            preparedStatement.setString(4,vehicle.getColor());
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new DaoException("Failed to  save data in to Database" , e);
        }
    }

    @Override
    public void delete(Long id) {
        Vehicle vehicle = getById(id);
        if(vehicle == null){
            throw new RuntimeException("This vehicle not found");
        }
        final String QUERY = "DELETE FROM Vehicles WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new DaoException("Failed to  delete data from Database");
        }
    }

    @Override
    public void update(Long id , Vehicle vehicle) {
        Vehicle vehicles = getById(id);
        if(vehicles == null){
            throw new RuntimeException("This vehicle not found");
        }
        final String QUERY = "UPDATE Vehicles SET type=? , price=? , color=? , brand=? WHERE id=?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,vehicle.getType());
            preparedStatement.setDouble(2,vehicle.getPrice());
            preparedStatement.setString(3,vehicle.getColor());
            preparedStatement.setString(4,vehicle.getBrand());
            preparedStatement.setLong(5,id);
            preparedStatement.executeUpdate();
        }
        catch (SQLException e){
            throw new DaoException("Failed to update data from database");
        }
    }

    @Override
    public List<Vehicle> getAll() {
        final String QUERY = "SELECT * FROM Vehicles";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            List<Vehicle> list = new ArrayList<>() ;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(mapRow(resultSet));
            }
            return list ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to get data from database",e);
        }
    }

    @Override
    public List<Vehicle> getAllByType(String type) {
        final String QUERY = "SELECT * FROM Vehicles WHERE type = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setString(1,type);
            List<Vehicle> list = new ArrayList<>() ;
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                list.add(mapRow(resultSet));
            }
            return list ;
        }
        catch (SQLException e){
            throw new DaoException("Failed to get data from database",e);
        }
    }

    @Override
    public Vehicle getById(Long id) {
        final String QUERY = "SELECT * FROM Vehicles WHERE id = ?";
        try(PreparedStatement preparedStatement = connection.prepareStatement(QUERY)){
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                return mapRow(resultSet);
            }
        }
        catch (SQLException e){
            throw new DaoException("Failed to get Data From Database");
        }
        return null;
    }
}
