package com.pluralsight.utilities;


// Todo - Determine if file path being absent is issue
// Todo - Provide file path if needed

import java.io.*;
import java.io.IOException;

abstract public class UserPrompt extends Utilities
{
    private String userMenuOptions;


    private UserPrompt(String userMenuOptions)
    {
        String userMenu = "";
        this.userMenuOptions = userMenu;
    }

    public void setUserMenuOptions(String userMenuOptions)
    {
        this.userMenuOptions = userMenuOptions;
    }

    public String getUserMenuOptions()
    {
        return userMenuOptions;
    }

    public void userPromptReader() throws IOException
    {

        String line;
        // Todo - Investigate file path here but not in UI class
        // Todo Need to read and parse txt file into numberChoice and choiceText variables


        try (BufferedReader br = new BufferedReader(new FileReader("prompts.txt"))) {

            while ((line = br.readLine()) != null) {
                String s = line.split(userMenuOptions)[0];
                this.userMenuOptions += s + "\n";
            }
            }

        }

    }