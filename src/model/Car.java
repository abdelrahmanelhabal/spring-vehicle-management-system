package model;

public class Car extends Vehicle{
    public Car(){
        setType("Car");
    }
    public Car(Double price , String brand , String color){
        super("Car",price,brand,color);
    }
}
