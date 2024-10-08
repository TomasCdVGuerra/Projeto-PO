package hva.core;

public class Animal extends hotelEntity {
    private final Species _species;
    private Habitat _habitat;
    private String _healthHistory;

    public Animal(String idAnimal, String name, Species species, Habitat habitat) {
        super(idAnimal, name);
        this._species = species;
        this._habitat = habitat;
        this._healthHistory = "";
    }

    public String getHealthHistory() {
        if (_healthHistory.isEmpty())
            return "VOID";
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
        _healthHistory += "," + term;
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

    public void changeHabitat(Habitat newHabitat) {
      if (this._habitat != null) {
        this._habitat.getAnimals().remove(this);
      }
      this._habitat = newHabitat;
      if (newHabitat != null) {
        newHabitat.addAnimal(this);
      }
    }

    @Override
    public String getEntityDetails() {
        return "Animal ID: " + getId() + ", Name: " + getName() + ", Species: " + _species.getName();
    }
}