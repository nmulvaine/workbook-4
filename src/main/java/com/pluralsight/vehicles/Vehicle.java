package com.pluralsight.vehicles;

import java.time.LocalDate;
import java.time.LocalTime;

// Sorting logic (All, Type, Make, Model, Color, Year, Mileage, Price)
// Print receipt?

public class Vehicle
{


    private String vehicleType;
    private String make;
    private String model;
    private String vehicleColor;
    private int vehicleYear;
    private int vehicleMileage;
    private double vehiclePrice;

    public Vehicle(String vehicleType, String make, String model, String vehicleColor, int vehicleYear, int vehicleMileage, double vehiclePrice)
    {
        this.make = make;
        this.vehicleType = vehicleType;
        this.model = model;
        this.vehicleColor = vehicleColor;
        this.vehicleYear = vehicleYear;
        this.vehicleMileage = vehicleMileage;
        this.vehiclePrice = vehiclePrice;
    }

    // Getters and Setters
    // TODO Clean out unused



    public String getVehicleType()
    {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType)
    {
        this.vehicleType = vehicleType;
    }

    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }

    public void setModel(String model)
    {
        this.model = model;
    }

    public String getVehicleColor()
    {
        return vehicleColor;
    }

    public void setVehicleColor(String vehicleColor)
    {
        this.vehicleColor = vehicleColor;
    }

    public int getVehicleYear()
    {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear)
    {
        this.vehicleYear = vehicleYear;
    }

    public int getVehicleMileage()
    {
        return vehicleMileage;
    }

    public void setVehicleMileage(int vehicleMileage)
    {
        this.vehicleMileage = vehicleMileage;
    }

    public double getVehiclePrice()
    {
        return vehiclePrice;
    }

    public void setVehiclePrice(double vehiclePrice)
    {
        this.vehiclePrice = vehiclePrice;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
               ", Type='" + vehicleType + '\'' +
               ", Make='" + make + '\'' +
               ", Model='" + model + '\'' +
               ", Color='" + vehicleColor + '\'' +
               ", Year=" + vehicleYear +
               ", Mileage=" + vehicleMileage +
               ", Price=" + vehiclePrice;
    }
}