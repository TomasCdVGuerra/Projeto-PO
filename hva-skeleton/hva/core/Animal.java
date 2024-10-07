package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Animal {
  private final String _id;
  private final String _name;
  private String _healthState;
  private Species _species;
  private Habitat _habitat;
  private List<String> healthHistory;

  public Animal(String id, String name, String healthState, Species species, Habitat habitat) {
    this._id = id;
    this._name = name;
    this._healthState = healthState;
    this._species = species;
    this._habitat = habitat;
    this.healthHistory = new ArrayList<>();
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

  public void addVaccinationResult(int damage, boolean isSameSpecies) {
    String term;
    if (isSameSpecies) {
      if (damage == 0) {
        term = "NORMAL";
      } else if (damage >= 1 && damage <= 4) {
        term = "ACCIDENT";
      } else {
        term = "ERROR";
      }
    } else {
      term = "CONFUSATION";
    }
    healthHistory.add(term);
  }

  public List<String> getHealthHistory() {
    return healthHistory;
  }

  public double satisfaction() {
    int sameSpecies = getSameSpeciesCount();
    int differentSpecies = getDifferentSpeciesCount();
    double area = _habitat.getArea();
    int population = _habitat.getPopulation();
    double suitability = getSuitability();

    return 20 + 3 * sameSpecies - 2 * differentSpecies + (area / population) + suitability;
  }

  public int getSameSpeciesCount(List<Animal> animals) {
    int count = 0;
    for (Animal animal : animals) {
      if (animal.getSpecies().equals(this._species)) {
        count++;
      }
    }
    return count;
  }

  public int getDifferentSpeciesCount(List<Animal> animals) {
    int count = 0;
    for (Animal animal : animals) {
      if (!animal.getSpecies().equals(this._species)) {
        count++;
      }
    }
    return count;
  }
}