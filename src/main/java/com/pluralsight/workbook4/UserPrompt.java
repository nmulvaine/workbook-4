package com.pluralsight.workbook4;


// Todo - Determine if file path being absent is issue
// Todo - Provide file path if needed

public class UserPrompt {
    private final String numberChoice; // Changed to final for immutability
    private final String choiceText; // Changed to final for immutability

    public UserPrompt(String numberChoice, String choiceText) {
        this.numberChoice = numberChoice;
        this.choiceText = choiceText;
    }

    public String getNumberChoice() {
        return numberChoice;
    }

    public String getChoiceText() {
        return choiceText; // Added getter for choiceText
    }

    @Override
    public String toString() {
        return numberChoice + ": " + choiceText; // Improved string representation
    }
}
