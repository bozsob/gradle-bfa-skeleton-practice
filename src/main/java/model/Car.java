package model;

public class Car {

    private int id;
    private String color;
    private int year;
    private String brand;
    private int garageId;

    public Car(int id, String color, int year, String brand, int garageId) {
        this.id = id;
        this.color = color;
        this.year = year;
        this.brand = brand;
        this.garageId = garageId;
    }

    public Car(String color, int year, String brand, int garageId) {
        this.id = 0;
        this.color = color;
        this.year = year;
        this.brand = brand;
        this.garageId = garageId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public String getBrand() {
        return brand;
    }

    public int getGarageId() {
        return garageId;
    }
}
