package hva.core;

import java.util.*;

/**
 * Represents a vaccine in the hotel management system.
 */
public class Vaccine extends HotelEntity {
    private List<String> _species; 
    private int _numAplicacoes; 

    /**
     * Constructs a new Vaccine.
     *
     * @param id the unique identifier of the vaccine
     * @param name the name of the vaccine
     * @param species the list of species that the vaccine is effective for
     */
    public Vaccine(String id, String name, List<String> species) {
        super(id, name);
        species.sort((s1, s2) -> s1.compareToIgnoreCase(s2));
        this._species = species;
    }

    /**
     * Gets the list of species that the vaccine is effective for.
     *
     * @return the list of species
     */
    public List<String> getSpecies() {
        return _species;
    }

    /**
     * Returns a string representation of the vaccine.
     *
     * @return a string representation of the vaccine
     */
    @Override
    public String toString() {    
        String s = "";
        String barra = "";
        if (!_species.isEmpty()) {
            barra += "|"; 
            for (String ids : _species) {
                if (s.length() > 0) {
                    s += ",";
                }
                s += ids;
            }
        }
        return "VACINA|" + super.getId() + "|" + super.getName() + "|" + _numAplicacoes + barra + s;
    }
}