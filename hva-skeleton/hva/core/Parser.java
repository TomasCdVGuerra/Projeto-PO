package hva.core;

import hva.app.exception.*;
import hva.core.exception.UnrecognizedEntryException;
import java.io.*;

/**
 * Esta solução assume que a classe Hotel já tem a seguinte funcionalidade

public class Hotel {
  public void registerAnimal(animalId, name, habitatId, speciesId) throws OneOrMoreCoreExceptions { ... }
  public void registerSpecies(speciesId, name) throws OneOrMoreCoreExceptions { ... }
  public void registerEmployee(employeeId, name, empType) throws OneOrMoreCoreExceptions { ... }
  public void addResponsibility(employeeId, responsibility) throws OneOrMoreCoreExceptions { ... }
  public void registerVaccine(vaccineId, name, String[] speciesIds) throws someCoreExceptionsOneOrMoreCoreExceptions { ... }
  public void createTree(TreeId, name, type, age, diff) throws OneOrMoreCoreExceptions { ... }
  public Habitat registerHabitat(habitatId, name, area) throws OneOrMoreCoreExceptions { ... }

Note-se que esta funcionalidade pode ser utilizada na concretização de alguns dos comandos.
Caso Hotel não tenha esta funcionalidade, então deverão substituir a invocação destes métodos
na classe Parser por uma ou mais linhas com uma funcionalidade semelhante.
Cada um destes métodos pode lançar uma ou mais excepções que irão corresponder aos erros que
podem acontecer ao nível do domínio surante a concretização da funcionalidade em causa.
**/

public class Parser {
  private Hotel _hotel;

  public Parser(Hotel h) {
    _hotel = h;
  }

  public void parseFile(String filename) throws IOException, UnrecognizedEntryException {
    try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
      String line;
      while ((line = reader.readLine()) != null) {
        parseLine(line);
      }
    }
  }

  private void parseLine(String line) throws UnrecognizedEntryException {
    String[] components = line.split("\\|");
    switch (components[0]) {
      case "ESPÉCIE" -> parseSpecies(components);
      case "ANIMAL" -> parseAnimal(components);
      case "ÁRVORE" -> parseTree(components);
      case "HABITAT" -> parseHabitat(components);
      case "TRATADOR" -> parseEmployee(components, "TRT");
      case "VETERINÁRIO" -> parseEmployee(components, "VET");
      case "VACINA" -> parseVaccine(components);
      default -> throw new UnrecognizedEntryException("tipo de entrada inválido: " + components[0]);
    }
  }

  private void parseAnimal(String[] components) throws UnrecognizedEntryException {
    String id = components[1];
    String name = components[2];
    String speciesId = components[3];
    String habitatId = components[4];
    _hotel.registerAnimal(id, name, speciesId, habitatId);
  }

  private void parseSpecies(String[] components) throws UnrecognizedEntryException {
    String id = components[1];
    String name = components[2];
    _hotel.registerSpecies(id, name);
  }

  private void parseEmployee(String[] components, String empType) throws UnrecognizedEntryException {
    try {
      String id = components[1];
      String name = components[2];
      String[] responsibilities = components[3].split(",");
      _hotel.registerEmployee(id, name, empType);
      for (String responsibility : responsibilities) {
        _hotel.getEmployee(id).addResponsibility(responsibility);
      }
    } catch (UnknownEmployeeKeyException e) {
      throw new UnrecognizedEntryException("Failed to add responsibilities: " + e.getMessage());
    }
  }

  private void parseVaccine(String[] components) {
    String id = components[1];
    String name = components[2];
    String[] speciesIds = components.length == 4 ? components[3].split(",") : new String[0];
    _hotel.registerVaccine(id, name, speciesIds);
  }

  private void parseTree(String[] components) throws UnrecognizedEntryException {
    String id = components[1];
    String name = components[2];
    int age = Integer.parseInt(components[3]);
    int diff = Integer.parseInt(components[4]);
    String type = components[5];
    _hotel.createTree(id, name, type, age, diff);
  }

  private void parseHabitat(String[] components) throws UnrecognizedEntryException {
    String id = components[1];
    String name = components[2];
    int area = Integer.parseInt(components[3]);
    _hotel.registerHabitat(id, name, area);
  }
}