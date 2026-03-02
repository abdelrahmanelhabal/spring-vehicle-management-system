import model.Car;
import model.Motorcycle;
import model.Plane;
import model.Vehicle;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import service.VehicleService;
import service.VehicleServiceImpl;
import java.util.List;

public class app {
    public static void main(String[] args) {
        ApplicationContext container = new FileSystemXmlApplicationContext("config/app.xml");

        VehicleService service = container.getBean("vehicleService",VehicleServiceImpl.class);

        Vehicle car1 = (Car) container.getBean("car",500000.0,"BMW","Black");

        Vehicle car2 = (Car) container.getBean("car",5000.0,"Tesla","Red");

        Vehicle plane1 = (Plane) container.getBean("plane",150_000_00.0,"Boeing 47","White");

        Vehicle plane2 = (Plane) container.getBean("plane",98_000_000.0,"Airbus A320","Blue");

        Vehicle motorcycle1 = (Motorcycle) container.getBean("motorcycle",20000.0,"Yamaha R1","Black");

        Vehicle motorcycle2 = (Motorcycle) container.getBean("motorcycle",15000.0,"Honda CBR600","Red");
        service.save(car1);
        service.save(car2);
        service.save(plane1);
        service.save(plane2);
        service.save(motorcycle1);
        service.save(motorcycle2);

        List<Vehicle> vehicles = service.getAll();

        for(Vehicle vehicle : vehicles){
            System.out.println(
                 "Id : " + vehicle.getId() +
                 "| Type : " + vehicle.getType() +
                 "| Brand : " + vehicle.getBrand() +
                 "| Color : " + vehicle.getColor() +
                 "| Price : " + vehicle.getPrice()
            );
        }

        List<Vehicle> sameVehiclesType = service.getByType("car");
        System.out.println("\t\t\t\t\tCar");
        for(Vehicle vehicle : sameVehiclesType){
            System.out.println(
                  "Id : " + vehicle.getId() +
                  "| Brand : " + vehicle.getBrand() +
                  "| Color : " + vehicle.getColor() +
                  "| Price : " + vehicle.getPrice()
            );
        }
    }
}
