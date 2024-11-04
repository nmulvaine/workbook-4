package com.pluralsight.utilities;

import com.pluralsight.vehicles.Vehicle;
import com.pluralsight.workshop.dealership.DealershipFileManager;
import com.pluralsight.workshop.dealership.DealershipInventoryManager;

import javax.swing.*;

public class DropDownMenuSystem extends UserPromptDialog
{

    private DealershipInventoryManager inventoryManager;
    private DealershipFileManager fileManager;
    protected JComboBox<String> dropDownMenu;

    public String getSelectedOption()
    {
        return utilities.getUserInput() + dropDownMenu.getSelectedItem();
    }

    public DropDownMenuSystem(JComboBox<String> dropDownMenu, JButton onEndProgram, JLabel titleMenuIcon, JButton buttonOK, JPanel contentPane, DealershipInventoryManager inventoryManager)
    {
        super(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
        this.inventoryManager = inventoryManager;
        this.fileManager = new DealershipFileManager();
        this.dropDownMenu = dropDownMenu;

        buttonOK.addActionListener(e -> handleSelection());
    }

    public void handleSelection()
    {
        String selectedOption = (String) dropDownMenu.getSelectedItem();
        while (utilities.isMenuIsRunning()) {
            try {
                if (selectedOption != null) {
                    switch (selectedOption) {
                        case "Search by price":
                            double price = Double.parseDouble(JOptionPane.showInputDialog("Enter price to search by:"));
                            inventoryManager.viewByPrice(price);
                            break;

                        case "Search by make / model":
                            String make = JOptionPane.showInputDialog("Enter vehicle make:");
                            String model = JOptionPane.showInputDialog("Enter vehicle model:");
                            inventoryManager.viewByMakeModel(make, model);
                            break;

                        case "Search by year":
                            int year = Integer.parseInt(JOptionPane.showInputDialog("Enter year to search by:"));
                            inventoryManager.viewByYear(year);
                            break;

                        case "Search by color":
                            String color = JOptionPane.showInputDialog("Enter color to search by:");
                            inventoryManager.viewByColor(color);
                            break;

                        case "Search by mileage":
                            int mileage = Integer.parseInt(JOptionPane.showInputDialog("Enter mileage to search by:"));
                            inventoryManager.viewByMileage(mileage);
                            break;

                        case "Search by type":
                            String type = JOptionPane.showInputDialog("Enter type to search by:");
                            inventoryManager.viewByType(type);
                            break;

                        case "View all vehicles":
                            inventoryManager.displayVehicles(fileManager.readFromFile());
                            break;

                        case "Add vehicle":
                            inventoryManager.addVehicle();
                            break;

                        case "Remove vehicle":
                            String vin = JOptionPane.showInputDialog("Enter VIN of vehicle to remove:");
                            inventoryManager.removeFromFile(vin);
                            break;

                        case "Purchase vehicle":
                            String vehiclePurchase = (String) dropDownMenu.getSelectedItem();
                            inventoryManager.removeFromFile(vehiclePurchase);

                        case "Exit":
                            onEndProgram.doClick();
                            utilities.setMenuIsRunning(false);
                            System.exit(0);
                            dispose();
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Please select a valid option.");
                    }
                }
            } catch (Exception ex) {
            }
        }
    }



}