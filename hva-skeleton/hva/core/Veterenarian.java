package hva.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.Override;

public class Veterenarian extends Employee{
    private List<Species> _canVacinate;
    
    @Override
    public int getSatisf(){
        int  sum = 0;
        Iterator<Species> itr = _canVacinate.Iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += _hotel.getPopulation(i) / _hotel.getNVets(i);
        }
        return 20-sum;
    }
    
    @Override
    public void addResponsibility(String idSpecies){
        Iterator<Species> itr = _listResponsabilities.Iterator();

        while(itr.hasNext()){
            Species i = itr.next();
            
            if(i.equals(idSpecies)) //ve se ja tinha essa resp. !!compara Species com SpeciesID
                return;
        }
        Iterator<Species> chk = _hotel._species.Iterator();
        while(chk.hasNext()){
            Species i = chk.next();

            if(i.equals(idSpecies)){
                _canVacinate.add(idSpecies); //<--------- Recebe id mas lista tem as species !!!
                return;
            }
        }
        //exceção!! especie não exister
    }

    @Override
    public void removeResponsibility(String idSpecies){
        Iterator<Species> itr = _listResponsabilities.Iterator();
        
        while(itr.hasNext()){
            Species i = itr.next();
         
            if(i.equals(idSpecies)){
                _listResponsabilities.remove(idSpecies);
                return;
            }
        }
        //exceção!! nao tinha essa responsabilidade
    }

}