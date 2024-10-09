package hva.core;

import java.util.*;

public class Habitat extends HotelEntity {
    private final double _area;
    private int _population;
    private List<Tree> _IdTrees;
    private List<Adequation> _adequations;
    private List<Zookeeper> _zookeepers; // Changed from Handler to Zookeeper
    private List<Animal> _animals;
    private List<Species> _species;

    public Habitat(String habitatId, String name, double area, int population, String idsTrees) {  
        super(habitatId, name);
        this._area = area;
        this._population = population;
        String[] lstTrees = idsTrees.split(",");
        this._IdTrees = new ArrayList<>(Arrays.asList(lstTrees));
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

    public void setZookeepers(List<Zookeeper> _zookeepers) {
        this._zookeepers = _zookeepers;
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