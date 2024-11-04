package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.*;

import javax.swing.*;

public class Program {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Define components for the DropDownMenuSystem
            JComboBox<String> dropDownMenu = new JComboBox<>(new String[]{
                    "Please select from the following",
                    "Search by type",
                    "Search by price",
                    "Search by make / model",
                    "Search by year",
                    "Search by color",
                    "Search by mileage",
                    "View all vehicles",
                    "Add vehicle",
                    "Remove vehicle",
                    "Purchase vehicle"
            });
            JButton onEndProgram = new JButton("End Program");
            JButton buttonOK = new JButton("OK");
            JLabel titleMenuIcon = new JLabel("Vehicle Inventory Management");
            JPanel contentPane = new JPanel();

            // Initialize the inventory manager
            DealershipInventoryManager inventoryManager = new DealershipInventoryManager();

            // Initialize the DropDownMenu using UserPromptDialog components
            DropDownMenuSystem dropDownMenuSystem = new DropDownMenuSystem(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane, inventoryManager);
            dropDownMenuSystem.setTitle("Vehicle Inventory Management");

            // Set up main frame properties
            dropDownMenuSystem.pack();
            dropDownMenuSystem.setVisible(true);
            dropDownMenuSystem.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        });
    }
}