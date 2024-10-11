package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.*;

public class Hotel implements Serializable {

  @Serial
  private static final long serialVersionUID = 202407081733L;

  private final List<Animal> _animals;
  private final List<Species> _species;
  private final List<Employee> _employees;
  private final List<Responsibility> _responsibilities;
  private final List<Vaccine> _vaccines;
  private final List<Tree> _trees;
  private final List<Habitat> _habitats;
  private final String _season;

  public Hotel() {
      _animals = new ArrayList<>();
      _species = new ArrayList<>();
      _employees = new ArrayList<>();
      _responsibilities = new ArrayList<>();
      _vaccines = new ArrayList<>();
      _trees = new ArrayList<>();
      _habitats = new ArrayList<>();
      _season = "Spring";
  }

  public String getSeason(){
    return _season;
  }

  public void registerAnimal(String animalId, String name, String habitatId, String speciesId) {
    
    Animal i = new Animal(animalId, name, speciesId, habitatId);
    _animals.add(i);
    // Implementation here
  }

  public void registerSpecies(String speciesId, String name) {
    Species i = new Species(speciesId, name, this);
    _species.add(i);
    // Implementation here
  }

  public void registerEmployee(String employeeId, String name, String empType) {
    Employee i=null;
    if(empType.equals("TRT")){
      i = new Zookeeper(employeeId, name);
    }
    else if(empType.equals("VET")){
      i = new Veterinarian(employeeId, name);
    }
    if(i!=null){
      _employees.add(i);
    }
    // Implementation here
  }

  public void addResponsibility(String employeeId, String responsibility)  {
    Responsibility i = new Responsibility(responsibility, employeeId);
    for(Employee element: _employees){
      if(element.getId().equals(employeeId)){
        if(element instanceof Zookeeper)
          ((Zookeeper) element).getHabitatsM().add(i.getId());
        else if(element instanceof Veterinarian){
          ((Veterinarian) element).getSpeciesIds().add(i.getId());
        }
      }
    }
    _responsibilities.add(i);   //adicionar só a employee ou ter array de resps tb?
    // Implementation here
  }

  public void registerVaccine(String vaccineId, String name, String[] speciesIds)  {
    List<String> Species = new ArrayList<>();
    for(String element : speciesIds){
      Species.add(element);
    }
    Vaccine i = new Vaccine(vaccineId, name, Species);
    _vaccines.add(i);
    // Implementation here
  }

  public void addTreeToHabitat(String idHabitat, String idTree){
    for(Habitat element: _habitats){
      if(element.getId().equals(idHabitat))
        element.addTree(idTree);
    }
  }

  public void createTree(String treeId, String name, String type, int age, int baseDiff)  {
    Tree i = new Tree(treeId, name, type, age, baseDiff);
    _trees.add(i);
  }

  public void registerHabitat(String habitatId, String name, int area)  {
    Habitat i = new Habitat(habitatId, name, area);
    _habitats.add(i);
    // Implementation here
  }

  public List<Species> getSpecies() {
    _species.sort((s1, s2) -> s1.getId().compareTo(s2.getId()));
    return _species;
  }

  public List<Animal> getAnimals() { 
    _animals.sort((a1, a2) -> a1.getId().compareTo(a2.getId()));
    return _animals;
  }

  public List<Habitat> getHabitats() {
    _habitats.sort((h1, h2) -> h1.getId().compareTo(h2.getId()));
    return _habitats;
  }

  public List<Vaccine> getVaccines() {
    _vaccines.sort((v1, v2) -> v1.getId().compareTo(v2.getId()));
    return _vaccines;
  }
  public List<Tree> getTrees() {
    _trees.sort((t1, t2) -> t1.getId().compareTo(t2.getId()));
    return _trees;
  }
  public List<Employee> getEmployees() {
    _employees.sort((e1, e2) -> e1.getId().compareTo(e2.getId()));
    return _employees;
  }


/*
  public Object getFromId(EntityType type, String id) {
    switch (type) {
        case Species:
            for (Species species : getSpecies()) {
                if (species.getId().equals(id)) {
                    return species;
                }
            }
            break;
        case Animal:
            for (Animal animal : getAnimals()) {
                if (animal.getId().equals(id)) {
                    return animal;
                }
            }
            break;
        case Habitat:
            for (Habitat habitat : getHabitats()) {
                if (habitat.getId().equals(id)) {
                    return habitat;
                }
            }
            break;
        case Vaccine:
            for (Vaccine vaccine : getVaccines()) {
                if (vaccine.getId().equals(id)) {
                    return vaccine;
                }
            }
            break;
        case Tree:
            for (Tree tree : getTrees()) {
                if (tree.getId().equals(id)) {
                    return tree;
                }
            }
            break;
        case Employee:
            for (Employee employee : getEmployees()) {
                if (employee.getId().equals(id)) {
                    return employee;
                }
            }
            break;
        default:
            throw new IllegalArgumentException("Unknown EntityType: " + type);
    }
    throw new IllegalArgumentException("No matching Id: " + id);
}

  public int getPopulation(Species species) {
    Iterator<Animal> itr = _animals.iterator();
    int res = 0;

    while (itr.hasNext()) {
        Animal i = itr.next();
        if (i.getSpecies().equals(species)) {
            res++;
        }
    }
    return res;
  }

  public int getNVets(Species species) {
    Iterator<Employee> itr = _employees.iterator();
    int res = 0;

    while (itr.hasNext()) {
        Employee i = itr.next();
        if (i.getResponsabilities().contains(species)) {
            res++;
        }
    }
    return res;
  } */


  /**
   * Read text input file and create corresponding domain entities.
   * 
   * @param filename name of the text input file
   * @throws UnrecognizedEntryException if some entry is not correct
   * @throws IOException if there is an IO erro while processing the text file
   **/
  void importFile(String filename) throws UnrecognizedEntryException, IOException {
    Parser parser = new Parser(this);
    parser.parseFile(filename);
    }
  }