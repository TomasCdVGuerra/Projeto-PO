package hva.core;

import java.util.*;

public class Habitat extends HotelEntity{
    private final double _area;
    private final int _population; // Marked as final
    private final List<Tree> _IdTrees; // Marked as final and corrected type
    private final List<Adequation> _adequations; // Marked as final
    private List<Zookeeper> _zookeepers; // Changed from Handler to Zookeeper
    private final List<Animal> _animals; // Marked as final
    private final List<Species> _species; // Marked as final
    private final List<Tree> _trees = new ArrayList<>(); // Declare and initialize _trees

    public Habitat(String habitatId, String name, double area, List<Tree> trees) {  
        super(habitatId, name);
        this._area = area;
        this._population = 0;
        this._IdTrees = new ArrayList<>(trees); // Initialize _IdTrees correctly
        this._adequations = new ArrayList<>();
        this._zookeepers = new ArrayList<>(); // Changed from _handlers to _zookeepers
        this._animals = new ArrayList<>();
        this._species = new ArrayList<>();
    }

    public double getArea() {
        return _area;
    }

    public int getPopulation() {
        return _population;
    }

    public List<Tree> getTrees() {
        return _trees;
    }

    public void addTree(Tree tree) {
        _trees.add(tree);
    }

    public List<Adequation> getAdequations() {
        return _adequations;
    }

    public List<Species> getSpecies() {
        return _species;
    }

    public void addAdequation(Adequation adequation) {
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

    public List<Zookeeper> getZookeepers() {
        return _zookeepers;
    }

    public void addZookeeper(Zookeeper zookeeper) {
        _zookeepers.add(zookeeper);
    }

    public void setZookeepers(List<Zookeeper> zookeepers) { // Removed final keyword
        this._zookeepers = zookeepers;
    }

    public List<Animal> getAnimals() {
        return _animals;
    }

    public void addAnimal(Animal animal) {
        _animals.add(animal);
    }

    public double area() {
        return _area;
    }

    public int population() {
        return _population;
    }

    @Override
    public String getEntityDetails() {
        return "Habitat ID: " + getId() + ", Name: " + getName() + ", Area: " + _area + ", Population: " + _population;
    }
}