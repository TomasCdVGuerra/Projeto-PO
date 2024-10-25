package hva.core;

import java.io.*;

/**
 * Represents an abstract entity in the hotel system.
 * This class implements Serializable to allow its instances to be serialized.
 */
public abstract class HotelEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;
    private String _id;
    private String _name;
    private Hotel _hotel;

    /**
     * Constructs a HotelEntity with the specified ID and name.
     *
     * @param id the ID of the entity
     * @param name the name of the entity
     */
    public HotelEntity(String id, String name, Hotel hotel) {
        this._id = id;
        this._name = name;
        this._hotel = hotel;
    }

    /**
     * Gets the ID of the entity.
     *
     * @return the ID of the entity
     */
    public String getId() {
        return _id;
    }

    /**
     * Gets the name of the entity.
     *
     * @return the name of the entity
     */
    public String getName() {
        return _name;
    }

    /**
     * Sets the ID of the entity.
     *
     * @param id the new ID of the entity
     */
    public void setId(String id) {
        this._id = id;
    }

    /**
     * Sets the name of the entity.
     *
     * @param name the new name of the entity
     */
    public void setName(String name) {
        this._name = name;
    }

    /**
     * Gets the hotel associated with the entity.
     *
     * @return the hotel associated with the entity
     */
    public Hotel getHotel() {
        return _hotel;
    }
    
    /**
     * Sets the hotel associated with the entity.
     *
     * @param hotel the new hotel to associate with the entity
     */
    public void setHotel(Hotel hotel) {
        this._hotel = hotel;
    }

    /**
     * Returns a string representation of the entity.
     * This method must be implemented by subclasses.
     *
     * @return a string representation of the entity
     */
    public abstract String toString();
}
