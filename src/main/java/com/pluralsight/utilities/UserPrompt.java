package com.pluralsight.utilities;


// Todo - Determine if file path being absent is issue
// Todo - Provide file path if needed

import java.util.ArrayList;
import java.util.List;
import java.io.*;
import java.io.IOException;

abstract public class UserPrompt
{
    private String numberChoice;
    private String choiceText;


    private UserPrompt(String numberChoice, String choiceText)
    {
        this.numberChoice = numberChoice;
        this.choiceText = choiceText;
    }


    protected void userPromptReader(String[] args) throws IOException
    {

        String line;
        // Todo - Investigate file path here but not in UI class
        // Todo Need to read and parse txt file into numberChoice and choiceText variables


        try (BufferedReader br = new BufferedReader(new FileReader("prompts.txt"))) {

            while ((line = br.readLine()) != null) {
                numberChoice.append.line {
                    line.split(":")[0]);
                }
            }

        }

        public void setChoiceText (choiceText)
        {
            this.choiceText = choiceText;
        }

        public void setNumberChoice (String numberChoice)
        {
            this.numberChoice = numberChoice;
        }

        public String getNumberChoice ()
        {
            return numberChoice;
        }

        public String getChoiceText ()
        {
            return choiceText; // Added getter for choiceText
        }

        @Override
        public String toString ()
        {
            return numberChoice + ": " + choiceText; // Improved string representation
        }

    }
}