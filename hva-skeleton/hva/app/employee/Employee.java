// hva-skeleton/hva/app/employee/Employee.java
package hva.app.employee;

import hva.core.Hotel;
import java.util.List;

public abstract class Employee {
    private String id;
    private String name;
    private int satisfactionLevel;
    private boolean type; // true for veterinarian, false for handler
    private Hotel hotel;

    public Employee(String id, String name, int satisfactionLevel, boolean type, Hotel hotel) {
        this.id = id;
        this.name = name;
        this.satisfactionLevel = satisfactionLevel;
        this.type = type;
        this.hotel = hotel;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSatisfaction() {
        return satisfactionLevel;
    }

    public String getType() {
        return type ? "Veterinarian" : "Handler";
    }

    public abstract List<Responsibility> getResponsibilities();
}