package org.example.crudapplication;

public class User {
    protected  String username;
    protected  String password;
    protected  String  role ;


    public User(String username, String password,String role){
        this.username= username;
        this.password= password;
        this.role= role;
    }
    public User(){

    }

    public String toDataString(){
        return username + "," + password+ "," + role
                ;
    }



}
