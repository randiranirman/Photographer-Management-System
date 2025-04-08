package org.example.crudapplication;

public class Customer extends  User {
    private String name ;

    public String getName() {
        return name;
    }
    public Customer(String name){
        this.name= name;

    }


    public Customer(String username, String password) {
        super(username, password, "customer");
    }
        

}
