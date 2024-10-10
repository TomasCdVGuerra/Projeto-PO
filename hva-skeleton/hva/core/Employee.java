package hva.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends HotelEntity {
    private int _satisfLevel;
    private String _type;
    private Hotel _hotel;
    protected List<Responsibility> _listResponsibilities;

    public Employee(String id, String name, String type) {
        super(id, name);
        if (type.equals("VET") || type.equals("TRT")) {
            _type = type;
            _listResponsibilities = new ArrayList<>();
            // TODO: Set the corresponding hotel
        } else {
            // TODO: Throw an exception for unsupported type
        }
    }

    public Hotel getHotel() {
        return _hotel;
    }

    public String getType() {
        return _type;
    }

    public List<Responsibility> getResponsabilities() {
        return _listResponsibilities;
    }

    // Abstract methods need to be implemented by subclasses
    public abstract int getSatisf();
    public abstract void addResponsibility(String id);
    public abstract void removeResponsibility(String id);
    
}