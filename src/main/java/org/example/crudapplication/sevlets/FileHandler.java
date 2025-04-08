package org.example.crudapplication.sevlets;

import org.example.crudapplication.User;

import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String DATA_FILE = "users.txt"; // File location

    // Appends a new user to the file
    public void appendUser(User user) throws IOException {
        // Ensure the file exists, create if it doesn't
        File file = new File(DATA_FILE);
        if (!file.exists()) {
            file.createNewFile();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(DATA_FILE, true))) {
            bw.write(user.toDataString());
            bw.newLine();
        }
    }

    public ArrayList<User> getAllUsers(){
         ArrayList<User> users = new ArrayList<>();



         return  users;

    }

    // Deletes a user from the file based on username and role
    public boolean deleteUser(String username, String role) throws IOException {
        boolean deleted = false;
        File inputFile = new File(DATA_FILE);
        File tempFile = new File("temp.txt");

        // Using try-with-resources for automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[2].equals(role)) {
                    deleted = true;
                    continue; // Skip the line to delete
                }
                writer.write(line); // Write the line to temp file
                writer.newLine();
            }
        }

        if (deleted) {
            // Delete the original file and rename temp file to the original name
            inputFile.delete();
            tempFile.renameTo(inputFile);
        }
        return deleted;
    }

    // Edits an existing user (changes password) based on username and role
    public boolean editUser(String username, String newPassword, String role) throws IOException {
        boolean edited = false;
        File inputFile = new File(DATA_FILE);
        File tempFile = new File("temp.txt");

        // Using try-with-resources for automatic resource management
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[2].equals(role)) {
                    writer.write(username + "," + newPassword + "," + role); // Update password
                    edited = true;
                } else {
                    writer.write(line); // Copy the line as is
                }
                writer.newLine();
            }
        }

        if (edited) {
            // Delete the original file and rename temp file to the original name
            inputFile.delete();
            tempFile.renameTo(inputFile);
        }
        return edited;
    }
}
