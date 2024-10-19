package hva.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an Employee in the hotel.
 * This class extends HotelEntity, getting id and name atributes; and implements Serializable.
 * It is extended by Veterinarian and Zookeeper.
 */
public abstract class Employee extends HotelEntity {
    private String _type;
    private int _satisfLevel;
    private Hotel _hotel;
    protected List<Responsibility> _listResponsibilities;

    public Employee(String id, String name, String type) {
        super(id, name);
        if (type.equals("VETERIN´ARIO") || type.equals("TRATADOR"))
            _type = type;
        else{
            //excecao nao e vet nem trt
        }
        _listResponsibilities = new ArrayList<>();
    }
    
    //get methods
    
    public String getType() {
        return _type;
    }

    /**
 * Returns a string representation of the object.
 * This method must be implemented by Zookeeper and Veterinarian.
 *
 * @return a string representation of the object
 */
    @Override
    public abstract String toString();
}
