package hva.core;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Zookeeper extends Employee {
    private List<Habitat> _habitatsManaged;
    
    public Zookeeper(String id, String name, String type){
        super(id,name,type);
    }

    @Override
    public int getSatisf() {
        int sum = 0;
        for (Habitat habitat : _habitatsManaged) {
            for (Species species : habitat.getSpecies()) { // Ensure getSpecies method exists in Habitat
                sum += this.trabalhoHabitat(species) / species.getNVets(); // Ensure these methods exist and are accessible
            }
        }
        return 300 - sum;
    }

    public int workInHabitat(Habitat habitat) {
        int sum = 0;
        for (Species species : habitat.getSpecies()) { // Ensure getSpecies method exists in Habitat
            sum += species.cleaningEffort(); // Ensure cleaningEffort method exists in Species
        }
        return habitat.area() + 3 * habitat.population() + sum; // Ensure area and population methods exist in Habitat
    }

    @Override
    public void addResponsibility(String idHabitat) {
        Habitat habitat = findHabitatById(idHabitat); // Implement this method to find habitat by id
        if (habitat != null && !_habitatsManaged.contains(habitat)) {
            _habitatsManaged.add(habitat);
        }
    }

    @Override
    public void removeResponsibility(String idHabitat) {
        Habitat habitat = findHabitatById(idHabitat); // Implement this method to find habitat by id
        _habitatsManaged.remove(habitat);
    }

    private Habitat findHabitatById(String idHabitat) {
        // Implement logic to find and return habitat by id
        return null; // Placeholder return statement
    }
}