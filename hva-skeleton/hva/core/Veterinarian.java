package hva.core;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a veterinarian in the hotel management system.
 */
public class Veterinarian extends Employee {
    private final List<String> _speciesIds;

    /**
     * Constructs a new Veterinarian.
     *
     * @param id the unique identifier of the veterinarian
     * @param name the name of the veterinarian
     */
    public Veterinarian(String id, String name) {
        super(id, name, "VET");
        _speciesIds = new ArrayList<>(); // Initialize speciesIds
    }

    /**
     * Gets the list of species IDs that the veterinarian is responsible for.
     *
     * @return the list of species IDs
     */
    public List<String> getSpeciesIds() {
        return _speciesIds;
    }

    /**
     * Returns a string representation of the veterinarian.
     *
     * @return a string representation of the veterinarian
     */
    @Override
    public String toString() {
        String r = "";
        if (_speciesIds.isEmpty())
            return "VET|" + super.getId() + "|" + super.getName();
        for (String element : _speciesIds) {
            r += element + ",";
        }
        return "VET|" + super.getId() + "|" + super.getName() + "|" + r;
    }
}