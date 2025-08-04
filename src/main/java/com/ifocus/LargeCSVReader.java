package com.ifocus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LargeCSVReader {
    public static void main(String[] args) {
        String filePath = "path/to/your/large.csv";
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                // Process the values
                System.out.println(values[0]); // Example: Print the first value of each line
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
