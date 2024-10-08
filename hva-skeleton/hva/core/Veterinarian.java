package hva.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Veterinarian extends Employee {
    private final List<String> speciesIds;
    private List<Species> _canVacinate; // Assuming this is the intended variable

    public Veterinarian(String id, String name) {
        super(id, name, "VET");
        this.speciesIds = new ArrayList<>();
    }

    public int getSatisf() {
        int sum = 0;
        Iterator<Species> itr = _canVacinate.iterator();

        while (itr.hasNext()) {
            Species i = itr.next();
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