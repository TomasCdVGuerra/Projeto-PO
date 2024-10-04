package hva.core;

public class Tree {
  private String _treeId;
  private String _name;
  private String _type;
  private int _age;
  private int _baseDiff;
  private static String _season = "Spring"; // Default season is Spring
  private Habitat _habitat; // Changed to Habitat object
  private int _seasonCount; // Counter for seasons to track aging

  public Tree(String treeId, String name, String type, int age, int baseDiff, Habitat habitat) {
    this._treeId = treeId;
    this._name = name;
    this._type = type;
    this._age = age;
    this._baseDiff = baseDiff;
    this._habitat = habitat;
    this._seasonCount = 0; // Initialize season counter
    habitat.addTree(this); // Add tree to habitat
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

  public static String getSeason() {
    return _season;
  }

  public Habitat getHabitat() {
    return _habitat;
  }

  public void setHabitat(Habitat habitat) {
    this._habitat = habitat;
    habitat.addTree(this); // Ensure tree is added to new habitat
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

  public int incrementSeason() {
    _seasonCount++;
    switch (_season) {
      case "Spring":
        _season = "Summer";
        break;
      case "Summer":
        _season = "Autumn";
        break;
      case "Autumn":
        _season = "Winter";
        break;
      case "Winter":
        _season = "Spring";
        break;
    }
    if (_seasonCount >= 4) {
      _age++;
      _seasonCount = 0;
    }
    switch (_season) {
      case "Spring":
        return 0;
      case "Summer":
        return 1;
      case "Autumn":
        return 2;
      case "Winter":
        return 3;
      default:
        return -1; // Should never reach here
    }
  }
}