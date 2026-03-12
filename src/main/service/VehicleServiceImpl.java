package main.service;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import main.dao.VehicleDao;
import main.model.Vehicle;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
@AllArgsConstructor
@Setter
@Getter
public class VehicleServiceImpl implements VehicleService {

    private final VehicleDao vehicleDao;

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
