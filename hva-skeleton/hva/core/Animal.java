package hva.core;

/**
 * Represents an Animal in the hotel.
 * This class extends HotelEntity, getting id and name attributes; and implements Serializable.
 */
public class Animal extends HotelEntity {
    private final String _species;
    private Habitat _habitat;
    private String _healthHistory;

    /**
     * Constructs an Animal.
     *
     * @param idAnimal the ID of the Animal
     * @param name the name of the Animal
     * @param idSpecies ID of the Species of the animal
     * @param habitat the Habitat of the animal
     */
    public Animal(String idAnimal, String name, String idSpecies, Habitat habitat) {
        super(idAnimal, name);
        this._species = idSpecies;
        this._habitat = habitat;
        this._healthHistory = "";
    }

    /**
     * Gets the health history of the Animal.
     *
     * @return the health history of the animal, or "VOID" if it is empty
     */
    public String getHealthHistory() {
        if (_healthHistory.isEmpty())
            return "VOID";
        return _healthHistory;
    }

    /**
     * Gets the Species of the Animal.
     *
     * @return the Species of the Animal
     */
    public String getSpecies() {
        return _species;
    }

    /**
     * Gets the Habitat of the Animal.
     *
     * @return the Habitat of the Animal
     */
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
    int especieIgual = this.getSameSpeciesCount();
    int especieDiferente = this.getDifferentSpeciesCount();

    double area = _habitat.getArea();
    int populacao = _habitat.getPopulation();
    int adequacao = this.getSuitability();

    double satisfacao = 20 + 3 * especieIgual - 2 * especieDiferente + (area / populacao) + adequacao;
    return satisfacao;
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

    private int getSuitability() {
        Adequation adequation = _habitat.getAdequationForSpecies(this._species);
    if (adequation == null) {
        throw new NullPointerException();
    }
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
    public String getId() {
        return super.getId(); // Assuming getId() is defined in HotelEntity
    }

    public void setHabitat(Habitat habitat) {
        _habitat = habitat;
    }

    /**
     * Returns a string representation of the Animal, used in DoShowAllAnimals.
     *
     * @return a string representation of the animal in the format:
     *         "ANIMAL|id|name|idSpecies|healthHistory|idHabitat"
     */
    @Override
    public String toString() {
        return "ANIMAL|" + super.getId() + "|" + super.getName() + "|" + _species + "|" + getHealthHistory() + "|" + _habitat.getId();
    }
}