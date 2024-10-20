package hva.core;

public class SpringState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(String type) {
        return 1; // Spring difficulty
    }

    @Override
    public String nextSeason() {
        return "Summer";
    }
}