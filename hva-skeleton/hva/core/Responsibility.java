package hva.core;

public class Responsibility {
    private String _id;
    private String _idEmployee;

    public Responsibility(String responsibility, String employee){
        _id=responsibility;
        _idEmployee=employee;
    }

    public String getEmployee(){
        return _idEmployee;
    }

    public String getId(){
        return _id;
    }
}