package hva.core;

import java.util.*;

/**
 * Represents a Habitat in the hotel system.
 * This class extends HotelEntity and implements Serializable.
 * Keeps a List of Trees, Zookeepers, Animals and their Species;
 */
public class Habitat extends HotelEntity {
    private final int _area;
    private final int _population;
    private List<String> _trees;
    private List<String> _zookeepers;
    private final List<String> _animals;
    private final List<String> _species;

    /**
     * Constructs a Habitat with the specified ID, name, and area.
     *
     * @param habitatId the ID of the habitat
     * @param name the name of the habitat
     * @param area the area of the habitat
     */
    public Habitat(String habitatId, String name, int area) {  
        super(habitatId, name);
        this._area = area;
        this._population = 0;
        this._trees = new ArrayList<>();
        this._zookeepers = new ArrayList<>();
        this._animals = new ArrayList<>();
        this._species = new ArrayList<>();
    }

    // Get methods

    /**
     * Gets the area of the habitat.
     *
     * @return the area of the habitat
     */
    public int getArea() {
        return _area;
    }

    /**
     * Gets the population of the habitat.
     *
     * @return the population of the habitat
     */
    public int getPopulation() {
        return _population;
    }

    /**
     * Gets the list of animals in the habitat.
     *
     * @return the list of animals
     */
    public List<String> getAnimals() {
        return _animals;
    }

    /**
     * Gets the list of trees in the habitat.
     *
     * @return the list of trees
     */
    public List<String> getTree() {
        return _trees;
    }

    /**
     * Gets the list of species in the habitat.
     *
     * @return the list of species
     */
    public List<String> getSpecies() {
        return _species;
    }

    /**
     * Gets the list of zookeepers in the habitat.
     *
     * @return the list of zookeepers
     */
    public List<String> getZookeepers() {
        return _zookeepers;
    }

    // Add entities to be part of this habitat

    /**
     * Adds a tree to the habitat.
     *
     * @param idTree the ID of the tree to add
     */
    public void addTree(String idTree) {
        _trees.add(idTree);
    }
    
    /**
     * Adds a zookeeper to the habitat.
     *
     * @param idZookeeper the ID of the zookeeper to add
     */
    public void addZookeeper(String idZookeeper) {
        _zookeepers.add(idZookeeper);
    }

    /**
     * Adds an animal to the habitat.
     *
     * @param idAnimal the ID of the animal to add
     */
    public void addAnimal(String idAnimal) {
        _animals.add(idAnimal);
    }

    /**
     * Gets the number of trees in the habitat.
     *
     * @return the number of trees
     */
    public int getNumTrees() {
        return _trees.size();
    }

    /**
     * Returns a string representation of the habitat.
     *
     * @return a string representation of the habitat in the format:
     *         "HABITAT|id|name|area|numTrees"
     */
    @Override
    public String toString() {
        return "HABITAT|" + super.getId() + "|" + super.getName() + "|" + _area + "|" + getNumTrees();
    }
}
