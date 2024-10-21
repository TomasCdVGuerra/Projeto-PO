package hva.core;

public class WinterState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(Tree tree) {
        return tree instanceof Deciduous ? 0 : 2; // Winter difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Spring";
    }
}