package hva.core;

import java.io.Serializable;

/**
 * Represents an Animal in the hotel.
 * This class extends HotelEntity, getting id and name; and implements Serializable.
 */
public class Animal extends HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String _species;
    private String _habitat;
    private String _healthHistory;

    /**
     * Constructs an Animal with the specified ID, name, species, and habitat.
     *
     * @param idAnimal the ID of the animal
     * @param name the name of the animal
     * @param idSpecies the species ID of the animal
     * @param idHabitat the habitat ID of the animal
     */
    public Animal(String idAnimal, String name, String idSpecies, String idHabitat) {
        super(idAnimal, name);
        this._species = idSpecies;
        this._habitat = idHabitat;
        this._healthHistory = "";
    }

    /**
     * Gets the health history of the animal.
     *
     * @return the health history of the animal, or "VOID" if it is empty
     */
    public String getHealthHistory() {
        if (_healthHistory.isEmpty())
            return "VOID";
        return _healthHistory;
    }

    /**
     * Gets the species of the animal.
     *
     * @return the species of the animal
     */
    public String getSpecies() {
        return _species;
    }

    /**
     * Gets the habitat of the animal.
     *
     * @return the habitat of the animal
     */
    public String getHabitat() {
        return _habitat;
    }

    /**
     * Returns a string representation of the animal.
     *
     * @return a string representation of the animal in the format:
     *         "ANIMAL|id|name|species|healthHistory|habitat"
     */
    @Override
    public String toString() {
        return "ANIMAL|" + super.getId() + "|" + super.getName() + "|" + _species + "|" + getHealthHistory() + "|" + _habitat;
    }
}