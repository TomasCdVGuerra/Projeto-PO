package hva.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Represents a zookeeper in the hotel management system.
 */
public class Zookeeper extends Employee {
    private List<String> _habitatsManaged;

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
     * Adds a habitat responsibility to the zookeeper.
     *
     * @param habitatId the ID of the habitat
     */
    public void addHabitatResponsibility(String habitatId) {
        _habitatsManaged.add(habitatId);
    }

    /**
     * Gets the list of habitats managed by the zookeeper.
     *
     * @return the list of habitats managed by the zookeeper
     */
    public List<String> getHabitatsManaged() {
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
     * Adds a habitat to habitats managed by the zookeeper.
     *
     * @param id key of the new habitat the employee will manage
     */
    @Override
     public void addResponsibility(String id){
        _habitatsManaged.add(id);
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
                for (Tree tree : habitat.getTrees()) {
                    if (tree != null) {
                        workInHabitat += tree.getCleaningEffort();
                    }
                }
                int zookeeperCount = habitatZookeeperCount.getOrDefault(habitatId, 1);
                System.out.println("Habitat ID: " + habitatId + ", Work in Habitat: " + workInHabitat + ", Zookeeper Count: " + zookeeperCount);
                satisfaction -= workInHabitat / zookeeperCount;
                System.out.println("Intermediate Satisfaction: " + satisfaction);
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
            
        int size = _habitatsManaged.size();
        int count = 0;
            
        for (String element : _habitatsManaged) {
            r += element;
            count++;
            if (count < size) {
                r += ",";
            }
        }
        return getType() + "|" + super.getId() + "|" + super.getName() + "|" + r;
    }
}