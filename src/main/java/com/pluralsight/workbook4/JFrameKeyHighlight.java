package com.pluralsight.workbook4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


// JFrame process to hopefully control arrow key up/down
//

public class JFrameKeyHighlight extends JFrame implements KeyListener

{
    private JTextArea textArea;
    private int currentLine = 0;
    private final String[] lines;


    public JFrameKeyHighlight()
    {
        this.lines = promptList.toArray(new String[0]);
        utilityFrameSetUp();
    }

    public void utilityFrameSetUp()
    {
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 14));
        textArea.setBackground(Color.BLUE);

        for (String line : lines) {
            textArea.append(line + "\n");
        }

        this.addKeyListener(this);
        this.add(new JScrollPane(textArea));
        this.setSize(400, 400);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        highlightLine(currentLine);
    }


    public static void runTextHighlight(List<String> promptList)
    {
        new JFrameKeyHighlight(promptList);
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        textHighlighter(e);
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    @Override
    public void keyTyped(KeyEvent e)
    {
    }


    private void textHighlighter(KeyEvent highlight)
    {
        // Using if statement highlights or changing color of text based on user arrow key input

        if (highlight.getKeyCode() == KeyEvent.VK_UP) {
            // Direction up
            if (currentLine > 0) {
                currentLine--;
                highlightLine(currentLine);
            }

        } else if (highlight.getKeyCode() == KeyEvent.VK_DOWN) {
            if (currentLine < lines.length - 1) {
                currentLine++;
                highlightLine(currentLine);
            }


        }


    }
    private void highlightLine (int lineIndex) {
        textArea.setText("");
        for (int i = 0; i < lines.length; i++) {
            if (i == lineIndex) {
                textArea.append(">> " + lines[i] + "\n");
            } else {
                textArea.append(lines[i] + "\n");
            }
        }
    }
}
