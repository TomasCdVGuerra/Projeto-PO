package hva.app.main;

public class Menu extends pt.tecnico.uilib.menus.Menu {

  public Menu(hva.core.HotelManager receiver) {
    super(Label.TITLE, //
          new DoNewFile(receiver),//Create a new file
          new DoOpenFile(receiver),//Open a file
          new DoSaveFile(receiver),//Save a file
          new DoAdvanceSeason(receiver),//Advance the season
          new DoShowGlobalSatisfaction(receiver),//Show global satisfaction
          new DoOpenAnimalsMenu(receiver),//Open the animals menu
          new DoOpenEmployeesMenu(receiver),//Open the employees menu
          new DoOpenHabitatsMenu(receiver),//Open the habitats menu
          new DoOpenVaccinesMenu(receiver),//Open the vaccines menu
          new DoOpenLookupsMenu(receiver)//Open the lookups menu
          );
  }
}
