// hva-skeleton/hva/app/habitat/Tree.java
package hva.app.habitat;

import java.util.logging.Logger;

public class Tree {
    private String id;
    private String name;
    private int age;
    private String leafType; // "evergreen" or "deciduous"
    private int cleanDiff;
    private String season;
    private Habitat habitat;

    public Tree(String id, String name, int age, String leafType, int cleanDiff, String season, Habitat habitat) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.leafType = leafType;
        this.cleanDiff = cleanDiff;
        this.season = season;
        this.habitat = habitat;
    }

    public String getID() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getType() {
        return leafType;
    }

    public String getSeason() {
        return season;
    }

    public Habitat getHabitat() {
        return habitat;
    }

    public double getFinalCleanDiff() {
        double seasonalEffort = getSeasonalEffort();
        return cleanDiff * seasonalEffort * Math.log(age + 1);
    }

    private double getSeasonalEffort() {
        if (leafType.equals("evergreen")) {
            return season.equals("winter") ? 2 : 1;
        } else if (leafType.equals("deciduous")) {
            switch (season) {
                case "winter":
                    return 0;
                case "spring":
                    return 1;
                case "summer":
                    return 2;
                case "fall":
                    return 5;
                default:
                    Logger.getLogger(Tree.class.getName()).warning("Unknown season: " + season);
                    return 1; // Default effort if season is unknown
            }
        }
        Logger.getLogger(Tree.class.getName()).warning("Unknown leaf type: " + leafType);
        return 1; // Default effort if leaf type is unknown
    }
}