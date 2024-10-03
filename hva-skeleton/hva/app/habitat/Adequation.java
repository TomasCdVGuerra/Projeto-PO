package hva.app.habitat;

import hva.core.Hotel;
public class Adequation {
    private String _speciesId;
    private int _adequationValue;

    public Adequation(String speciesId, int adequationValue) {
        this._speciesId = speciesId;
        this._adequationValue = adequationValue;
    }

    public String getSpeciesId() {
        return _speciesId;
    }

    public int getAdequationValue() {
        return _adequationValue;
    }
}