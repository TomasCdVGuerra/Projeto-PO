package hva.core;

import hva.core.exception.*;
import java.io.*;
import java.util.*;

public class Hotel implements Serializable {

  @Serial
  private static final long serialVersionUID = 202407081733L;

  private List<Animal> _animals;
  private List<Species> _species;
  private List<Employee> _employees;
  private Map<String, List<String>> _responsibilities;
  private List<Vaccine> _vaccines;
  private List<Tree> _trees;
  private List<Habitat> _habitats;
  private String _season; // Add this line

  public Hotel() {
      _animals = new ArrayList<>();
      _species = new ArrayList<>();
      _employees = new ArrayList<>();
      _responsibilities = new HashMap<>();
      _vaccines = new ArrayList<>();
      _trees = new ArrayList<>();
      _habitats = new ArrayList<>();
      _season = "Spring"; // Initialize with a default value
  }

  public void registerAnimal(String animalId, String name, String habitatId, String speciesId) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerSpecies(String speciesId, String name) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerEmployee(String employeeId, String name, String empType) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void addResponsibility(String employeeId, String responsibility) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void registerVaccine(String vaccineId, String name, String[] speciesIds) throws OneOrMoreCoreExceptions {
    // Implementation here
  }

  public void createTree(String treeId, String name, String type, int age, int baseDiff, Habitat habitat) throws OneOrMoreCoreExceptions {
    Tree tree = new Tree(treeId, name, type, age, baseDiff, habitat); // Updated to match the Tree constructor
    _trees.add(tree);
}

  public Habitat registerHabitat(String habitatId, String name, double area) throws OneOrMoreCoreExceptions {
    // Implementation here
    return null;
  }

  public int getPopulation(Species species){
    Iterator<Animal> itr = _animals.Iterator();
    int res=0;

    while(itr.hasNext()){
      Animal i = itr.next();

      if(i._species.equals(species))  //falta animal class com ._species!!
        res++;
    }
    return res;
  }

  public int getNVets(Species species){
    Iterator<Employee> itr = _employees.Iterator();
    int res=0;

    while(itr.hasNext()){
      Employee i = itr.next();

      if(i._listResponsabilities.contains(species))  //falta animal class com ._species!!
        res++;
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
    // Implementation here
  }
}