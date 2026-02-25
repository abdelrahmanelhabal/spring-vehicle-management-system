package service;
import model.Vehicle;
import java.util.List;

public interface VehicleService {
    public void save(Vehicle vehicle);
    public void delete(Long id);
    public void update(Long id , Vehicle vehicle);
    public Vehicle getById(Long id);
    public List<Vehicle> getAll();
    public List<Vehicle> getByType(String type);
}
