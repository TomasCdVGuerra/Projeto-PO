package hva.core;

public class Animal {
  private final String _id;
  private final String _name;
  private final String _speciesId;

  public Animal(String id, String name, String speciesId) {
    this._id = id;
    this._name = name;
    this._speciesId = speciesId;
  }

  public String getId() {
    return _id;
  }

  public String getName() {
    return _name;
  }

  public String getSpeciesId() {
    return _speciesId;
  }
}