package org.example.crudapplication;

import java.util.Date;

public class Appointment {
    private Customer customer;
    private Photographer photographer;

    public Appointment(Customer customer, Photographer photographer){
        this.customer= customer;
        this.photographer= photographer;

    }


    public  String toDataString (){
         return customer.getName() +" booked" + photographer.getName();
    }
}
