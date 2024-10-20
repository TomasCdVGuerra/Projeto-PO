package hva.core;

public class WinterState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(String type) {
        return type.equals("CAD") ? 0 : 2; // Winter difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Spring";
    }
}