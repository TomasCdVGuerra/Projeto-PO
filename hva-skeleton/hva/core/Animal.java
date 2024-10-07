package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Animal {
  private final String _id;
  private final String _name;
  private Species _species;
  private Habitat _habitat;
  private String _healthHistory;

  public Animal(String idAnimal, String name, String idSpecies, String idHabitat) {
    this._id = idAnimal;
    this._name = name;
    this._species = idSpecies;      //func recebe ids mas queremos guardar os objectos msm!!
    this._habitat = idHabitat;
    this._healthHistory = new String;
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  public String getHealthHistory() {
    return _healthHistory;
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
      term = "CONFUSION";
    }
    healthHistory+= "," + term;
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
    int count = 0;
    for (Animal animal : _habitat.getAnimals()) {
      if (animal.getSpecies().equals(this._species)) {
        count++;
      }
    }
    return count;
  }

  private int getDifferentSpeciesCount() {
    int count = 0;
    for (Animal animal : _habitat.getAnimals()) {
      if (!animal.getSpecies().equals(this._species)) {
        count++;
      }
    }
    return count;
  }

  private double getSuitability() {
    Adequation adequation = _habitat.getAdequationForSpecies(this._species);
    return adequation.getAdequationValue().getValue();
  }
}