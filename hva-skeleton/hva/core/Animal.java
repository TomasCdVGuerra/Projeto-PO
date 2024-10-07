package hva.core;

public class Animal {
  private final String _id;
  private final String _name;
  private String _healthState;
  private Species _species;
  private Habitat _habitat;

  public Animal(String id, String name, String speciesId, String healthState, Species species, Habitat habitat) {
    this._id = id;
    this._name = name;
    this._healthState = healthState;
    this._species = species;
    this._habitat = habitat;
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  public String getHealthState() {
    return _healthState;
  }

  public Species getSpecies() {
    return _species;
  }

  public Habitat getHabitat() {
    return _habitat;
  }

  public double satisfaction() {
    int sameSpecies = getSameSpeciesCount();
    int differentSpecies = getDifferentSpeciesCount();
    double area = _habitat.getArea();
    int population = _habitat.getPopulation();
    double suitability = getSuitability();

    return 20 + 3 * sameSpecies - 2 * differentSpecies + (area / population) + suitability;
  }

  private int getSameSpeciesCount() {
    // Implement logic to count animals of the same species in the habitat
    return 0;
  }

  private int getDifferentSpeciesCount() {
    // Implement logic to count animals of different species in the habitat
    return 0;
  }

  private double getSuitability() {
    // Implement logic to calculate suitability of the habitat for this animal
    return 0.0;
  }
}