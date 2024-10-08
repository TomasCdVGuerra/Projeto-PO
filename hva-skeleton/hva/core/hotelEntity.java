package hva.core;

import java.util.*;

public abstract class HotelEntity {
    private String id;
    private String name;
    private Hotel _hotel;

    public HotelEntity(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EntityType getFromId(EntityType type, String id){
        switch (EntityType){
            case Species:
                Iterator<Species> itr = _hotel._species.iterator(); 
                while(itr.hasNext()){
                    Species i = itr.next();
                    if(i._id.equals(id))
                        return i;
                }

            case Animal:
                Iterator<Animal> itr = _hotel._animals.iterator(); 
                while(itr.hasNext()){
                    Animal i = itr.next();
                    if(i._id.equals(id))
                        return i;
                }
            case Habitat:
                Iterator<Habitat> itr = _hotel._habitats.iterator(); 
                while(itr.hasNext()){
                    Habitat i = itr.next();
                    if(i._id.equals(id))
                        return i;
            }
            case Vaccine:
                Iterator<Vaccine> itr = _hotel._vaccines.iterator(); 
                while(itr.hasNext()){
                    Vaccine i = itr.next();
                    if(i._id.equals(id))
                        return i;
            }
            case Tree:
                Iterator<Tree> itr = _hotel._trees.iterator(); 
                while(itr.hasNext()){
                    Tree i = itr.next();
                    if(i._id.equals(id))
                        return i;
            }
            case Employee:
                Iterator<Employee> itr = _hotel._employees.iterator(); 
                while(itr.hasNext()){
                    Employee i = itr.next();
                    if(i._id.equals(id))
                        return i;
                }
        }
    }
}