package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.Utilities;
import com.pluralsight.vehicles.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager {
    private final String inventoryFile = "./src/main/resources/inventory.csv"; // Changed to constant
    Dealership dealership;
    Utilities util = new Utilities();


    public void saveToFile(Vehicle vm) throws IOException {
        try (FileWriter fWriter = new FileWriter(inventoryFile);
             BufferedWriter bWriter = new BufferedWriter(fWriter);
             PrintWriter pWriter = new PrintWriter(bWriter)) {
            pWriter.append(String.valueOf(LocalTime.now())).append(" | ")
                    .append(String.valueOf(LocalDate.now())).append(" | ")
                    .append(vm.getVehicleType()).append(" | ")
                    .append(vm.getMake()).append(" | ")
                    .append(String.valueOf(vm.getVehiclePrice()));

            System.out.println("Inventory successfully updated!");
        } catch (IOException e) {
            System.out.println("Error! Unable to update inventory: " + e.getMessage());
            throw e;
        }
    }


    @Override
    public String toString()
    {
        return "DealershipFileManager{" +
               "inventoryFile='" + inventoryFile + '\'' +
               '}';
    }

    public List<Vehicle> readFromFile() {
        List<Vehicle> allCars = new ArrayList<>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] lineArr = line.split("\\|");
                if (lineArr.length == 7) { // Assuming 9 columns
                    Vehicle newCar = new Vehicle(
                            /* vehicleType */ lineArr[0].trim(),
                            /* make */ lineArr[1].trim(),
                            /* model */ lineArr[2].trim(),
                            /* color */lineArr[3].trim(),
                            /* year */ Integer.parseInt(lineArr[4].trim()),
                            /* mileage */ Integer.parseInt(lineArr[5].trim()),
                            /* price */ Double.parseDouble(lineArr[6].trim()));
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