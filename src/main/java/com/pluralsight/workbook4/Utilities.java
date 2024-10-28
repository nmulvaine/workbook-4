package com.pluralsight.workbook4;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Grabs file with user prompt
//
//


class Utilities
{

    public boolean menuIsRunning = true;
    static Scanner scan = new Scanner(System.in);


    // Reads userPrompt.txt file
    List<UserPrompt> userPromptReader()
    {
        String userPromptFilePath = ("./src/main/resources/userPrompt.txt");
        List<UserPrompt> promptList = new ArrayList<>();

        try (BufferedReader bReader = new BufferedReader(new FileReader(userPromptFilePath))) {

            String line;
            while ((line = bReader.readLine()) != null) {
                String[] lineArr = line.split("\\|");

                //create a new transaction object

                if (lineArr.length == 2) {
                    UserPrompt newPrompt = new UserPrompt(
                           Integer.parseInt(lineArr[0].trim()),
                            lineArr[1].trim()
                    );

                    promptList.add(newPrompt);

                }
            }
            // Any list changes would need to be written to file and to Trans
        } catch (FileNotFoundException e) {
            System.out.println("Error! File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error! Unable to read data." + e.getMessage());
        }
        return promptList;
    }


}

class UserPrompt
{

    private int numberChoice;
    private String choiceText;

    public UserPrompt (int prompt, String userResponse) {
        this.numberChoice = prompt;
        this.choiceText = userResponse;
    }

    public int getNumberChoice() {
        return numberChoice;
}
public void setNumberChoice(int numberChoice) {
        this.numberChoice = numberChoice;
}
public String getChoiceText() {
        return choiceText;
}
public void setChoiceText(String choiceText){
        this.choiceText = choiceText;
}

    @Override
    public String toString()
    {
        return numberChoice + ':' +
               " " + choiceText;
    }
}