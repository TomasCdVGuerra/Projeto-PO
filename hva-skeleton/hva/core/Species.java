package hva.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Species extends HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private final List<String> _animals;

    public Species(String id, String name, Hotel hotel) {
        super(id, name);
        this._animals = new ArrayList<>();
    }

    public List<String> getAnimals() {
        return _animals;
    }

    public void addAnimal(String idAnimal) {
        _animals.add(idAnimal);
    }

    @Override
    public String toString(){
        return "";
    }
}