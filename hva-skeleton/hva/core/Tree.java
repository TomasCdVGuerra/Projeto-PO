package hva.core;

public class Tree {
  private String _treeId;
  private String _name;
  private String _type;
  private int _age;
  private String _diff;
  private String _season;

  public Tree(String treeId, String name, String type, int age, String diff, String season) {
    this._treeId = treeId;
    this._name = name;
    this._type = type;
    this._age = age;
    this._diff = diff;
    this._season = season;
  }

  public String getTreeId() {
    return _treeId;
  }

  public String getName() {
    return _name;
  }

  public String getType() {
    return _type;
  }

  public int getAge() {
    return _age;
  }

  public String getDiff() {
    return _diff;
  }

  public String getSeason() {
    return _season;
  }

  public void setSeason(String season) {
    this._season = season;
  }
}