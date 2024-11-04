package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.DropDownMenuSystem;
import com.pluralsight.utilities.Utilities;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Define components for the DropDownMenuSystem
            Utilities utilities;
            JComboBox<String> dropDownMenu = new JComboBox<>(new String[]{
                    "Please select from the following",
                    "Search by type"
                    ,"Search by price",
                    "Search by make / model",
                    "Search by year",
                    "Search by color",
                    "Search by mileage",
                    "View all vehicles",
                    "Add vehicle",
                    "Remove vehicle"
            });
            JButton onEndProgram = new JButton("End Program");
            JButton buttonOK = new JButton("OK");
            JLabel titleMenuIcon = new JLabel("Vehicle Inventory Management");
            JPanel contentPane = new JPanel();

            DealershipInventoryManager inventoryManager = new DealershipInventoryManager();

            new DropDownMenuSystem(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane, inventoryManager).setVisible(true);
        });
    }
}