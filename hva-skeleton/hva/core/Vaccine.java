package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Species extends HotelEntity {
  private List<Animal> _animals;

  public Species(String id, String name) {
    super(id, name);
    this._animals = new ArrayList<>();
  }

  public List<Animal> getAnimals() {
    return _animals;
  }

  public void addAnimal(Animal animal) {
    _animals.add(animal);
  }

  public int getNVets() {
    // Implement logic to count veterinarians
    return _vets.size(); // Assuming _vets is a list of veterinarians
  }

  @Override
  public String getEntityDetails() {
    return "Species ID: " + getId() + ", Name: " + getName();
  }
}