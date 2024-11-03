package com.pluralsight.utilities;


import javax.swing.plaf.basic.BasicListUI;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Grabs file with user prompt

public class Utilities
{

    // Allows for menuLanding to be called to another class
    private BasicListUI.MouseInputHandler userInput;
    private boolean menuIsRunning = true;

    public BasicListUI.MouseInputHandler getUserInput()
    {
        return userInput;
    }

    public void setUserInput(BasicListUI.MouseInputHandler userInput)
    {
        this.userInput = userInput;
    }

    public boolean isMenuIsRunning()
    {
        // Can turn boolean false
        return menuIsRunning;
    }

    public void setMenuIsRunning(boolean menuIsRunning)
    {
        // Shares the value of the boolean
        this.menuIsRunning = menuIsRunning;

    }
}