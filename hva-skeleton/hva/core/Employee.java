package hva.core;

import java.util.ArrayList;
import java.util.List;

public abstract class Employee{
    private String _name;
    private String _id;
    private int _satisfLevel;
    private String _type;
    private Hotel _hotel;
    private Responsibility _listResponsabilities;


    public Employee(String id, String name, String type){
        
        if(type.equals("VET") || type.equals("TRT")){
            _type=type;
            _name=name;
            _id=id;
            List<Responsibility> _listResponsabilities= new ArrayList<>();
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

    abstract void addResponsibility(String id);

    public void removeResponsibility(String id);

    public String getType(){
        return _type;
    }

    public List<Responsibility> getResponsabilities(){
        return _listResponsabilities;
    }

}
