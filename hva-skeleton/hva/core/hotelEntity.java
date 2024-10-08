package hva.core;

import java.util.*;

public abstract class HotelEntity {
    private Hotel _hotel;
    private String _id;
    private String _name;

    public HotelEntity(String id, String name){
        _id=id;
        _name=name;
    }

    public EntityType getFromId(EntityType type, String id){
        if(type==Species){
            Iterator<Species> itr = _hotel._species.iterator(); 
            while(itr.hasNext()){
                Species i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
        else if(type==Animal){
            Iterator<Animal> itr = _hotel._animals.iterator(); 
            while(itr.hasNext()){
                Animal i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
        else if(type==Habitat){
            Iterator<Habitat> itr = _hotel._habitats.iterator(); 
            while(itr.hasNext()){
                Habitat i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
        else if(type==Vaccine){
            Iterator<Vaccine> itr = _hotel._vaccines.iterator(); 
            while(itr.hasNext()){
                Vaccine i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
        else if(type==Tree){
            Iterator<Tree> itr = _hotel._trees.iterator(); 
            while(itr.hasNext()){
                Tree i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
        else if(type==Employee){
            Iterator<Employee> itr = _hotel._employees.iterator(); 
            while(itr.hasNext()){
                Employee i = itr.next();
                if(i._id.equals(id))
                    return i;
            }
            //n existe
        }
    }
}
