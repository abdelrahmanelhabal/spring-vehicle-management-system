package main.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.config.DBConfig;
import main.model.Vehicle;
import org.springframework.stereotype.Repository;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@AllArgsConstructor
@Setter
@Getter
public class VehicleDaoImpl implements VehicleDao {

    private final DBConfig dbConfig ;

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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
        try(PreparedStatement preparedStatement = dbConfig.getConnection().prepareStatement(QUERY)){
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
