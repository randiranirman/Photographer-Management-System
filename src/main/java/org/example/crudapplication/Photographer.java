package org.example.crudapplication;

public class Photographer  extends  User {


    private  String name ;
    private double totalRating= 0.0;
    private int numRatings=0;
    public void addRatings(double ratings){
        totalRating += ratings;
        numRatings++;
    }
    public double getAverageRating() {
        if (numRatings == 0) return 0;
        return totalRating / numRatings;
    }



    public int getNumRatings() {
        return numRatings;
    }

    public String getName() {
        return name;
    }

    public Photographer(String name){

        this.name = name;
    }


    public Photographer(String username, String password) {
        super(username, password, "photographer");
    }
}
