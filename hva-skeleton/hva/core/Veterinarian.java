package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Veterinarian extends Employee {
    private final List<String> _speciesIds;

    public Veterinarian(String id, String name) {
        super(id, name, "VET");
        _speciesIds = new ArrayList<>(); // Initialize speciesIds
    }

    public List<String> getSpeciesIds(){
        return _speciesIds;
    }
    
    @Override
    public String toString(){
        String r = "";
        if(_speciesIds.isEmpty())
            return "VET|" + super.getId()+"|" + super.getName();
        for(String element: _speciesIds){
            r+=element+",";
        }
        return "VET|" + super.getId()+"|" + super.getName() + "|" + r;
    }

   /*  

    public List<String> getSpeciesIds() {
        return _speciesIds;
    } */
}