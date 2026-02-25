package dao;
import model.Vehicle;
import java.util.List;

public interface VehicleDao {
    public void save(Vehicle vehicle);
    public void delete(Long id);
    public void update(Long id , Vehicle vehicle);
    public List<Vehicle> getAll();
    public List<Vehicle> getAllByType(String type);
    public Vehicle getById(Long id);
}
