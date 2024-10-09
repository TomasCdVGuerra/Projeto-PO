package hva.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Veterinarian extends Employee {
    private final List<String> speciesIds;
    private final List<Species> _canVacinate;
    private final List<String> _habitatsManaged; // Declare _habitatsManaged

    public Veterinarian(String id, String name, String responsabilities) {
        super(id, name, "VET");
        speciesIds = new ArrayList<>(); // Initialize speciesIds
        _canVacinate = new ArrayList<>(); // Initialize _canVacinate
        String[] lstIdsResps = responsabilities.split(",");
        _habitatsManaged = new ArrayList<>(Arrays.asList(lstIdsResps)); // Initialize _habitatsManaged with String elements
    }

    @Override
    public int getSatisf() {
        int sum = 0;
        for (Species i : _canVacinate) { // Use enhanced for-loop
            sum += getHotel().getPopulation(i) / getHotel().getNVets(i);
        }
        return 20 - sum;
    }

    @Override
    public void addResponsibility(String speciesId) {
        speciesIds.add(speciesId);
    }

    @Override
    public void removeResponsibility(String speciesId) {
        speciesIds.remove(speciesId);
    }

    public List<String> getSpeciesIds() {
        return speciesIds;
    }
}