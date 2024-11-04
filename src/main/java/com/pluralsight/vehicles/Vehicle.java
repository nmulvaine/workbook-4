package com.pluralsight.vehicles;

// Sorting logic (All, Type, Make, Model, Color, Year, Mileage, Price)
// Print receipt?

public class Vehicle
{

    private String vehicleVIN;
    private String vehicleType;
    private String make;
    private String model;
    private String vehicleColor;
    private int vehicleYear;
    private int vehicleMileage;
    private double vehiclePrice;


    public Vehicle(String type, String make, String model, String color, int year, int mileage, double price, String vin)
    {
        this.vehicleVIN = vin;
        this.make = make;
        this.vehicleType = type;
        this.model = model;
        this.vehicleColor = color;
        this.vehicleYear = year;
        this.vehicleMileage = mileage;
        this.vehiclePrice = price;
    }

    public String getVehicleVIN()
    {
        return vehicleVIN;
    }

    public void setVehicleVIN(String vehicleVIN)
    {
        this.vehicleVIN = vehicleVIN;
    }

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
               "VIN=" + vehicleVIN + '\'' +
               ", Type='" + vehicleType + '\'' +
               ", Make='" + make + '\'' +
               ", Model='" + model + '\'' +
               ", Color='" + vehicleColor + '\'' +
               ", Year=" + vehicleYear +
               ", Mileage=" + vehicleMileage +
               ", Price=" + vehiclePrice;
    }
}