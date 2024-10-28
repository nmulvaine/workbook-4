package com.pluralsight.workbook4;


// User input/output through menu screens
// Pulls variables from other classes for sorting, adding, removing vehicles

import java.util.List;

public class UserInterface
{

    Utilities utilities = new Utilities();


    // Allows for menuLanding to be called to another class
    public void showMenuLanding()
    {
        menuLanding();
    }

    // Would need to feed menu over to Util for refresh
    private void menuLanding()
    {

        System.out.println("Welcome to the D & B Used Car Dealership");
        JFrameKeyHighlight.runTextHighlight();
        while (utilities.menuIsRunning) {
           List<UserPrompt> promptList = utilities.userPromptReader();
            for (UserPrompt prompt : promptList) {
                System.out.println(prompt);
            }
            utilities.menuIsRunning = false;
        }



    }
}
