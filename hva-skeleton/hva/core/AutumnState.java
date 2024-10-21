package hva.core;

public class AutumnState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(Tree tree) {
        return tree instanceof Deciduous ? 5 : 1; // Autumn difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Winter";
    }
}