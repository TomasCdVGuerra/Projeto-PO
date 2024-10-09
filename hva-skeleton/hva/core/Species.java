package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Species extends HotelEntity{
    private final List<Animal> _animals;
    private Hotel _hotel; // Reference to the hotel

    public Species(String id, String name, Hotel hotel) {
        super(id, name);
        this._animals = new ArrayList<>();
        this._hotel = hotel; // Initialize the hotel reference
    }

    public List<Animal> getAnimals() {
        return _animals;
    }

    public void addAnimal(Animal animal) {
        _animals.add(animal);
    }

    public int getNVets() {
        return _hotel.getNVets(this); // Use the hotel's getNVets method
    }

    public int cleaningEffort() {
        // Implement the logic for calculating cleaning effort
        return 0; // Placeholder implementation
    }

    @Override
    public String getEntityDetails() {
        return "Species ID: " + getId() + ", Name: " + getName();
    }
}