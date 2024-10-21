package hva.core;

public class SpringState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(Tree tree) {
        return 1; // Spring difficulty
    }

    @Override
    public String nextSeason() {
        return "Summer";
    }
}