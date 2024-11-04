package com.pluralsight.workshop.dealership;

import com.pluralsight.vehicles.Vehicle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// Handles vehicle sales, adding/removing vehicles, dealership contact information
public class DealershipInventoryManager {
    private final DealershipFileManager df = new DealershipFileManager();

    // Constructor (if additional initialization is needed)
    public DealershipInventoryManager() {
        // Constructor code here (if needed)
    }

    // Filters based on conditions
    private List<Vehicle> filterVehicles(Predicate<Vehicle> condition) {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> filteredVehicles = new ArrayList<>();

        for (Vehicle v : allCars) {
            if (condition.test(v)) {
                filteredVehicles.add(v);
            }
        }
        return filteredVehicles;
    }

    // Searches by price
    public void viewByPrice(double getVehiclePrice) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehiclePrice() == getVehiclePrice);
        displayVehicles(vehicles);
    }

    // Searches by make/model
    public void viewByMakeModel(String make, String model) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model));
        displayVehicles(vehicles);
    }

    // Searches by year
    public void viewByYear(int year) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleYear() == year);
        displayVehicles(vehicles);
    }

    // Searches by color
    public void viewByColor(String color) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleColor().equalsIgnoreCase(color));
        displayVehicles(vehicles);
    }

    // Searches by mileage
    public void viewByMileage(int mileage) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleMileage() <= mileage);
        displayVehicles(vehicles);
    }

    // Searches by type (e.g., sedan, SUV, etc.)
    public void viewByType(String type) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleType().equalsIgnoreCase(type));
        displayVehicles(vehicles);
    }

    // Displays vehicles or a message if no vehicles were found
    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No results found for ");
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
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> updatedInventory = new ArrayList<>();

        // Filter out the vehicle with the specified ID
        boolean vehicleFound = false;
        for (Vehicle v : allCars) {
            if (!v.getVehicleVIN().equals(vehicleId)) {
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
}