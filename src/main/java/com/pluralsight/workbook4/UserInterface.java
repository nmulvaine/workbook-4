package com.pluralsight.workbook4;

// User input/output through menu screens
// Pulls variables from other classes for sorting, adding, removing vehicles

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.util.List;

public class UserInterface {

    Utilities utilities = new Utilities();

    // Allows for menuLanding to be called to another class
    public void showMenuLanding() throws IOException, BadLocationException
    {
        menuLanding();
    }

    private void menuLanding() throws IOException, BadLocationException
    {
        System.out.println("Welcome to the D & B Used Car Dealership");

        List<UserPrompt> promptList;

        try {
            promptList = utilities.userPromptReader();
        } catch (IOException e) {
            System.out.println("Error reading user prompt: " + e.getMessage());
            return;
        }

        List<String> stringList = promptList.stream()
                .map(UserPrompt::getChoiceText) // Changed to getChoiceText
                .toList();

        JFrameKeyHighlight.runTextHighlight(stringList);
        while (utilities.menuIsRunning) {
            for (UserPrompt prompt : promptList) {
                System.out.println(prompt); // Fixed method call to print prompt
            }
            utilities.menuIsRunning = false;
        }
    }
}