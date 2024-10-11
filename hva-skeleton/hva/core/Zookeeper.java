package hva.core;

import java.util.*;

public class Zookeeper extends Employee {
    private final List<String> _habitatsManaged; // Marked as final

    public Zookeeper(String id, String name) {
        super(id, name, "TRT");
        _habitatsManaged = new ArrayList<>(); // Initialize as empty list
    }

    public List<String> getHabitatsM(){
        return _habitatsManaged;
    }

    @Override
    public String toString(){
        String r = "";
        if(_habitatsManaged.isEmpty())
            return "TRATADOR|" + super.getId()+"|" + super.getName();
        for(String element: _habitatsManaged){
            r+=element+",";
        }
        return "TRATADOR|" + super.getId()+"|" + super.getName() + "|" + r;
    }

    /*

    private Habitat findHabitatById(String idHabitat) {
        // Implement logic to find and return habitat by id
        // For now, returning null as a placeholder
        return null;
    } */
}