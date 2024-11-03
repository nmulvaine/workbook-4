package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.UserPromptDialog;
import com.pluralsight.utilities.UserPromptDialog.*;
import com.pluralsight.utilities.UserPrompt;
import com.pluralsight.utilities.Utilities;

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.util.List;
// User input/output through menu screens
// Pulls variables from other classes for sorting, adding, removing vehicles


public class UserInterface
{

    UserPrompt uPrompt;
    List<UserPrompt> promptList;
    Utilities util = new Utilities();
    UserPromptDialog dialog = new UserPromptDialog();

    void menuLanding() throws IOException, BadLocationException
    {

        // Top banner for menu


        System.out.printf(uPrompt.toString());
        uPrompt.userPromptReader();



//        while (util.isMenuIsRunning()) {
//            // Try Catch instead of for
//            dialog.createUIComponents(promptList);
//            for (UserPrompt prompt : promptList) {
//                System.out.println(prompt); // Fixed method call to print prompt
//            }
//
//
//        }
    }
}