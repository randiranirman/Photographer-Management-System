package org.example.crudapplication.sevlets;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;




public class BookFileHandler {
    private final String FILEPATH ="booking.txt";
    public void saveBooking(String customerName , String photographerName){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true))) {
            writer.write(customerName + "," + photographerName);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public String readBookings (){
        StringBuilder sb  = new StringBuilder();
        try {
            Files.lines(Paths.get(FILEPATH)).forEach(sb::append);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }



}
