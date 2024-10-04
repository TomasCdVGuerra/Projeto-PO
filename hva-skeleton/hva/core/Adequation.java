package hva.core;

public class Adequation {
  public enum AdequationValue {
    POSITIVE(20),
    NEUTRAL(0),
    NEGATIVE(-20);

    private final int value;

    AdequationValue(int value) {
      this.value = value;
    }

    public int getValue() {
      return value;
    }
  }

  private Species _species;
  private AdequationValue _adequationValue;

  public Adequation(Species species, AdequationValue adequationValue) {
    this._species = species;
    this._adequationValue = adequationValue;
  }

  public Species getSpecies() {
    return _species;
  }

  public void setSpecies(Species species) {
    this._species = species;
  }

  public AdequationValue getAdequationValue() {
    return _adequationValue;
  }

  public void setAdequationValue(AdequationValue adequationValue) {
    this._adequationValue = adequationValue;
  }
}