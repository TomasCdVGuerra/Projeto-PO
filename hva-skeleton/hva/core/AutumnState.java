package hva.core;

public class AutumnState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(String type) {
        return type.equals("CAD") ? 5 : 1; // Autumn difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Winter";
    }
}