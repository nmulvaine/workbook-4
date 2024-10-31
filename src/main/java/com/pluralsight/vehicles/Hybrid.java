package com.pluralsight.vehicles;

abstract class Hybrid extends Vehicle
{

    public Hybrid(String vehicleType, String make, String model, String vehicleColor, int vehicleYear, int vehicleMileage, double vehiclePrice)
    {
        super(vehicleType, make, model, vehicleColor, vehicleYear, vehicleMileage, vehiclePrice);
    }
}
