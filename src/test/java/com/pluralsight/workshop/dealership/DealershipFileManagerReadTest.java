package com.pluralsight.workshop.dealership;

import com.pluralsight.vehicles.Vehicle;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

class DealershipFileManagerReadTest
{
    Vehicle vehicle = new Vehicle("CAR", "Toyota", "Camry", "Red", 2020, 15000, 25000.);

    @Test
    void readFromFile_WhenFileIsEmpty_ReturnsEmptyList() throws IOException
    {
        // Arrange
        DealershipFileManager dealership = new DealershipFileManager();
        // Need to call vehicle class for
        String inventoryFileBackup = "./src/main/resources/inventoryBackup.csv";
        File file = new File(inventoryFileBackup);

        if (file.exists() && file.canRead()) {

            System.out.printf(vehicle.toString() + "\n");
        } else if (!file.exists() || !file.canRead()){
            {
                System.out.println("Unable to read file");
            }
        }
        ;

        // Act
        List<Vehicle> result = dealership.readFromFile();

        // Assert
        //assertThat(result).isEmpty();
    }
}