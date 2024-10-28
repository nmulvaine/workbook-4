package com.pluralsight.workbook4;


import java.time.LocalDate;
import java.time.LocalTime;


// Sorting logic (All, Type, Make, Model, Color, Year, Mileage, Price)
// Print receipt?

public class Vehicle
{

    private LocalTime time;
    private LocalDate date;
    private String type;
    private String make;
    private String model;
    private String color;
    private int year;
    private int mileage;
    private double price;


    public Vehicle(LocalDate date, LocalTime time, String type, String make, String model, String color, int year, int mileage, double price)
    {
        this.time = time;
        this.date = date;
        this.make = make;
        this.type = type;
        this.model = model;
        this.color = color;
        this.year = year;
        this.mileage = mileage;
        this.price = price;
    }


    // Getters and Setters
    // Clean out unused


    public LocalTime getTime()
    {
        return time;
    }

    public void setTime(LocalTime time)
    {
        this.time = time;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
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

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }

    public int getYear()
    {
        return year;
    }

    public void setYear(int year)
    {
        this.year = year;
    }

    public int getMileage()
    {
        return mileage;
    }

    public void setMileage(int mileage)
    {
        this.mileage = mileage;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    @Override
    public String toString()
    {
        return "Vehicle{" +
               "time=" + time +
               ", date=" + date +
               ", vendor='" + type + '\'' +
               ", description='" + make + '\'' +
               ", amount=" + price +
               '}';

    }
}
