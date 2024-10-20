package hva.core;

public class SummerState implements SeasonState {
    @Override
    public int getSeasonalDifficulty(String type) {
        return type.equals("CAD") ? 2 : 1; // Summer difficulty based on type
    }

    @Override
    public String nextSeason() {
        return "Autumn";
    }
}