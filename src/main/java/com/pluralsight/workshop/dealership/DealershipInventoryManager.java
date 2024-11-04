package com.pluralsight.workshop.dealership;
import com.pluralsight.vehicles.Vehicle;
import com.pluralsight.vehicles.VehicleAdder;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class DealershipInventoryManager {
    private final DealershipFileManager df = new DealershipFileManager();

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

    public void viewByPrice(double getVehiclePrice) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehiclePrice() == getVehiclePrice);
        displayVehicles(vehicles);
    }

    public void viewByMakeModel(String make, String model) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getMake().equalsIgnoreCase(make) && v.getModel().equalsIgnoreCase(model));
        displayVehicles(vehicles);
    }

    public void viewByYear(int year) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleYear() == year);
        displayVehicles(vehicles);
    }

    public void viewByColor(String color) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleColor().equalsIgnoreCase(color));
        displayVehicles(vehicles);
    }

    public void viewByMileage(int mileage) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleMileage() <= mileage);
        displayVehicles(vehicles);
    }

    public void viewByType(String type) {
        List<Vehicle> vehicles = filterVehicles(v -> v.getVehicleType().equalsIgnoreCase(type));
        displayVehicles(vehicles);
    }

    public void displayVehicles(List<Vehicle> vehicles) {
        if (vehicles.isEmpty()) {
            System.out.println("No results found.");
        } else {
            for (Vehicle v : vehicles) {
                System.out.println(v);
            }
        }
    }

    public Vehicle addVehicle() throws IOException {
        VehicleAdder va = new VehicleAdder();
        Vehicle newVehicle = va.createVehicleFromInput();
        df.saveToFile(newVehicle);
        System.out.println("Vehicle added: " + newVehicle);
        return newVehicle;
    }

    public void removeFromFile(String getVehicleVIN) throws IOException {
        List<Vehicle> allCars = df.readFromFile();
        List<Vehicle> updatedInventory = new ArrayList<>();
        boolean vehicleFound = false;

        for (Vehicle v : allCars) {
            if (!v.getVehicleVIN().equals(getVehicleVIN)) {
                updatedInventory.add(v);
            } else {
                vehicleFound = true;
            }
        }

        if (vehicleFound) {
            try (PrintWriter pWriter = new PrintWriter(new BufferedWriter(new FileWriter(df.getInventoryFile())))) {
                for (Vehicle v : updatedInventory) {
                    pWriter.println(v.getVehicleVIN() + " | " +
                                    v.getVehicleType() + " | " +
                                    v.getMake() + " | " +
                                    v.getModel() + " | " +
                                    v.getVehicleYear() + " | " +
                                    v.getVehicleMileage() + " | " +
                                    v.getVehiclePrice());
                }
                System.out.println("Vehicle with VIN " + getVehicleVIN + " has been successfully removed from the inventory.");
            } catch (IOException e) {
                System.out.println("Error! Unable to update inventory: " + e.getMessage());
                throw e;
            }
        } else {
            System.out.println("No vehicle found with that VIN: " + getVehicleVIN);
        }
    }
}
