package hva.app.main;

import hva.core.Animal;
import hva.core.HotelManager;
import pt.tecnico.uilib.menus.Command;

/**
 * Command for show the global satisfation of the current zoo hotel.
 **/
class DoShowGlobalSatisfaction extends Command<HotelManager> {
  DoShowGlobalSatisfaction(HotelManager receiver) {
    super(hva.app.main.Label.SHOW_GLOBAL_SATISFACTION, receiver);
  }
  
  @Override
  protected final void execute() {
    double sum=0;
    for(Animal a : _receiver.getHotel().getAnimals()){
      sum+=a.satisfaction();
    }
    
    _display.popup(sum);
  }
}