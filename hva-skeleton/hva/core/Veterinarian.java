package hva.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.Override;  //override ja vem importado?

public class Veterinarian extends Employee{
    private List<Species> _canVacinate;
    
    @Override
    public int getSatisf(){
        int  sum = 0;
        Iterator<Species> itr = _canVacinate.iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += _hotel.getPopulation(i) / _hotel.getNVets(i);
        }
        return 20-sum;
    }
    
    @Override
    public void addResponsibility(String idSpecies){
        Iterator<Species> itr = _listResponsabilities.iterator();

        while(itr.hasNext()){
            Species i = itr.next();
            
            if(i.equals(idSpecies)) //ve se ja tinha essa resp. !!compara Species com SpeciesID
                return;
        }
        Iterator<Species> chk = _hotel._species.iterator();
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
        Iterator<Species> itr = _listResponsabilities.iterator();
        
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