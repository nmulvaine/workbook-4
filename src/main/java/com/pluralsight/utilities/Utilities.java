package com.pluralsight.utilities;

import javax.swing.*;

public class Utilities extends UserPromptDialog {
    private String userInput; // Changed to String
    private boolean menuIsRunning = true;

    public Utilities(JComboBox<String> dropDownMenu, JButton onEndProgram, JLabel titleMenuIcon, JButton buttonOK, JPanel contentPane)
    {
        super(dropDownMenu, onEndProgram, titleMenuIcon, buttonOK, contentPane);
    }

    public String getUserInput() {
        return userInput;
    }

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean isMenuIsRunning() {
        return menuIsRunning;
    }

    public void setMenuIsRunning(boolean menuIsRunning) {
        this.menuIsRunning = menuIsRunning;
    }
}