// hva-skeleton/hva/app/habitat/Habitat.java
package hva.app.habitat;

import hva.core.Tree;
import hva.core.Animal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Habitat {
    private String _id;
    private String _Name;
    private int _area;
    private int _population;
    private List<Tree> _trees;
    private List<Animal> _animals;
    private Map<String, Integer> _adequations;

    public Habitat() {
        // Default constructor
    }

    public Habitat(String id, String Name, int area) {
        this._id = id;
        this._Name = Name;
        this._area = area;
        this._adequations = new HashMap<>();
    }

    public String getID() {
        return _id;
    }

    public String getName() {
        return _Name;
    }

    public int getArea() {
        return _area;
    }

    public int getPopulation() {
        return _population;
    }

    public void addAdequation(String species, int adequationValue) {
        _adequations.put(species, adequationValue);
    }

    public Integer viewAdequation(String species) {
        return _adequations.get(species);
    }

    public Map<String, Integer> getAdequations() {
        return _adequations;
    }

    public int calculateHabitatCleanDiff() {
        int cleaningEffort = _area + 3 * _population;
        for (Tree tree : _trees) {
            cleaningEffort += tree.getFinalCleanDiff();
        }
        return cleaningEffort;
    }

    public List<Tree> getTrees() {
        return _trees;
    }

    public List<Animal> getAnimals() {
        return _animals;
    }
}