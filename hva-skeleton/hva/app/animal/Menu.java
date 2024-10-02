package hva.app.animal;

public class Menu extends pt.tecnico.uilib.menus.Menu {

  public Menu(hva.core.Hotel receiver) {
    super(Label.TITLE, //
          new DoShowAllAnimals(receiver),//Visualize all animals
          new DoRegisterAnimal(receiver),//Register new animal
          new DoTransferToHabitat(receiver),//transfer animal to habitat
          new DoShowSatisfactionOfAnimal(receiver)//Show satisfaction of an animal
          );
  }
  
}
