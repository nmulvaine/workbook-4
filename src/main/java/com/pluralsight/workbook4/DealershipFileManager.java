package com.pluralsight.workbook4;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager
{
    Dealership dealership;

    // Wirting system
    // Vehicle needs to be vehicle
    public void saveToFile(Vehicle vm) throws IOException
    {
        try
                (FileWriter fWriter = new FileWriter("./src/main/resources/inventory.csv"); //Writes to file
                 BufferedWriter bWriter = new BufferedWriter(fWriter); //
                 PrintWriter pWriter = new PrintWriter(bWriter)) { // Formats the printing

// Change variables to appropriate ones
            pWriter.append(String.valueOf(vm.getDate())).append(" | ").append(String.valueOf
                    (vm.getTime())).append(" | ").append(vm.getType()).append
                    (" | ").append(vm.getMake()).append(" | ").append(String.valueOf
                    (vm.getPrice()));

            System.out.println("Inventory successfully updated!");
        } catch (IOException e) {
            System.out.println("Error! Unable to update inventory" + e.getMessage());
            throw e;
        }

    }

    // Reading system
    public String headerParser() throws IOException
    {
        try { // Makes FileReader Obj and that opens the csv file
            Reader in = new FileReader("./src/main/resources/inventory.csv");
            Iterable<CSVRecord> records = CSVFormat.RFC4180.builder()
                    .setHeader("Name", "Address", "Phone")
                    .build()
                    .parse(in);
            for (CSVRecord record : records) {
                String name = record.get("Name");
                String address = record.get("Address");
                String phone = record.get("Phone");
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error! Unable to read data." + e.getMessage());
        }
        return dealership.toString();
    }


    public List<Vehicle> readFromFile(){
    List<Vehicle> allCars;

        StringBuilder vehicleInventory = new StringBuilder("./src/main/resources/inventory.csv");
        allCars = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader(String.valueOf(vehicleInventory)))) {

            String line;
            while ((line = bReader.readLine()) != null) {
                String[] lineArr = line.split("\\|");

                // Create a new transaction object
                // Splitting object by character
                if (lineArr.length == 9) {
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
            // Any list changes would need to be written to file and to Trans
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error! Unable to read data." + e.getMessage());

        }
        return allCars;
    }


}



