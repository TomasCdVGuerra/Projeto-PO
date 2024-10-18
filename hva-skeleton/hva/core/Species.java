package hva.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Species in the hotel system.
 * This class extends HotelEntity and implements Serializable.
 */
public class Species extends HotelEntity {
    private static final long serialVersionUID = 1L;
    private final List<String> _animals;

    /**
     * Constructs a Species with the specified ID, name, and associated hotel.
     *
     * @param id the ID of the species
     * @param name the name of the species
     * @param hotel the hotel associated with the species
     */
    public Species(String id, String name, Hotel hotel) {
        super(id, name);
        this._animals = new ArrayList<>();
    }

    /**
     * Gets the list of animals belonging to the species.
     *
     * @return the list of animals
     */
    public List<String> getAnimals() {
        return _animals;
    }

    /**
     * Adds an animal to the species.
     *
     * @param idAnimal the ID of the animal to add
     */
    public void addAnimal(String idAnimal) {
        _animals.add(idAnimal);
    }

    /**
     * Returns a string representation of the species.
     *
     * @return a string representation of the species
     */
    @Override
    public String toString() {
        return "";
    }
}
