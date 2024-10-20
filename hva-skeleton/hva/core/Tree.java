package hva.core;

public class Tree extends HotelEntity {
    private final String _type;
    private final int _baseDiff;
    private int _age;
    private SeasonState _seasonState;
    private int _seasonCount;

    public Tree(String treeId, String name, String type, int age, int baseDiff) {
        super(treeId, name);
        this._type = type;
        this._age = age;
        this._baseDiff = baseDiff;
        this._seasonState = new SpringState(); // Initial state
        this._seasonCount = 0; // Initialize season counter
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

    public int getSeasonalDifficulty() {
        return _seasonState.getSeasonalDifficulty(_type);
    }

    public double getCleaningEffort() {
        double seasonalDifficulty = getSeasonalDifficulty();
        int baseDifficulty = getBaseDiff();
        return baseDifficulty * seasonalDifficulty * Math.log(_age + 1);
    }

    public int incrementSeason() {
        _seasonCount++;
        _seasonState = switch (_seasonState.nextSeason()) {
            case "Summer" -> new SummerState();
            case "Autumn" -> new AutumnState();
            case "Winter" -> new WinterState();
            case "Spring" -> new SpringState();
            default -> _seasonState;
        };
        if (_seasonCount >= 4) {
            _age++;
            _seasonCount = 0;
        }
        return switch (_seasonState.nextSeason()) {
            case "Spring" -> 0;
            case "Summer" -> 1;
            case "Autumn" -> 2;
            case "Winter" -> 3;
            default -> -1; // Should never reach here
        };
    }

    @Override
    public String toString() {
        return "Tree{" +
                "type='" + _type + '\'' +
                ", baseDiff=" + _baseDiff +
                ", age=" + _age +
                ", seasonState=" + _seasonState.getClass().getSimpleName() +
                ", seasonCount=" + _seasonCount +
                '}';
    }
}