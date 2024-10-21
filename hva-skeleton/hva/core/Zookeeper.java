package hva.core;

import java.util.*;

/**
 * Represents a zookeeper in the hotel management system.
 */
public class Zookeeper extends Employee {
    private final List<String> _habitatsManaged; // Marked as final

    /**
     * Constructs a new Zookeeper.
     *
     * @param id the unique identifier of the zookeeper
     * @param name the name of the zookeeper
     */
    public Zookeeper(String id, String name) {
        super(id, name);
        _habitatsManaged = new ArrayList<>(); // Initialize as empty list
    }

    /**
     * Gets the list of habitats managed by the zookeeper.
     *
     * @return the list of habitats managed
     */
    public List<String> getHabitatsM() {
        return _habitatsManaged;
    }

    /**
     * Returns the type of the employee.
     *
     * @return the type of the employee
     */
    @Override
    public String getType() {
        return "TRT";
    }

    /**
     * Calculates the satisfaction level of the zookeeper.
     *
     * @param habitats a map of habitat IDs to Habitat objects
     * @param habitatZookeeperCount a map of habitat IDs to the number of zookeepers assigned to that habitat
     * @return the satisfaction level of the zookeeper
     */
    public int calculateSatisfaction(Map<String, Habitat> habitats, Map<String, Integer> habitatZookeeperCount) {
        int satisfaction = 300;
        for (String habitatId : _habitatsManaged) {
            Habitat habitat = habitats.get(habitatId);
            if (habitat != null) {
                int workInHabitat = habitat.getArea() + 3 * habitat.getPopulation();
                for (String treeId : habitat.getTree()) {
                    Tree tree = habitat.getTreeById(treeId); // Assuming a method to get Tree by ID
                    if (tree != null) {
                        workInHabitat += tree.getCleaningEffort();
                    }
                }
                int zookeeperCount = habitatZookeeperCount.getOrDefault(habitatId, 1); // Avoid division by zero
                satisfaction -= workInHabitat / zookeeperCount;
            }
        }
        return satisfaction;
    }

    /**
     * Returns a string representation of the zookeeper.
     *
     * @return a string representation of the zookeeper
     */
    @Override
    public String toString() {
        String r = "";
        if (_habitatsManaged.isEmpty())
            return getType() + "|" + super.getId() + "|" + super.getName();
        for (String element : _habitatsManaged) {
            r += element + ",";
        }
        return getType() + "|" + super.getId() + "|" + super.getName() + "|" + r;
    }
}