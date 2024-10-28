package com.pluralsight.workbook4;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

// Grabs file with user prompt

public class Utilities {
    boolean menuIsRunning = true;

    public List<UserPrompt> userPromptReader() throws IOException {
        List<UserPrompt> promptList = new ArrayList<>();
        String line;

        try (BufferedReader br = new BufferedReader(new FileReader("user_prompts.txt"))) {
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    promptList.add(new UserPrompt(parts[0], parts[1]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User prompts file not found: " + e.getMessage());
            throw e;
        } catch (IOException e) {
            System.out.println("Error reading user prompts: " + e.getMessage());
            throw e;
        }
        return promptList;
    }
}