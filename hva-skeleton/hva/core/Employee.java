package hva.core;

/**
 * Represents an Employee in the hotel.
 * This class extends HotelEntity, getting id and name atributes; and implements Serializable and is extended by Veterinarian and Zookeeper.
 */
public abstract class Employee extends HotelEntity {
    private int _satisfLevel;
    private String _type;

    public Employee(String id, String name, String type) {
        super(id, name);
        if (type.equals("VETERIN´ARIO") || type.equals("TRATADOR")) {
            _type = type;
        }
    }
    
    //get methods
    
    public String getType() {
        return _type;
    }

    @Override
    public abstract String toString();
}