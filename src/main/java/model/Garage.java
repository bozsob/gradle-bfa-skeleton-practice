package model;

public class Garage {

    private int id;
    private String name;
    private String city;
    private int maxCapacity;

    public Garage(int id, String name, String city, int maxCapacity) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.maxCapacity = maxCapacity;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }
}
