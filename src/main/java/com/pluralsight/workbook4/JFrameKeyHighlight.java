package com.pluralsight.workbook4;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.List;

// JFrame process to hopefully control arrow key up/down
public class JFrameKeyHighlight extends JFrame implements KeyListener {
    private JTextArea textArea;
    private int currentLine = 0;
    private final String[] lines;

    public JFrameKeyHighlight(List<String> promptList) throws IOException, BadLocationException
    { // Added parameter
        this.lines = promptList.toArray(new String[0]);
        utilityFrameSetUp();
    }

    public void utilityFrameSetUp() throws IOException, BadLocationException
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

    public static void runTextHighlight(List<String> promptList) throws IOException, BadLocationException
    {
        new JFrameKeyHighlight(promptList);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try {
            textHighlighter(e);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (BadLocationException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyTyped(KeyEvent e) {}

    private void textHighlighter(KeyEvent e) throws IOException, BadLocationException
    {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            if (currentLine < lines.length - 1) {
                highlightLine(++currentLine);
            }
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            if (currentLine > 0) {
                highlightLine(--currentLine);
            }
        }
    }

    private void highlightLine(int lineIndex) throws IOException, BadLocationException
    {
        textArea.setSelectionStart(textArea.getLineStartOffset(lineIndex));
        textArea.setSelectionEnd(textArea.getLineEndOffset(lineIndex));
    }
}