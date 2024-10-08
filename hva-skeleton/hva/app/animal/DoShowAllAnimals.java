package hva.app.animal;

import hva.core.Hotel;
import pt.tecnico.uilib.menus.Command;
import java.util.Iterator;
//FIXME add more imports if needed

/**
 * Show all animals registered in this zoo hotel.
 */
class DoShowAllAnimals extends Command<Hotel> {
  private String _toPrint;


  DoShowAllAnimals(Hotel receiver) {
    _toPrint = new String();
    //------------codigo do stor\/----------------
    super(Label.SHOW_ALL_ANIMALS, receiver);
    """_last = last; --bool
    _title = title; --str
    _receiver = receiver; --Hotel
    _form = new Form(_title); --Form(dialog, str)
    _display = new Display(_title); --Display(dialog,str)
    _valid = valid; --Predicate<Reciever>"""
    //--------------------------------------------
    Iterator<Animal> itr = _reciever._animals.iterator();
    while(itr.hasNext()){
      Animal i = itr.next();

      _toPrint += "ANIMAL|" + i.getId() + "|" + i.getName() + "|" + i.getSpecies().getId() + "|" + i.getHealthHistory() + "|" + i.getHabitat().getId() + "\n";
    }
  }
  
  @Override
  protected final void execute() {
    System.out.print(_toPrint);
    //_reciever.stringField e _display.popup;???    <---------------------
    //FIXME implement command
  }
}
