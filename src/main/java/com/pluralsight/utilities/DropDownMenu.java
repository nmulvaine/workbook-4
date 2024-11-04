package com.pluralsight.utilities;

import javax.swing.*;


public class DropDownMenu extends UserPromptDialog {


    public DropDownMenu(JComboBox<String> dropDownMenu, JButton onEndProgram, JLabel titleMenuIcon, JButton buttonOK, JPanel contentPane)
    {
        super(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
    }

    public static void dropDownMenuSystem(String[] args) {
        JComboBox<String> dropDownMenu = new JComboBox<>(new String[]{
                "Please select from the following",
                "Search by price",
                "Search by make / model",
                "Search by year",
                "Search by color",
                "Search by mileage",
                "Search by type",
                "View all vehicles",
                "Add vehicle",
                "Remove vehicle"
        });
        // Shows drop down menu

        JButton onEndProgram = new JButton("Exit");
        JLabel titleMenuIcon = new JLabel("D & B Used Cars"); // Static text label
        JButton buttonOK = new JButton("OK");
        // Assigns button to userInput
        // UserInput goes through Switch
        JPanel contentPane = new JPanel();

        // Initialize the dialog
//        UserPromptDialog dialog = new UserPromptDialog(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
//        dialog.setVisible(true);
        // Handle other cases
        if (buttonOK.equals("Search by price")) {// Search by price
        } else if (buttonOK.equals("Search by make / model")) {// Search by make / model
        } else if (buttonOK.equals("Search by year")) {// Search by year
        } else if (buttonOK.equals("Search by color")) {// Search by color
        } else if (buttonOK.equals("Search by mileage")) {// Search by mileage
        } else if (buttonOK.equals("Search by type")) {// Search by type
        } else if (buttonOK.equals("View all vehicles")) {// View all vehicles
        } else if (buttonOK.equals("Add vehicle")) {// Add vehicle
        } else if (buttonOK.equals("Remove vehicle")) {// Remove vehicle
        }
    }
}

