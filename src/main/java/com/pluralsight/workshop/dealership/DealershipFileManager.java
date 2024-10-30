package com.pluralsight.workshop.dealership;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private final String FILE_PATH = "./src/main/resources/inventory.csv"; // Changed to constant
    Dealership dealership;

    public void saveToFile(Vehicle vm) throws IOException {
        try (FileWriter fWriter = new FileWriter(FILE_PATH);
             BufferedWriter bWriter = new BufferedWriter(fWriter);
             PrintWriter pWriter = new PrintWriter(bWriter)) {
            pWriter.append(String.valueOf(vm.getDate())).append(" | ")
                    .append(String.valueOf(vm.getTime())).append(" | ")
                    .append(vm.getVehicleType()).append(" | ")
                    .append(vm.getMake()).append(" | ")
                    .append(String.valueOf(vm.getPrice()));

            System.out.println("Inventory successfully updated!");
        } catch (IOException e) {
            System.out.println("Error! Unable to update inventory: " + e.getMessage());
            throw e;
        }
    }

    public List<Vehicle> readFromFile() {
        List<Vehicle> allCars = new ArrayList<>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] lineArr = line.split("\\|");
                if (lineArr.length == 9) { // Assuming 9 columns
                    Vehicle newCar = new Vehicle(
                            LocalDate.parse(lineArr[0].trim()),
                            LocalTime.parse(lineArr[1].trim()),
                            lineArr[2].trim(),
                            lineArr[3].trim(),
                            lineArr[4].trim(),
                            lineArr[5].trim(),
                            Integer.parseInt(lineArr[6].trim()),
                            Integer.parseInt(lineArr[7].trim()),
                            Double.parseDouble(lineArr[8].trim())
                    );
                    allCars.add(newCar);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error! Unable to read data: " + e.getMessage());
        }
        return allCars;
    }
}