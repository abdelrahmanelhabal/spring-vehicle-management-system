package main.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component
@Scope("prototype")
public class Motorcycle extends Vehicle{
    public Motorcycle(){
        setType("Motorcycle");
    }
    public Motorcycle(Double price , String brand , String color){
        super("Motorcycle",price,brand,color);
    }
}
