package hva.core;

public class Tree {
  private String _treeId;
  private String _name;
  private String _type;
  private int _age;
  private int _baseDiff; // Changed from String to int
  private String _season;
  private String _habitatId;

  public Tree(String treeId, String name, String type, int age, int baseDiff, String season, String habitatId) {
    this._treeId = treeId;
    this._name = name;
    this._type = type;
    this._age = age;
    this._baseDiff = baseDiff;
    this._season = season;
    this._habitatId = habitatId;
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

  public int getBaseDiff() {
    return _baseDiff;
  }

  public String getSeason() {
    return _season;
  }

  public void setSeason(String season) {
    this._season = season;
  }

  public String getHabitatId() {
    return _habitatId;
  }

  public void setHabitatId(String habitatId) {
    this._habitatId = habitatId;
  }

  /*
   * seasonal cleaning difficulty
   *     winter  spring  summer  autumn
   * CAD   0      1       2       5
   * PER   2      1       1       1
   */

  public int getSeasonalDifficulty() {
    int difficulty = 0;
    switch (_season) {
      case "Winter":
        difficulty = _type.equals("CAD") ? 0 : 2;
        break;
      case "Spring":
        difficulty = 1;
        break;
      case "Summer":
        difficulty = _type.equals("CAD") ? 2 : 1;
        break;
      case "Autumn":
        difficulty = _type.equals("CAD") ? 5 : 1;
        break;
    }
    return difficulty;
  }

  public double getCleaningEffort() {
    double seasonalDifficulty = getSeasonalDifficulty();
    int baseDifficulty = getBaseDiff();
    return baseDifficulty * seasonalDifficulty * Math.log(_age + 1);
  }
}