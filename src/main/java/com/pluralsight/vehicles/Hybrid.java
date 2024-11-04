package com.pluralsight.vehicles;

abstract class Hybrid extends Vehicle
{

    public Hybrid(String type, String make, String model, String color, int year, int mileage, double price, String vin)
    {
        super(type, make, model, color, year, mileage, price, vin);
    }
}
