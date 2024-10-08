package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Zookeeper extends Employee {
    private final List<Habitat> _habitatsManaged; // Marked as final

    public Zookeeper(String id, String name) {
        super(id, name, "TRT");
        _habitatsManaged = new ArrayList<>();
    }

    @Override
    public int getSatisf() {
        int sum = 0;
        for (Habitat habitat : _habitatsManaged) {
            for (Species species : habitat.getSpecies()) {
                sum += this.workInHabitat(habitat) / species.getNVets();
            }
        }
        return 300 - sum;
    }

    public int workInHabitat(Habitat habitat) {
        int sum = 0;
        for (Species species : habitat.getSpecies()) {
            sum += species.cleaningEffort();
        }
        return (int) habitat.area() + 3 * habitat.population() + sum; // Cast to int
    }

    @Override
    public void addResponsibility(String idHabitat) {
        Habitat habitat = findHabitatById(idHabitat);
        if (habitat != null && !_habitatsManaged.contains(habitat)) {
            _habitatsManaged.add(habitat);
        }
    }

    @Override
    public void removeResponsibility(String idHabitat) {
        Habitat habitat = findHabitatById(idHabitat);
        _habitatsManaged.remove(habitat);
    }

    private Habitat findHabitatById(String idHabitat) {
        // Implement logic to find and return habitat by id
        return null;
    }
}