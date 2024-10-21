package hva.core;

public class SummerState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(Tree tree) {
        return tree instanceof Deciduous ? 2 : 1; // Summer difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Autumn";
    }
}