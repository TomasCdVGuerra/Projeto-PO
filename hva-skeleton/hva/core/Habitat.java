package hva.core;

import java.util.ArrayList;
import java.util.List;

public class Habitat {
  private String _habitatId;
  private String _name;
  private double _area;
  private List<Tree> _trees;

  public Habitat(String habitatId, String name, double area) {
    this._habitatId = habitatId;
    this._name = name;
    this._area = area;
    this._trees = new ArrayList<>();
  }

  public String getHabitatId() {
    return _habitatId;
  }

  public String getName() {
    return _name;
  }

  public double getArea() {
    return _area;
  }

  public List<Tree> getTrees() {
    return _trees;
  }

  public void addTree(Tree tree) {
    _trees.add(tree);
  }
}