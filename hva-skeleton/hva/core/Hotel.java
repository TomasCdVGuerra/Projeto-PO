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
  private final List<String> _IdResponsibilities;
  private final List<Vaccine> _vaccines;
  private final List<Tree> _trees;
  private final List<Habitat> _habitats;
  private final String _season;

  public Hotel() {
      _animals = new ArrayList<>();
      _species = new ArrayList<>();
      _employees = new ArrayList<>();
      _IdResponsibilities = new ArrayList<>();
      _vaccines = new ArrayList<>();
      _trees = new ArrayList<>();
      _habitats = new ArrayList<>();
      _season = "Spring";
  }

  public String getSeason(){
    return _season;
  }

  public void registerAnimal(String animalId, String name, String habitatId, String speciesId) throws OneOrMoreCoreExceptions {
    Animal i = new Animal(animalId, name, (Habitat) getFromId(EntityType.Habitat, habitatId), (Species) getFromId(EntityType.Species, speciesId));
    _animals.add(i);
    // Implementation here
  }

  public void registerSpecies(String speciesId, String name) throws OneOrMoreCoreExceptions {
    Species i = new Species(speciesId, name, this);
    _species.add(i);
    // Implementation here
  }

  public void registerEmployee(String employeeId, String name, String empType) throws OneOrMoreCoreExceptions {
    Employee i = new Employee(employeeId, name, empType);
    _employees.add(i);
    // Implementation here
  }

  public void addResponsibility(String employeeId, String responsibility) throws OneOrMoreCoreExceptions {
    Responsibility i = new Responsibility(responsibility);
    (Employee) getFromId(EntityType.Employee, employeeId)._listResponsabilities.add(i);
    _IdResponsibilities.add(i);   //adicionar só a employee ou ter array de resps tb?
    // Implementation here
  }

  public void registerVaccine(String vaccineId, String name, String[] speciesIds) throws OneOrMoreCoreExceptions {
    Vaccine i = new Vaccine(vaccineId, name, SpeciesIds);
    _vaccines.add(i);
    // Implementation here
  }

  public void createTree(String treeId, String name, String type, int age, int baseDiff) throws OneOrMoreCoreExceptions {
    Tree i = new Tree(treeId, name, type, age, baseDiff);
    _trees.add(i);
  }

  public void registerHabitat(String habitatId, String name, double area) throws OneOrMoreCoreExceptions {
    List<String> t = new ArrayList<>();
    Habitat i = new Habitat(habitatId, name, area, t);
    _habitats.add(i);
    // Implementation here
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
    throw new IllegalArgumentException("No matching Id: " + id);
}

  public List<Species> getSpecies() { return _species; }
  public List<Animal> getAnimals() { return _animals; }
  public List<Habitat> getHabitats() { return _habitats; }
  public List<Vaccine> getVaccines() { return _vaccines; }
  public List<Tree> getTrees() { return _trees; }
  public List<Employee> getEmployees() { return _employees; }

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
  }


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