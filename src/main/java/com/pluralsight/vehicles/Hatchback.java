package com.pluralsight.vehicles;

abstract class Hatchback extends Vehicle
{
    public Hatchback(String vehicleType, String make, String model, String vehicleColor, int vehicleYear, int vehicleMileage, double vehiclePrice)
    {
        super(vehicleType, make, model, vehicleColor, vehicleYear, vehicleMileage, vehiclePrice);
    }
}