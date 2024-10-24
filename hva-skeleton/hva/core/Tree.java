package hva.core;

public class Tree extends HotelEntity {
    private final int _baseDiff;
    private int _age;
    private SeasonState _seasonState;
    private int _seasonCount;

    public Tree(String treeId, String name, int age, int baseDiff) {
        super(treeId, name);
        this._age = age;
        this._baseDiff = baseDiff;
        this._seasonState = new SpringState(); // Initial state
        this._seasonCount = 0; // Initialize season counter
    }

    public static Tree createTree(String treeId, String name, int age, int baseDiff, String type) {
        if (type.equals("CAD"))
            return new Deciduous(treeId, name, age, baseDiff);
        else if (type.equals("PER"))
            return new Evergreen(treeId, name, age, baseDiff);
        else {
            new Exception().printStackTrace();
            return null;
        }
        // Ensure that the type is either PER or CAD during registration
    }

    public int getAge() {
        return _age;
    }

    public int getBaseDiff() {
        return _baseDiff;
    }

    public int getSeasonalDifficulty() {
        return _seasonState.getSeasonalDifficulty(this);
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
    String className;
    if (this instanceof Deciduous) {
        className = "CADUCA";
    } else if (this instanceof Evergreen) {
        className = "PERENE";
    } else {
        className = this.getClass().getSimpleName();
    }

    return "ÁRVORE|" +
            this.getId() + '|' +
            this.getName() + '|' +
            this.getAge() + '|' +
            this.getBaseDiff() + '|' +
            className + '|' +
            this.getBiologicalCycle();
}

    private String getBiologicalCycle() {
        String cycle = "";

        // Determine the biological cycle based on the current season state
        if (_seasonState instanceof WinterState) {
            cycle = (this instanceof Deciduous) ? "SEMFOLHAS" : "LARGARFOLHAS";
        } else if (_seasonState instanceof SpringState) {
            cycle = "GERARFOLHAS";
        } else if (_seasonState instanceof SummerState) {
            cycle = "COMFOLHAS";
        } else if (_seasonState instanceof AutumnState) {
            cycle = (this instanceof Deciduous) ? "LARGARFOLHAS" : "COMFOLHAS";
        } else {
            cycle = "Ciclo desconhecido";
        }

        return cycle;
    }
}