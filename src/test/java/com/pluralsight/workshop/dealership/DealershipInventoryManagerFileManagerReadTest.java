package com.pluralsight.workshop.dealership;

import com.pluralsight.vehicles.Vehicle;
import com.pluralsight.workshop.dealership.DealershipFileManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class DealershipInventoryManagerFileManagerReadTest {

    private DealershipFileManager dealership;
    private File tempFile;

    @BeforeEach
    void setUp() throws IOException {
        // Arrange
        dealership = new DealershipFileManager();

        // Create a temporary file to act as the empty inventory file
        tempFile = File.createTempFile("inventory", ".csv");
        tempFile.deleteOnExit();

        // Ensure the file is empty by overwriting with an empty FileWriter
        try (FileWriter writer = new FileWriter(tempFile, false)) {
            writer.write("");
        }

        // Redirect DealershipFileManager to use this temp file
        dealership.setInventoryFile(tempFile.getAbsolutePath());
    }

    @AfterEach
    void tearDown() {
        // Cleanup
        if (tempFile.exists()) {
            tempFile.delete();
        }
    }

    @Test
    void readFromFile_WhenFileIsEmpty_ReturnsEmptyList()
    {
        // Act
        List<Vehicle> result = dealership.readFromFile();

        // Assert
        assertTrue(result.isEmpty(), "Expected an empty list when the file is empty.");
    }
}