package com.pluralsight.workshop.dealership;
import javax.swing.text.BadLocationException;
import java.io.IOException;
import java.util.List;
import com.pluralsight.utilities.*;
// User input/output through menu screens
// Pulls variables from other classes for sorting, adding, removing vehicles





public class UserInterface
{
    JFrameKeyHighlight highlight;
    UserPrompt uPrompt;
    Utilities util = new Utilities();
    void menuLanding() throws IOException, BadLocationException
    {

        // Top banner for menu
        System.out.println("Welcome to the D & B Used Car Dealership");




        System.out.printf(uPrompt.toString());
        //promptList = uPrompt.userPromptReader();

//        List<String> stringList = promptList.stream()
//                .map(UserPrompt::getChoiceText)// Changed to getChoiceText
//                .toList();

        highlight.highlightLine();
        while (util.isMenuIsRunning()) {
            // Try Catch instead of for
            for (UserPrompt prompt : promptList) {
                System.out.println(prompt); // Fixed method call to print prompt
            }

        }
    }
}