package model;

public class Motorcycle extends Vehicle{
    public Motorcycle(){
        setType("Motorcycle");
    }
    public Motorcycle(Double price , String brand , String color){
        super("Motorcycle",price,brand,color);
    }
}
