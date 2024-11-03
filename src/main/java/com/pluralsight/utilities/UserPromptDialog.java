package com.pluralsight.utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UserPromptDialog extends JDialog {
    private Utilities utilities = new Utilities();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton onEndProgram;
    private JLabel titleMenuIcon;
    private JComboBox<String> dropDownMenu;

    public UserPromptDialog(JComboBox<String> dropDownMenu, JButton onEndProgram, JLabel titleMenuIcon, JButton buttonOK, JPanel contentPane) {
        this.dropDownMenu = dropDownMenu;
        this.onEndProgram = onEndProgram;
        this.titleMenuIcon = titleMenuIcon;
        this.buttonOK = buttonOK;
        this.contentPane = contentPane;

        // Set layout for contentPane and add components
        contentPane.setLayout(new BorderLayout());
        titleMenuIcon.setHorizontalAlignment(SwingConstants.CENTER);
        titleMenuIcon.setVerticalAlignment(SwingConstants.CENTER);// Center-align title
        //contentPane.add(titleMenuIcon, BorderLayout.NORTH);
        contentPane.add(dropDownMenu, BorderLayout.CENTER);

        // Add OK and Exit buttons to a panel at the bottom
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonOK);
        buttonPanel.add(onEndProgram);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setModal(true);
        setSize(400, 300); // Set initial size
        setLocationRelativeTo(null); // Center the dialog on screen

        // Set up button click events
        buttonOK.addActionListener(e -> onOK());
        onEndProgram.addActionListener(e -> onEndProgram());

        // Call onEndProgram() when the close button is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onEndProgram();
            }
        });
    }

    private void onOK() {
        dispose();
    }

    private void onEndProgram() {
        utilities.setMenuIsRunning(false);
        dispose();
    }

    public static void main(String[] args) {
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
        JLabel titleMenuIcon = new JLabel("D & B Used Cars"); // Static text label
        JButton buttonOK = new JButton("OK");
        JPanel contentPane = new JPanel();
        utilities.setUserInput();

        // Initialize the dialog
        UserPromptDialog dialog = new UserPromptDialog(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
        dialog.setVisible(true);
    }
}