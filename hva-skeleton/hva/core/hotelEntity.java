package hva.core;

import java.util.*;

public abstract class HotelEntity {
    private String id;
    private String name;
    private Hotel _hotel;

    public HotelEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getFromId(EntityType type, String id) {
        switch (type) {
            case Species:
                for (Species species : _hotel.getSpecies()) {
                    if (species.getId().equals(id)) {
                        return species;
                    }
                }
                break;
            case Animal:
                for (Animal animal : _hotel.getAnimals()) {
                    if (animal.getId().equals(id)) {
                        return animal;
                    }
                }
                break;
            case Habitat:
                for (Habitat habitat : _hotel.getHabitats()) {
                    if (habitat.getId().equals(id)) {
                        return habitat;
                    }
                }
                break;
            case Vaccine:
                for (Vaccine vaccine : _hotel.getVaccines()) {
                    if (vaccine.getId().equals(id)) {
                        return vaccine;
                    }
                }
                break;
            case Tree:
                for (Tree tree : _hotel.getTrees()) {
                    if (tree.getId().equals(id)) {
                        return tree;
                    }
                }
                break;
            case Employee:
                for (Employee employee : _hotel.getEmployees()) {
                    if (employee.getId().equals(id)) {
                        return employee;
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Unknown EntityType: " + type);
        }
        return null;
    }
}