package com.pluralsight.workshop.dealership;

import com.pluralsight.vehicles.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

// Handles vehicle sales, adding/removing vehicles, dealership contact information
public class DealershipInventoryManager {
    private final DealershipFileManager df = new DealershipFileManager();

    // Constructor (if additional initialization is needed)
    public DealershipInventoryManager() {
        // Constructor code here (if needed)
    }

    // Searches by price
    public void viewByPrice(double getVehiclePrice)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getVehiclePrice() == getVehiclePrice) { // or another comparison
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for price: " + getVehiclePrice);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    // Searches by make/model
    public void viewByMakeModel(String make, String model)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model)) {
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for make and model: " + make + " " + model);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    // Searches by year
    public void viewByYear(int year)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getVehicleYear() == year) {
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for year: " + year);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    public void viewAllVehicles(List<Vehicle> vehicles)
    {
        List<Vehicle> allCars = df.readFromFile();
    
        if (allCars.isEmpty()) {
            System.out.println("No vehicles found in the inventory.");
        } else {
            for (Vehicle v : allCars) {
                System.out.println(v);
            }
        }
    }
    
    // Searches by color
    public void viewByColor(String color)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getVehicleColor().equalsIgnoreCase(color)) {
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for color: " + color);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    // Searches by mileage
    public void viewByMileage(int mileage)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getVehicleMileage() <= mileage) { // or another comparison
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for mileage: " + mileage);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    // Searches by type (e.g., sedan, SUV, etc.)
    public void viewByType(String type)
    {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> vehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (v.getVehicleType().equalsIgnoreCase(type)) {
                vehicles.add(v);
            }
        }

        if (vehicles.isEmpty()) {
            System.out.println("No results found for type: " + type);
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    // Adds a vehicle
    public void addVehicle(Vehicle vehicle) {
        System.out.println("Vehicle added: " + vehicle);
    }

    // Removes a vehicle by ID
    public void removeFromFile(String vehicleId) throws IOException {
        // Get the current inventory
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> updatedInventory = new ArrayList<>();

        // Filter out the vehicle with the specified ID
        boolean vehicleFound = false;
        for (Vehicle v : allCars) {
            if (!v.getVehicleVIN().equals(vehicleId)) { // Assuming getVehicleId() returns the vehicle ID
                updatedInventory.add(v);
            } else {
                vehicleFound = true;
            }
        }

        // If vehicle was found and removed, rewrite the file
        if (vehicleFound) {
            try (PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(df.getInventoryFile())))) {
                for (Vehicle v : updatedInventory) {
                    // Reformat each vehicle back to the CSV format for saving
                    pWriter.println(v.getVehicleVIN() + " | " +
                                    v.getVehicleType() + " | " +
                                    v.getMake() + " | " +
                                    v.getModel() + " | " +
                                    v.getVehicleYear() + " | " +
                                    v.getVehicleMileage() + " | " +
                                    v.getVehiclePrice());
                }
                System.out.println("Vehicle with ID " + vehicleId + " has been successfully removed from the inventory.");
            } catch (IOException e) {
                System.out.println("Error! Unable to update inventory: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("No vehicle found with ID: " + vehicleId);
        }
    }
    // Views dealership contact information
    public void viewDealershipContactInfo() {
        System.out.println("Dealership Contact Info: D & B Used Cars, Phone: (555) 123-4567, Email: contact@dbusedcars.com");
    }
}