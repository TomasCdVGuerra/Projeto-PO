package hva.core;

import java.util.*;

public class Vaccine extends HotelEntity{
    private List<String> _species; 
    private int _numAplicacoes;
    //private List<VaccinationRecord> _records; 

    public Vaccine(String id, String name, List<String> species) {
        super(id, name);
        this._species = species;
        //this._records = new ArrayList<>();
    }

    public List<String> getSpecies() {
        return _species;
    }

    @Override
    public String toString(){    
        String s="";
        String barra="";
        if(!(_species.isEmpty())){
           barra+="|"; 
            for(String ids:_species){
                if (s.length() > 0) {
                    s+=",";
                }
                s+=ids;
            }
        }
        return "VACINA|" + super.getId() + "|" + super.getName() +"|"+ _numAplicacoes + barra + s;
    }
}

/*     public List<VaccinationRecord> getRecords() {
        return _records;
    }

    public void addRecord(Veterinarian vet, Animal animal, boolean success, String result) {
        _records.add(new VaccinationRecord(vet, animal, new Date(), success, result));
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
    } */