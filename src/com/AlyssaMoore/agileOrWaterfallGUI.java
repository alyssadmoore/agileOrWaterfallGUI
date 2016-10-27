package com.AlyssaMoore;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class agileOrWaterfallGUI extends JFrame {
    private JPanel rootPanel;
    private JTextField projectName;
    private JCheckBox numberOfProgrammersOnCheckBox;
    private JCheckBox needForAFixedCheckBox;
    private JCheckBox doTeammateHaveExperienceCheckBox;
    private JCheckBox stringentQualityControlRequirementsCheckBox;
    private JCheckBox earlyIntegrationNOTDesirableCheckBox;
    private JCheckBox earlyWorkingModelsNOTCheckBox;
    private JButton resultsButton;
    private JLabel results;

    public agileOrWaterfallGUI() {
        setContentPane(rootPanel);
        pack();
        setSize(575, 275);
        setTitle("Agile or Waterfall Decision-Maker");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Action listener for the Results button
        resultsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myProjectName = projectName.getText();
                String decision = agileOrWaterfallDecider();
                results.setText(myProjectName + " should use " + decision);
            }
        });
    }

    /* method sets decision to default state Agile, then adds one to a counter for each answer correlating to Waterfall
    (as opposed to Agile). If the user answers more than 3 of the 6 questions correlating to Waterfall, that will become
    the decision. If exactly 3 answers correlate to Waterfall (or Agile), the decision will be set to 'either one'. */
    public String agileOrWaterfallDecider() {
        String decision = "Agile.";
        int x = 0;
        if (numberOfProgrammersOnCheckBox.isSelected())
            x += 1;
        if (needForAFixedCheckBox.isSelected())
            x += 1;
        if (doTeammateHaveExperienceCheckBox.isSelected())
            x += 1;
        if (stringentQualityControlRequirementsCheckBox.isSelected())
            x += 1;
        if (earlyIntegrationNOTDesirableCheckBox.isSelected())
            x += 1;
        if (earlyWorkingModelsNOTCheckBox.isSelected())
            x += 1;
        if (x > 3)
            decision = "Waterfall.";
        else if (x == 3) {
            decision = "either one.";
        }
        return decision;
    }
}