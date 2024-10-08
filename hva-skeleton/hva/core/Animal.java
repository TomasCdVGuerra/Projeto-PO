package hva.core;

public class Animal {
  private final String _id;
  private final String _name;
  private final Species _species;
  private Habitat _habitat;
  private String _healthHistory;

  public Animal(String idAnimal, String name, Species species, Habitat habitat) {
    this._id = idAnimal;
    this._name = name;
    this._species = species;
    this._habitat = habitat;
    this._healthHistory = "";
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  public Species getSpecies() {
    return _species;
  }

  public Habitat getHabitat() {
    return _habitat;
  }

  public String getHealthHistory() {
    if (_healthHistory.isEmpty())
      return "VOID";
    return _healthHistory;
  }

  public void changeHabitat(Habitat newHabitat) {
    if (this._habitat != null) {
      this._habitat.getAnimals().remove(this);
    }
    this._habitat = newHabitat;
    if (newHabitat != null) {
      newHabitat.addAnimal(this);
    }
  }
}