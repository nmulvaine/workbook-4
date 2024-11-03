package com.pluralsight.utilities;

import javax.swing.*;
import java.awt.event.*;
import java.util.List;

public class UserPromptDialog extends JDialog
{
    Utilities utilities = new Utilities();
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton onEndProgram;
    private JButton titleMenuIcon;
    private JComboBox dropDownMenu;

    public UserPromptDialog()
    {

        //JComboBox dropDownMenu = new JComboBox();
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(e -> onOK());

        onEndProgram.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onEndProgram();
            }
        });

        // call onEndProgram() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter()
        {
            public void windowClosing(WindowEvent e)
            {
                onEndProgram();
            }
        });

        // TODO Alter for "Exit: button instead of ESC key

        contentPane.registerKeyboardAction(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                onEndProgram();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
        titleMenuIcon.addMouseListener(new MouseAdapter()
        {
        });
    }

    private void onOK()
    {
        // add your code here
        dispose();
    }

    private void onEndProgram()
    {
        utilities.setMenuIsRunning(false);
        dispose();
    }

    public static void main(String[] args)
    {
        UserPromptDialog dialog = new UserPromptDialog();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }




}
