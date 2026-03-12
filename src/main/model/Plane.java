package main.model;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class Plane extends Vehicle{
    public Plane(){
        setType("Plane");
    }
    public Plane(Double price , String brand , String color){
        super("Plane",price,brand,color);
    }
}
