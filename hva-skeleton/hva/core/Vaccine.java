package hva.core;

import java.util.*;

public class Vaccine extends HotelEntity{
    private List<String> _species; 
    private int _numAplicacoes; 

    public Vaccine(String id, String name, List<String> species) {
        super(id, name);
        this._species = species;
    }

    public List<String> getSpecies() {
        return _species;
    }

    @Override
    public String toString(){    
        String s="";
        String barra="";
        if(!(_species.isEmpty())){
           barra+="|"; 
            for(String ids:_species){
                if (s.length() > 0) {
                    s+=",";
                }
                s+=ids;
            }
        }
        return "VACINA|" + super.getId() + "|" + super.getName() +"|"+ _numAplicacoes + barra + s;
    }
}