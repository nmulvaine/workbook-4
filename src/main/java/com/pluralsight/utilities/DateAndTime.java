package com.pluralsight.utilities;

import java.time.LocalDate;
import java.time.LocalTime;


public class DateAndTime extends Utilities
{
    private LocalTime time;
    private LocalDate date;

    public DateAndTime(LocalTime time, LocalDate date){
        this.time = time;
        this.date = date;
    }
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

    @Override
    public String toString()
    {
        return "DateAndTime{" +
               "date=" + date +
               ", time=" + time +
               '}';
    }
}
