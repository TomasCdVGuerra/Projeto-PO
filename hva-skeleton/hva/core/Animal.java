package hva.core;

import java.io.Serializable;

public class Animal extends HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private String _species;
    private String _habitat;
    private String _healthHistory;

    public Animal(String idAnimal, String name, String idSpecies, String idHabitat) {
        super(idAnimal, name);
        this._species = idSpecies;
        this._habitat = idHabitat;
        this._healthHistory = "";
    }

    //get methods

    public String getHealthHistory() {
        if (_healthHistory.isEmpty())
            return "VOID";
        return _healthHistory;
    }

    public String getSpecies() {
        return _species;
    }

    public String getHabitat() {
        return _habitat;
    }

    @Override
    public String toString(){
        return "ANIMAL|"+super.getId()+"|"+super.getName()+"|"+_species+"|"+getHealthHistory()+"|"+_habitat;

    }
}
