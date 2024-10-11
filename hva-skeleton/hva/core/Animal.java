package hva.core;

import java.io.Serializable;

/**
 * Represents an Animal in the hotel.
 * This class extends HotelEntity, getting id and name atributes; and implements Serializable.
 */
public class Animal extends HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String _species;
    private String _habitat;
    private String _healthHistory;

    /**
     * Constructs an Animal.
     *
     * @param idAnimal the ID of the Animal
     * @param name the name of the Animal
     * @param idSpecies ID of the Species ofthe animal
     * @param idHabitat ID of the Habitat ofthe animal
     */
    public Animal(String idAnimal, String name, String idSpecies, String idHabitat) {
        super(idAnimal, name);
        this._species = idSpecies;
        this._habitat = idHabitat;
        this._healthHistory = "";
    }

    /**
     * Gets the health history of the Animal.
     *
     * @return the health history of the animal, or "VOID" if it is empty
     */
    public String getHealthHistory() {
        if (_healthHistory.isEmpty())
            return "VOID";
        return _healthHistory;
    }

    /**
     * Gets the Species of the Animal.
     *
     * @return the Species of the Animal
     */
    public String getSpecies() {
        return _species;
    }

    /**
     * Gets the Habitat of the Animal.
     *
     * @return the Habitat of the Animal
     */
    public String getHabitat() {
        return _habitat;
    }

    /**
     * Returns a string representation of the Animal, used in DoShowAllAnimals.
     *
     * @return a string representation of the animal in the format:
     *         "ANIMAL|id|name|idSpecies|healthHistory|idHabitat"
     */
    @Override
    public String toString() {
        return "ANIMAL|" + super.getId() + "|" + super.getName() + "|" + _species + "|" + getHealthHistory() + "|" + _habitat;
    }
}