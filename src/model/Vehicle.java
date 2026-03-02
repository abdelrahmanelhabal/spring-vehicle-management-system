package model;

public abstract class Vehicle {
   private Long id ;
   private String type ;
   private Double price ;
   private String brand ;
   private String color ;

   public Vehicle(){}

   public Vehicle(String type , Double price , String brand , String color){
       setBrand(brand);
       setColor(color);
       setPrice(price);
       setType(type);
   }
    public void setId(Long id){
       this.id = id ;
    }
    public Long getId() { return id; }

    public String getType() { return type; }

    public void setType(String type) {
        if(type == null  || type.trim().isEmpty()){
            throw new IllegalArgumentException("Type cannot be empty");
        }
        this.type = type;
    }

    public Double getPrice() { return price; }

    public void setPrice(Double price) {
        if(price <= 0){
            throw new IllegalArgumentException("Price must be > 0");
        }
        this.price = price;
    }

    public String getBrand() { return brand; }

    public void setBrand(String brand) {
        if(brand == null  || brand.trim().isEmpty()){
            throw new IllegalArgumentException("Brand cannot be empty");
        }
        this.brand = brand;
    }

    public String getColor() { return color; }

    public void setColor(String color) {
        if(color == null  || color.trim().isEmpty()){
            throw new IllegalArgumentException("Color cannot be empty");
        }
        this.color = color;
    }
}