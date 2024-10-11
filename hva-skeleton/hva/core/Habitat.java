package hva.core;

import java.util.*;

public class Habitat extends HotelEntity{
    private final int _area;
    private final int _population; // Marked as final
    private List<String> _trees; // Marked as final and corrected type
    //private final List<Adequation> _adequations; // Marked as final
    private List<String> _zookeepers; // Changed from Handler to Zookeeper
    private final List<String> _animals; // Marked as final
    private final List<String> _species; // Marked as final

    public Habitat(String habitatId, String name, int area) {  
        super(habitatId, name);
        this._area = area;
        this._population = 0;
        this._trees = new ArrayList<>();
        /* this._adequations = new ArrayList<>(); */
        this._zookeepers = new ArrayList<>(); // Changed from _handlers to _zookeepers
        this._animals = new ArrayList<>();
        this._species = new ArrayList<>();
    }

    public int getArea() {
        return _area;
    }

    public int getPopulation() {
        return _population;
    }

    public List<String> getTree() {
        return _trees;
    }

    public void addTree(String idTree) {
        _trees.add(idTree);
    }

/*     public List<Adequation> getAdequations() {
        return _adequations;
    } */

    public List<String> getSpecies() {
        return _species;
    }

    /* public void addAdequation(Adequation adequation) {
        _adequations.add(adequation);
    }

    public void removeAdequation(Species species) {
        _adequations.removeIf(adequation -> adequation.getSpecies().equals(species));
    }

    public Adequation getAdequationForSpecies(Species species) {
        for (Adequation adequation : _adequations) {
            if (adequation.getSpecies().equals(species)) {
                return adequation;
            }
        }
        return new Adequation(species, Adequation.AdequationValue.NEUTRAL);
    }
 */
    public List<String> getZookeepers() {
        return _zookeepers;
    }

    public void addZookeeper(String idZookeeper) {
        _zookeepers.add(idZookeeper);
    }

    /* public void setZookeepers(List<Zookeeper> zookeepers) { // Removed final keyword
        this._zookeepers = zookeepers;
    } */

    public List<String> getAnimals() {
        return _animals;
    }

    public void addAnimal(String idAnimal) {
        _animals.add(idAnimal);
    }

    public int getNumTrees(){
        return _trees.size();
    }


    @Override
    public String toString(){
        return "HABITAT|" + super.getId()+"|" + super.getName() + "|" + _area + "|" + getNumTrees();
    }
}