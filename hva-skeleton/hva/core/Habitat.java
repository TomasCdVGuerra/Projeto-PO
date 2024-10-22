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
    private List<Tree> _trees;
    private List<Zookeeper> _zookeepers;
    private final List<Animal> _animals;
    private final List<Species> _species;

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
    public List<Animal> getAnimals() {
        return _animals;
    }

    /**
     * Gets the list of trees in the habitat.
     *
     * @return the list of trees
     */
    public List<Tree> getTree() {
        return _trees;
    }

    /**
     * Gets the list of species in the habitat.
     *
     * @return the list of species
     */
    public List<Species> getSpecies() {
        return _species;
    }

    /**
     * Gets the list of zookeepers in the habitat.
     *
     * @return the list of zookeepers
     */
    public List<Zookeeper> getZookeepers() {
        return _zookeepers;
    }

    // Add entities to be part of this habitat

    /**
     * Adds a tree to the habitat.
     *
     * @param idTree the ID of the tree to add
     */
    public void addTree(Tree tree) {
        _trees.add(tree);
    }
    
    /**
     * Adds a zookeeper to the habitat.
     *
     * @param zookeeper the zookeeper to add
     */
    public void addZookeeper(Zookeeper zookeeper) {
        _zookeepers.add(zookeeper);
    }

    /**
     * Adds an animal to the habitat.
     *
     * @param animal the animal to add
     */
    public void addAnimal(Animal animal) {
        _animals.add(animal);
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

    /**
     * Gets a tree by its ID.
     *
     * @param treeId the ID of the tree
     * @return the Tree object, or null if not found
     */
    public Tree getTreeById(String treeId) {
        // Implement logic to find and return the Tree object by its ID
        // For now, returning null as a placeholder
        return null;
    }

    /**
     * Gets the adequation for a species.
     *
     * @param speciesId the ID of the species
     * @return the adequation for the species
     */
    public Adequation getAdequationForSpecies(String speciesId) {
        // Implement logic to get the adequation for a species
        // For now, returning null as a placeholder
        return null;
    }
    public int countSameSpecies(Animal animal) {
        return (int) _animals.stream()
                             .filter(a -> a.getSpecies().equals(animal.getSpecies()))
                             .count();
      }
    
      public int countDifferentSpecies(Animal animal) {
        return (int) _animals.stream()
                             .filter(a -> !a.getSpecies().equals(animal.getSpecies()))
                             .count();
      }
      public double getAdequacy(Animal animal) {
        // Implement the logic to calculate adequacy
        return 1.0; // Placeholder value
      }
}