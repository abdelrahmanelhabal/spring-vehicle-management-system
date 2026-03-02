package service;
import dao.VehicleDao;
import model.Vehicle;
import java.util.List;

public class VehicleServiceImpl implements VehicleService {
    private final VehicleDao vehicleDao;

    public VehicleServiceImpl(VehicleDao vehicleDao){
        this.vehicleDao = vehicleDao;
    }


    @Override
    public void save(Vehicle vehicle) {
        vehicleDao.save(vehicle);
    }

    @Override
    public void delete(Long id) {
        vehicleDao.delete(id);
    }

    @Override
    public void update(Long id , Vehicle vehicle) {
        vehicleDao.update(id,vehicle);
    }

    @Override
    public Vehicle getById(Long id) {
       return vehicleDao.getById(id);
    }

    @Override
    public List<Vehicle> getAll() {
        return vehicleDao.getAll();
    }

    @Override
    public List<Vehicle> getByType(String type) {
        return vehicleDao.getAllByType(type);
    }
}
