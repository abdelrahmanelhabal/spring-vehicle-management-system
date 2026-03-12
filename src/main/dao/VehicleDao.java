package main.dao;
import main.model.Vehicle;
import java.util.List;

public interface VehicleDao {
     void save(Vehicle vehicle);
     void delete(Long id);
     void update(Long id , Vehicle vehicle);
     List<Vehicle> getAll();
     List<Vehicle> getAllByType(String type);
     Vehicle getById(Long id);
}
