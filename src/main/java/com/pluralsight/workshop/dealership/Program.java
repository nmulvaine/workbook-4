package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.DropDownMenu;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.io.IOException;

public class Program {
    public static void main(String[] args) throws IOException, BadLocationException {
        // Define components for the DropDownMenu
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

        JButton onEndProgram = new JButton("Exit");
        JLabel titleMenuIcon = new JLabel("D & B Used Cars");
        JButton buttonOK = new JButton("OK");
        JPanel contentPane = new JPanel();

        // Initialize DropDownMenu instance
        DropDownMenu menu = new DropDownMenu(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
        menu.setVisible(true); // Show the dialog
    }
}