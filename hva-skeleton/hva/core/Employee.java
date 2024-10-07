public abstract class Employee{
    private String name;
    private String id;
    private int _satisfLevel;
    private String _type;
    private Hotel _hotel;
    private Responsability _listResponsabilities;


    public Employee(String id, String name, String type){
        
        if(type.equals("VET") || type.equals("TRT")){
            _type=type;
            _name=name
            _id=id;
            List<Responsability> _listResponsabilities= new ArrayList<>();
            //ver como por o hotel correspondente!!<-----
        }
        //exception
    }

    public Hotel getHotel(){
        return _hotel;
    }

    public String getID(){
        return _id;
    }

    public String getName(){
        return _name;
    }

    abstract int getSatisf();

    abstract void addResponsability();

    public void removeResponsability();

    public String getType(){
        return _type;
    }

    public List<Responsability> getResponsabilities(){
        return _listResponsabilities;
    }

}

public class Veterinarian{
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
    public void addResponsability(String idSpecies){
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
    public void removeResponsability(String idSpecies){
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

public class Zookeeper{
    private List<Habitat> _habitatsManaged;
    
    @Override
    public int getSatisf(){
        int  sum = 0;
        Iterator<Species> itr = _habitatsManaged.Iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += this.trabalhoHabitat(i) / i.getNVets(); //<--------!!! de onde sao esses metodos???
        }
        return 300-sum;
    }

    public int workInHabitat(Habitat habitat){
        Iterator<Species> itr = habitat._trees.Iterator();

        while(itr.hasNext()) {
            Species i = itr.next();

            sum += i.cleaningEffort();      //fazer cleaningEffort em treeclass
        }
        return habitat.area() + 3 * habitat.population() + sum;     // fazer area e population em habitat 
    }


    @Override
    public void addResponsability(String idHabitat){
        Iterator<Habitat> itr = _listResponsabilities.Iterator();

        while(itr.hasNext()){
            Habitat i = itr.next();
            
            if(i.equals(idHabitat)) //ve se ja tinha essa resp.
                return;
        }
        //falta ver se idSpecies corresponde a uma especie existente!!!

        _habitatsManaged.add(idHabitat); //<--------- Recebe id mas lista tem os habitats msm !!!
    }

    @Override
    public void removeResponsability(String idHabitat){
        Iterator<Habitat> itr = _listResponsabilities.Iterator();
        
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
    
