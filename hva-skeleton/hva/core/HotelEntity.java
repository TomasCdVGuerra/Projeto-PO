package hva.core;

import java.io.*;

public abstract class HotelEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 202407081733L;
    private String _id;
    private String _name;
    private Hotel _hotel;

    public HotelEntity(String id, String name) {
        this._id = id;
        this._name = name;
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    public void setId(String id) {
        this._id = id;
    }

    public void setName(String name) {
        this._name = name;
    }

    public Hotel getHotel() {
        return _hotel;
    }
    
    public void setHotel(Hotel hotel) {
        this._hotel = hotel;
    }

    public abstract String toString();
}