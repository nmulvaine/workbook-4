package com.pluralsight.utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UserPromptDialog extends JDialog {
    Utilities utilities;
    private JPanel contentPane;
    protected JButton buttonOK;
    private JButton onEndProgram;
    private JLabel titleMenuIcon;
    private JComboBox<String> dropDownMenu;

    public UserPromptDialog(JComboBox<String> dropDownMenu, JButton onEndProgram, JLabel titleMenuIcon, JButton buttonOK, JPanel contentPane) {
        this.dropDownMenu = dropDownMenu;
        this.onEndProgram = onEndProgram;
        this.titleMenuIcon = titleMenuIcon;
        this.buttonOK = buttonOK;
        this.contentPane = contentPane;

        // Layout configuration
        contentPane.setLayout(new BorderLayout());
        titleMenuIcon.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(titleMenuIcon, BorderLayout.NORTH);
        contentPane.add(dropDownMenu, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(buttonOK);
        buttonPanel.add(onEndProgram);
        contentPane.add(buttonPanel, BorderLayout.SOUTH);

        setContentPane(contentPane);
        setModal(true);
        setSize(400, 300);
        setLocationRelativeTo(null);

        buttonOK.addActionListener(e -> onOK());
        onEndProgram.addActionListener(e -> onEndProgram());

        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onEndProgram();
            }
        });
    }

    private void onOK() {
        String selectedOption = (String) dropDownMenu.getSelectedItem();
        utilities.setUserInput(selectedOption);
    }

    private void onEndProgram() {
        utilities.setMenuIsRunning(false);
        dispose();
    }
}