package hva.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
        super(id, name);
        _speciesIds = new ArrayList<>(); // Initialize speciesIds
    }

    /**
     * Adds a species responsibility to the veterinarian.
     *
     * @param speciesId the ID of the species
     */
    public void addSpeciesResponsibility(String speciesId) {
        _speciesIds.add(speciesId);
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
     * Returns the type of the employee.
     *
     * @return the type of the employee
     */
    @Override
    public String getType() {
        return "VET";
    }

    /**
     * Adds a species to speciesId vaccinated by the veterinarian.
     *
     * @param id key of the new species the employee will vaccinate
     */
    @Override
     public void addResponsibility(String id){
        _speciesIds.add(id);
    }

    /**
     * Calculates the satisfaction level of the veterinarian.
     *
     * @param speciesAnimalCount a map of species IDs to the number of animals of that species
     * @param speciesVetCount a map of species IDs to the number of veterinarians working on that species
     * @return the satisfaction level of the veterinarian
     */
    public int calculateSatisfaction(Map<String, Integer> speciesAnimalCount, Map<String, Integer> speciesVetCount) {
        int satisfaction = 20;
        for (String speciesId : _speciesIds) {
            int animalCount = speciesAnimalCount.getOrDefault(speciesId, 0);
            int vetCount = speciesVetCount.getOrDefault(speciesId, 1); // Avoid division by zero
            satisfaction -= animalCount / vetCount;
        }
        return satisfaction;
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
            return getType() + "|" + super.getId() + "|" + super.getName();
            int size = _speciesIds.size();
            int count = 0;
                
            for (String element : _speciesIds) {
                r += element;
                count++;
                if (count < size) {
                    r += ",";
                }
            }
        return getType() + "|" + super.getId() + "|" + super.getName() + "|" + r;
    }
}