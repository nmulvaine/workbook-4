package com.pluralsight.utilities;

import javax.swing.*;
import javax.swing.plaf.basic.BasicListUI;
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

    private BasicListUI.MouseInputHandler setDropDownMenu (JComboBox<String> dropDownMenu)
    {
        // Adds frame to dropdown menu
        JFrame frame = new JFrame();
        frame.add(dropDownMenu);

        return setDropDownMenu(dropDownMenu);
    }

    private void onOK() {
        // Needs to assign the selected item from the drop-down menu to a userInput
        utilities.setUserInput(setDropDownMenu(dropDownMenu));

        dispose();
    }

    private void onEndProgram() {
        utilities.setMenuIsRunning(false);
        dispose();
    }
}