package model;

public class Plane extends Vehicle{
    public Plane(){
        setType("Plane");
    }
    public Plane(Double price , String brand , String color){
        super("Plane",price,brand,color);
    }
}
