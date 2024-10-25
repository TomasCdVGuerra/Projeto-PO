package hva.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Employee in the hotel.
 * This class extends HotelEntity, getting id and name attributes; and implements Serializable.
 * It is extended by Veterinarian and Zookeeper.
 */
public abstract class Employee extends HotelEntity {
    private int _satisfLevel;
    protected List<Responsibility> _listResponsibilities;

    public Employee(String id, String name, Hotel hotel) {
        super(id, name, hotel);
        _listResponsibilities = new ArrayList<>();
    }

    // Abstract method to get the type of the employee
    public abstract String getType();

    // Abstract method to add a responsibility to the employee
    public abstract void addResponsibility(String id);

    /**
     * Returns a string representation of the object.
     * This method must be implemented by Zookeeper and Veterinarian.
     *
     * @return a string representation of the object
     */
    @Override
    public abstract String toString();
}
