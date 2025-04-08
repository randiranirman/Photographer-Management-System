package org.example.crudapplication.sevlets;

import org.example.crudapplication.Photographer;
import org.example.crudapplication.User;

import java.io.*;
import java.util.ArrayList;

public class PhotographerFileHandler {
    private final String FILE_PATH = "photograher.txt";


    public void savePhotographer(User photographer){
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH,true))){
        writer.write(photographer.getUsername() +","+ photographer.getPassword() + "," + photographer.getRole());
        writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
    public ArrayList<User> getAllPhotographers() {
        ArrayList<User> photographers = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    String username = parts[0];
                    String password = parts[1];
                    String role = parts[2];

                    if ("photographer".equalsIgnoreCase(role)) {
                        photographers.add(new User(username, password, role));
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return photographers;
    }




    public boolean deletePhotographer(String username) {
        boolean deleted = false;
        ArrayList<User> photographers = getAllPhotographers();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) {
            for (User photographer : photographers) {
                if (!photographer.getUsername().equals(username)) {
                    writer.write(photographer.getUsername() + "," + photographer.getPassword() + "," + photographer.getRole());
                    writer.newLine();
                } else {
                    deleted = true;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return deleted;
    }


}

