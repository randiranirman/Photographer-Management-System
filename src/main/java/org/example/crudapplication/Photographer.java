package org.example.crudapplication;

public class Photographer  extends  User {



    public Double ratings=0.0;

    public Photographer(String username, String password) {
        super(username, password, "photographer");
    }
}
