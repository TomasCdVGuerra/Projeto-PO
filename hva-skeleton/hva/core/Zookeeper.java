
package hva.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;
import java.lang.Override;  //override ja vem importado??

public class Zookeeper extends Employee{
    private List<Habitat> _habitatsManaged;
    
    @Override
    public int getSatisf(){
        int  sum = 0;
        Iterator<Species> itr = _habitatsManaged.iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += this.trabalhoHabitat(i) / i.getNVets(); //<--------!!! de onde sao esses metodos???
        }
        return 300-sum;
    }

    public int workInHabitat(Habitat habitat){
        Iterator<Species> itr = habitat._trees.iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += i.cleaningEffort();      //fazer cleaningEffort em treeclass
        }
        return habitat.area() + 3 * habitat.population() + sum;     // fazer area e population em habitat 
    }


    @Override
    public void addResponsibility(String idHabitat){
        Iterator<Habitat> itr = _listResponsabilities.iterator();

        while(itr.hasNext()){
            Habitat i = itr.next();
            
            if(i.equals(idHabitat)) //ve se ja tinha essa resp.
                return;
        }
        //falta ver se idSpecies corresponde a uma especie existente!!!

        _habitatsManaged.add(idHabitat); //<--------- Recebe id mas lista tem os habitats msm !!!
    }

    @Override
    public void removeResponsibility(String idHabitat){
        Iterator<Habitat> itr = _listResponsabilities.iterator();
        
        while(itr.hasNext()){
            Habitat i = itr.next();
         
            if(i.equals(idSpecies)){
                _listResponsabilities.remove(idHabitat);
                return;
            }
        }
        //exceção!! nao tinha essa responsabilidade
    }

}
    