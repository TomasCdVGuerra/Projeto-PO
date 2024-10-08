package hva.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee extends hotelEntity {
    private int _satisfLevel;
    private String _type;
    private Hotel _hotel;
    protected List<String> _listResponsabilities;

    public Employee(String id, String name, String type) {
        super(id, name);
        if (type.equals("VET") || type.equals("TRT")) {
            _type = type;
            _listResponsabilities = new ArrayList<>();
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

    public List<String> getResponsabilities() {
        return _listResponsabilities;
    }

    // Abstract methods need to be implemented by subclasses
    public abstract int getSatisf();
    public abstract void addResponsibility(String id);
    public abstract void removeResponsibility(String id);

    @Override
    public String getEntityDetails() {
        return "Employee ID: " + getId() + ", Name: " + getName() + ", Type: " + _type;
    }
}