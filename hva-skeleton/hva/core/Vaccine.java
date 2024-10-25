package hva.core;

import hva.app.exception.UnknownSpeciesKeyException;
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

    private int countCommonCharacters(String name1, String name2) {
        int[] charCount = new int[256];
        for (char c : name1.toCharArray()) {
            charCount[c]++;
        }

        int commonCount = 0;
        for (char c : name2.toCharArray()) {
            if (charCount[c] > 0) {
                commonCount++;
                charCount[c]--;
            }
        }

        return commonCount;
    }

    public int[] calculateDamage(Species species) throws UnknownSpeciesKeyException{
        int maxDamage = 0;
        int maxLength = 0;
        int commonChars = 0;
        String maxSpeciesId = "";
        int samespcs = 0;

        for (String idSpecies : this.getSpecies()) {
            try{
            maxLength = Math.max(species.getName().length(), this.getHotel().getSpecies(idSpecies).getName().length());
            commonChars = countCommonCharacters(species.getName(), this.getHotel().getSpecies(idSpecies).getName());
            } catch(UnknownSpeciesKeyException e) {
                throw new UnknownSpeciesKeyException(idSpecies);
            }
            int damage = maxLength - commonChars;
            if(maxDamage<damage){
                maxSpeciesId=idSpecies;
            }
            maxDamage = Math.max(maxDamage, damage);
        }
        if(maxSpeciesId.equals(species.getId()))
            samespcs=1;
        else
            samespcs=0;

        int[] res = {maxDamage, samespcs};
        return res;
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