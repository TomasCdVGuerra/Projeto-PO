package hva.core;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Vaccine {
    private final String id;
    private String name;
    private Species species;
    private List<VaccinationRecord> records;

    public Vaccine(String id, String name, Species species) {
        this.id = id;
        this.name = name;
        this.species = species;
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

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    public List<VaccinationRecord> getRecords() {
        return records;
    }

    public void addRecord(Vet vet, Animal animal, boolean success, String result) {
        records.add(new VaccinationRecord(vet, animal, new Date(), success, result));
    }

    public static class VaccinationRecord {
        private Vet vet;
        private Animal animal;
        private Date date;
        private boolean success;
        private String result;

        public VaccinationRecord(Vet vet, Animal animal, Date date, boolean success, String result) {
            this.vet = vet;
            this.animal = animal;
            this.date = date;
            this.success = success;
            this.result = result;
        }

        public Vet getVet() {
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