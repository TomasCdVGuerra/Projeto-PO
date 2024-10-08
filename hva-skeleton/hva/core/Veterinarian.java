package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Veterinarian extends Employee {
    private List<String> speciesIds;

    public Veterinarian(String id, String name) {
        super(id, name, "VET");
        this.speciesIds = new ArrayList<>();
    }

    @Override
    public int getSatisf() {
        // Implement satisfaction level calculation
        return 0;
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