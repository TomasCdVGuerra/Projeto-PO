package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
  private String _id;
  private String _name;
  private double _area;
  private int _population;
  private List<Tree> _trees;
  private List<Adequation> _adequations;
  private List<Handler> _handlers;
  private List<Animal> _animals;

  public Habitat(String habitatId, String name, double area, int population) {  
    this._habitatId = habitatId;
    this._name = name;
    this._area = area;
    this._population = population;
    this._trees = new ArrayList<>();
    this._adequations = new ArrayList<>();
    this._handlers = new ArrayList<>();
    this._animals = new ArrayList<>();
  }

  public String getId() {
    return _habitatId;
  }

  public String getName() {
    return _name;
  }

  public double getArea() {
    return _area;
  }

  public int getPopulation() {
    return _population;
  }

  public List<Tree> getTrees() {
    return _trees;
  }

  public void addTree(Tree tree) {
    _trees.add(tree);
  }

  public List<Adequation> getAdequations() {
    return _adequations;
  }

  public void addAdequation(Adequation adequation) {
    _adequations.add(adequation);
  }

  public void removeAdequation(Species species) {
    _adequations.removeIf(adequation -> adequation.getSpecies().equals(species));
  }

  public Adequation getAdequationForSpecies(Species species) {
    for (Adequation adequation : _adequations) {
      if (adequation.getSpecies().equals(species)) {
        return adequation;
      }
    }
    return new Adequation(species, Adequation.AdequationValue.NEUTRAL);
  }

  public List<Handler> getHandlers() {
    return _handlers;
  }

  public void addHandler(Handler handler) {
    _handlers.add(handler);
  }

  public void setHandlers(List<Handler> _handlers) {
    this._handlers = _handlers;
  }

  public List<Animal> getAnimals() {
    return _animals;
  }

  public void addAnimal(Animal animal) {
    _animals.add(animal);
  }
}