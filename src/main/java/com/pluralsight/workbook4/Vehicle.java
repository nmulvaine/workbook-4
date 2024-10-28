package com.pluralsight.workbook4;

import java.time.LocalDate;
import java.time.LocalTime;

// Sorting logic (All, Type, Make, Model, Color, Year, Mileage, Price)
// Print receipt?

public class Vehicle {

    private LocalTime time;
    private LocalDate date;
    private String vehicleType;
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private double price;

    public Vehicle(LocalDate date, LocalTime time, String vehicleType, String make, String model, String color, int year, int mileage, double price) {
        this.time = time;
        this.date = date;
        this.make = make;
        this.vehicleType = vehicleType;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }

    // Getters and Setters
    // Clean out unused

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
               ", Type='" + vehicleType + '\'' +
               ", Make='" + make + '\'' +
               ", Model='" + model + '\'' +
               ", Color='" + color + '\'' +
               ", Year=" + year +
               ", Mileage=" + mileage +
               ", Price=" + price ;
    }
}