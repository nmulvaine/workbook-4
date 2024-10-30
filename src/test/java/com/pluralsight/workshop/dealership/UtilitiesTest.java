//package com.pluralsight.workbook4;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import java.io.IOException;
//import java.util.List;
//import static org.junit.jupiter.api.Assertions.assertNotNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//
//class UtilitiesTest
//{
//    private Utilities utilities;
//
//    // Instance of Utilites
//    @BeforeEach
//    public void setUp()
//    {
//        utilities = new Utilities();
//    }
//
//    @Test
//    public void testUserPromptReader()
//    {
//        String testFilePath = "./src/test/resources/userPrompt.txt";
//        try {
//            List<UserPrompt> promptList = utilities.userPromptReader(testFilePath);
//            assertNotNull(promptList, "The prompt list is not null");
//            assertTrue(!promptList.isEmpty(), "The prompt is not empty");
//
//            UserPrompt firstPrompt = promptList.get(0);
//            assertNotNull(firstPrompt.getNumberChoice(), "The prompt isn't null");
//            assertNotNull(firstPrompt.getChoiceText(), "The user response is not null ");
//            System.out.println(promptList);
//        } catch (IOException e) {
//            System.out.println("It did not work");
//            e.printStackTrace();
//        }
//    }
//}