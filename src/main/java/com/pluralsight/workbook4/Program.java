package com.pluralsight.workbook4;

// Main .java file
// Houses method for running menu screens
import java.io.IOException;
import java.util.List;

public class Program
{
    // When false menu and application are closed
    // Used for launching highlighting feature in utilities
    // boolean isInMenu = true;

    public static void main(String[] args)
    {
        Utilities utilities = new Utilities();
        UserInterface ui = new UserInterface();

    }
    try

    {

        // Menu landing first


        // Prompts from userPrompt.txt
        List<UserPrompt> promptList = utilities.userPromptReader();
        List<String> stringList = promptList.stream()
                .map(UserPrompt::getPrompt)
                .toList();

        runTextHighlist(stringList);
    } catch(
    IOException e)

    {
        e.printStackTrace();
    }
    // Opening of program
    // Pulls and runs UI

}
