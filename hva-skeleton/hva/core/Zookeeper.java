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
        super(id, name, "TRT");
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
     * Returns a string representation of the zookeeper.
     *
     * @return a string representation of the zookeeper
     */
    @Override
    public String toString() {
        String r = "";
        if (_habitatsManaged.isEmpty())
            return "TRT|" + super.getId() + "|" + super.getName();
        for (String element : _habitatsManaged) {
            r += element + ",";
        }
        return "TRT|" + super.getId() + "|" + super.getName() + "|" + r;
    }
    
}