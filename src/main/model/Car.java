package main.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Car extends Vehicle{
    public Car(){
        setType("Car");
    }
    public Car(Double price , String brand , String color){
        super("Car",price,brand,color);
    }
}
