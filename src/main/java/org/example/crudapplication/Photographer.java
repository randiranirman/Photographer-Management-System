package org.example.crudapplication;

public class Photographer  extends  User {


    private  String name ;

    public String getName() {
        return name;
    }

    public Double ratings=0.0;
    public Photographer(String name){

        this.name = name;
    }


    public Photographer(String username, String password) {
        super(username, password, "photographer");
    }
}
