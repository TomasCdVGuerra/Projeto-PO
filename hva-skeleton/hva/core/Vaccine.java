package hva.core;

import java.util.*;

public class Vaccine {
    private String _id;
    private String _name;
    private List<Species> _species;
    private List<VaccinationRecord> _records; // Marked as final

    public Vaccine(String id, String name, String species) {
        this.id = id;
        this.name = name;
        String[] lstIdsSpecies = species.split(",");
         _species = new ArrayList<>(Arrays.asList(lstIdsSpecies));
        this.records = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

"""    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }"""

    public List<VaccinationRecord> getRecords() {
        return records;
    }

    public void addRecord(Veterinarian vet, Animal animal, boolean success, String result) {
        records.add(new VaccinationRecord(vet, animal, new Date(), success, result));
    }

    public static class VaccinationRecord {
        private final Veterinarian vet; // Marked as final
        private final Animal animal; // Marked as final
        private final Date date; // Marked as final
        private final boolean success; // Marked as final
        private final String result; // Marked as final

        public VaccinationRecord(Veterinarian vet, Animal animal, Date date, boolean success, String result) {
            this.vet = vet;
            this.animal = animal;
            this.date = date;
            this.success = success;
            this.result = result;
        }

        public Veterinarian getVet() {
            return vet;
        }

        public Animal getAnimal() {
            return animal;
        }

        public Date getDate() {
            return date;
        }

        public boolean isSuccess() {
            return success;
        }

        public String getResult() {
            return result;
        }
    }
}