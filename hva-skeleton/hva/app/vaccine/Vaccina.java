package hva.app.vaccine;

import java.util.ArrayList;
import java.util.List;

public class Vaccine {
    private String _id;
    private String _name;
    private List<Species> _speciesList;

    public Vaccine() {
        _speciesList = new ArrayList<>();
    }

    public Vaccine(String id, String name) {
        this._id = id;
        this._name = name;
        this._speciesList = new ArrayList<>();
    }

    public void addSpecies(Species species) {
        _speciesList.add(species);
    }

    public void remSpecies(Species species) {
        _speciesList.remove(species);
    }

    public int sizeNames() {
        int maxSize = 0;
        for (Species species : _speciesList) {
            for (Species otherSpecies : _speciesList) {
                if (!species.equals(otherSpecies)) {
                    int size = Math.max(species.getName().length(), otherSpecies.getName().length());
                    int commonChars = commonCharacters(species.getName(), otherSpecies.getName());
                    maxSize = Math.max(maxSize, size - commonChars);
                }
            }
        }
        return maxSize;
    }

    public int damage(Vaccine vaccine, Animal animal) {
        int maxDamage = 0;
        for (Species species : vaccine._speciesList) {
            String speciesName = species.getName();
            String animalSpeciesName = animal.getSpecies().getName();
            int maxSize = Math.max(speciesName.length(), animalSpeciesName.length());
            int commonChars = commonCharacters(speciesName, animalSpeciesName);
            int damage = maxSize - commonChars;
            maxDamage = Math.max(maxDamage, damage);
        }
        return maxDamage;
    }

    private int commonCharacters(String str1, String str2) {
        int[] charCount1 = new int[256];
        int[] charCount2 = new int[256];

        for (char c : str1.toCharArray()) {
            charCount1[c]++;
        }

        for (char c : str2.toCharArray()) {
            charCount2[c]++;
        }

        int commonCount = 0;
        for (int i = 0; i < 256; i++) {
            commonCount += Math.min(charCount1[i], charCount2[i]);
        }

        return commonCount;
    }
}