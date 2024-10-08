package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Species {
  private String _id;
  private String _name;
  private List<Animal> _animals;

  public Species(String id, String name) {
    this._id = id;
    this._name = name;
    this._animals = new ArrayList<>();
  }

  public List<Animal> getAnimals() {
    return _animals;
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  public void addAnimal(Animal animal) {
    _animals.add(animal);
  }

  public int getNVets() {
    // Implement logic to count veterinarians
    return _vets.size(); // Assuming _vets is a list of veterinarians
}

}