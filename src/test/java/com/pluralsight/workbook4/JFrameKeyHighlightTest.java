package com.pluralsight.workbook4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.awt.event.KeyEvent;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


class JFrameKeyHighlightTest
{
    private JFrameKeyHighlight utilities;


    @BeforeEach
    void setUp()
    {
        //utilities = new JFrameKeyHighlight();

    }


    @Test
    void testFrameSetup()
    {
        assertFalse(utilities.isVisible());
        assertEquals(400, utilities.getWidth());
        assertEquals(400, utilities.getHeight());
        assertEquals(JFrame.EXIT_ON_CLOSE, utilities.getDefaultCloseOperation());
    }

    void testKeyPressSimulation()
    {

            KeyEvent pressUp = new KeyEvent(utilities, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_UP, ' ');
            System.out.println("Yay, pressing up worked");
            utilities.keyPressed(pressUp);

            KeyEvent pressDown = new KeyEvent(utilities, KeyEvent.KEY_PRESSED, System.currentTimeMillis(), 0, KeyEvent.VK_DOWN, ' ');
            System.out.println("Yay, pressing down worked");
            utilities.keyPressed(pressDown);
        }
    }

