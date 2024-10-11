package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Species extends HotelEntity{
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