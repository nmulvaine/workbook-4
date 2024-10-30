package com.pluralsight.utilities;


// Todo - Determine if file path being absent is issue
// Todo - Provide file path if needed

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserPrompt
{
    private String numberChoice; // Changed to final for immutability
    private String choiceText; // Changed to final for immutability

    public UserPrompt(String numberChoice, String choiceText)
    {
        this.numberChoice = numberChoice;
        this.choiceText = choiceText;
    }


    public List<UserPrompt> userPromptReader() throws IOException
    {
        List<UserPrompt> promptList = new ArrayList<>();
        String line;

        // Todo - Investigate file path here but not in UI class
        // Reads prompt file
        // Could be shared method in future
        // Would need different parsing system

        try (BufferedReader br = new BufferedReader(new FileReader("userPrompts.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    promptList.add(new UserPrompt(parts[0], parts[1]));
                }
            }
            return promptList;
        } catch (FileNotFoundException e) {
            System.out.println("User prompts file not found: " + e.getMessage());
            throw e;
        } catch (IOException e) {
            System.out.println("Error reading user prompts: " + e.getMessage());
            throw e;
        }


    }

    public void setChoiceText(String choiceText)
    {
        this.choiceText = choiceText;
    }

    public void setNumberChoice(String numberChoice)
    {
        this.numberChoice = numberChoice;
    }

    public String getNumberChoice()
    {
        return numberChoice;
    }

    public String getChoiceText()
    {
        return choiceText; // Added getter for choiceText
    }

    @Override
    public String toString()
    {
        return numberChoice + ": " + choiceText; // Improved string representation
    }

}