package com.pluralsight.vehicles;

import javax.swing.*;

public class VehicleAdder{

     public Vehicle createVehicleFromInput () {
        String type = JOptionPane.showInputDialog("Enter vehicle type:");
        String make = JOptionPane.showInputDialog("Enter vehicle make:");
        String model = JOptionPane.showInputDialog("Enter vehicle model:");
        String color = JOptionPane.showInputDialog("Enter vehicle color:");
        int year = Integer.parseInt(JOptionPane.showInputDialog("Enter vehicle year:"));
        int mileage = Integer.parseInt(JOptionPane.showInputDialog("Enter vehicle mileage:"));
        double price = Double.parseDouble(JOptionPane.showInputDialog("Enter vehicle price:"));
        String vin = JOptionPane.showInputDialog("Enter vehicle VIN:");

        // Create a new vehicle with the gathered details
        return new Vehicle(type, make, model, color, year, mileage, price, vin);
    }

}

