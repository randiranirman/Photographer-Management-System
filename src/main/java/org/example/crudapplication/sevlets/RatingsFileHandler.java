package org.example.crudapplication.sevlets;

import org.example.crudapplication.Photographer;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class RatingsFileHandler {
    private final String FILEPATH = "ratings.txt";
    public void saveRating(String photographerName, double rating) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILEPATH, true))) {
            writer.write(photographerName + "," + rating);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public Map<String, Photographer> loadRatings() {
        Map<String, Photographer> photographers;
        photographers = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(FILEPATH))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String name = parts[0];
                    double rating = Double.parseDouble(parts[1]);

                    photographers.putIfAbsent(name, new Photographer(name));
                    photographers.get(name).addRatings(rating);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return photographers;
    }

}
