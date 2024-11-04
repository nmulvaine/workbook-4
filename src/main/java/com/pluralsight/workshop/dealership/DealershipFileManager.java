package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.DropDownMenuSystem;
import com.pluralsight.vehicles.Vehicle;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class DealershipFileManager
{

    protected DropDownMenuSystem dropDownMenuSystem;
    private final String inventoryFile = "./src/main/resources/inventory.csv";


    protected void saveToFile(Vehicle vm) throws IOException
    {
        try (FileWriter fWriter = new FileWriter(inventoryFile, true);
             BufferedWriter bWriter = new BufferedWriter(fWriter);
             PrintWriter pWriter = new PrintWriter(bWriter)) {
// if statement for writing to inventory or receipt
            if ("Add Vehicle".equals(dropDownMenuSystem.getSelectedOption()))
            {
                System.out.println("Congratulations on the purchase of your new vehicle!");
                System.out.println("Below is the information for your receipt");
                pWriter.append(vm.getVehicleVIN() + " | ")
                        .append(vm.getVehicleType() + " | ")
                        .append(vm.getMake() + vm.getMake() + " | ")
                        .append(vm.getVehicleYear() + " | ")
                        .append(vm.getVehicleColor() + " | ")
                        .append(vm.getVehicleMileage() + " | ")
                        .append(vm.getVehiclePrice() + " | ")
                        .append(LocalTime.now() + " | ")
                        .append(LocalDate.now() + "\n");
            }
            else
            {
                pWriter.append(vm.getVehicleVIN() + " | ")
                        .append(vm.getVehicleType() + " | ")
                        .append(vm.getMake() + vm.getMake() + " | ")
                        .append(vm.getVehicleYear() + " | ")
                        .append(vm.getVehicleColor() + " | ")
                        .append(vm.getVehicleMileage() + " | ")
                        .append(vm.getVehiclePrice() + " | ");
            }
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

    public String getInventoryFile()
    {
        return inventoryFile;
    }

    public String setInventoryFile (String absolutePath)
    {
        return inventoryFile;
    }

    public List<Vehicle> readFromFile()
    {
        List<Vehicle> allCars = new ArrayList<>();
        try (BufferedReader bReader = new BufferedReader(new FileReader(inventoryFile))) {
            String line;
            while ((line = bReader.readLine()) != null) {
                String[] lineArr = line.split("\\|");
                if (lineArr.length == 8) {
                    Vehicle newCar = new Vehicle(
                            lineArr[0].trim(),
                            lineArr[1].trim(),
                            lineArr[2].trim(),
                            lineArr[3].trim(),
                            Integer.parseInt(lineArr[4].trim()),
                            Integer.parseInt(lineArr[5].trim()),
                            Double.parseDouble(lineArr[6].trim()),
                            lineArr[7].trim());
                    allCars.add(newCar);
                }
            }
        } catch (IOException e) {
            System.out.println("Error! Unable to read data: " + e.getMessage());
        }
        return allCars;
    }
}