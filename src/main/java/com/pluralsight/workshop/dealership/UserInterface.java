package com.pluralsight.workshop.dealership;

import com.pluralsight.utilities.JFrameKeyHighlight;
import com.pluralsight.utilities.UserPrompt;
import com.pluralsight.utilities.Utilities;

import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.util.List;
// User input/output through menu screens
// Pulls variables from other classes for sorting, adding, removing vehicles


public class UserInterface
{
    JFrameKeyHighlight highlight;
    UserPrompt uPrompt;
    List<UserPrompt> promptList;
    Utilities util = new Utilities();

    void menuLanding() throws IOException, BadLocationException
    {

        // Top banner for menu


        System.out.printf(uPrompt.toString());
        //promptList = uPrompt.userPromptReader();

//        List<String> stringList = promptList.stream()
//                .map(UserPrompt::getChoiceText)// Changed to getChoiceText
//                .toList();


        while (util.isMenuIsRunning()) {
            // Try Catch instead of for
            try {
                highlight.runTextHighlight(promptList);
                for (UserPrompt prompt : promptList) {
                    System.out.println(prompt); // Fixed method call to print prompt
                }

            } catch (IOException | BadLocationException e) {
                throw e;
            }


        }
    }
}