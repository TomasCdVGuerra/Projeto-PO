package hva.core;

public class Animal {
  private String _id;
  private String _name;
  private String _speciesId;

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