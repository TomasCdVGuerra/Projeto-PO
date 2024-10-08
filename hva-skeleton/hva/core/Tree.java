package hva.core;

public class Tree extends HotelEntity {
    private final String _type;
    private final int _baseDiff;
    private int _age;
    private static String _season = "Spring"; // Default season is Spring
    private Habitat _habitat; // Changed to Habitat object
    private int _seasonCount; // Counter for seasons to track aging

    public Tree(String treeId, String name, String type, int age, int baseDiff, Habitat habitat) {
        super(treeId, name);
        this._type = type;
        this._age = age;
        this._baseDiff = baseDiff;
        this._habitat = habitat;
        this._seasonCount = 0; // Initialize season counter
    }

    public void initHabitat() {
        _habitat.addTree(this); // Add tree to habitat after construction
    }

    public String getTreeId() {
        return getId();
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

    public int getSeasonalDifficulty() {
        return switch (_season) {
            case "Winter" -> _type.equals("CAD") ? 0 : 2;
            case "Spring" -> 1;
            case "Summer" -> _type.equals("CAD") ? 2 : 1;
            case "Autumn" -> _type.equals("CAD") ? 5 : 1;
            default -> 0;
        };
    }

    public double getCleaningEffort() {
        double seasonalDifficulty = getSeasonalDifficulty();
        int baseDifficulty = getBaseDiff();
        return baseDifficulty * seasonalDifficulty * Math.log(_age + 1);
    }

    public int incrementSeason() {
        _seasonCount++;
        _season = switch (_season) {
            case "Spring" -> "Summer";
            case "Summer" -> "Autumn";
            case "Autumn" -> "Winter";
            case "Winter" -> "Spring";
            default -> _season;
        };
        if (_seasonCount >= 4) {
            _age++;
            _seasonCount = 0;
        }
        return switch (_season) {
            case "Spring" -> 0;
            case "Summer" -> 1;
            case "Autumn" -> 2;
            case "Winter" -> 3;
            default -> -1; // Should never reach here
        };
    }

    public String getEntityDetails() {
        return "Tree ID: " + getId() + ", Name: " + getName() + ", Type: " + _type;
    }
}