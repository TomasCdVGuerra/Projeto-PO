package hva.core;

public interface SeasonState {
    int getSeasonalDifficulty(String type);
    String nextSeason();
}