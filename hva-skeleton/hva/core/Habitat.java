package hva.core;

import java.io.Serializable;
import java.util.*;

public class Habitat extends HotelEntity implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int _area;
    private final int _population;
    private List<String> _trees;
    private List<String> _zookeepers;
    private final List<String> _animals;
    private final List<String> _species;

    
    public Habitat(String habitatId, String name, int area) {  
        super(habitatId, name);
        this._area = area;
        this._population = 0;
        this._trees = new ArrayList<>();
        this._zookeepers = new ArrayList<>();
        this._animals = new ArrayList<>();
        this._species = new ArrayList<>();
    }

    //get methods

    public int getArea() {
        return _area;
    }

    public int getPopulation() {
        return _population;
    }

    public List<String> getAnimals() {
        return _animals;
    }

    public List<String> getTree() {
        return _trees;
    }

    public List<String> getSpecies() {
        return _species;
    }

    public List<String> getZookeepers() {
        return _zookeepers;
    }

    //add Entities to be part of this Hotel.

    public void addTree(String idTree) {
        _trees.add(idTree);
    }
    
    public void addZookeeper(String idZookeeper) {
        _zookeepers.add(idZookeeper);
    }

    public void addAnimal(String idAnimal) {
        _animals.add(idAnimal);
    }

    public int getNumTrees(){
        return _trees.size();
    }


    @Override
    public String toString(){
        return "HABITAT|" + super.getId()+"|" + super.getName() + "|" + _area + "|" + getNumTrees();
    }
}