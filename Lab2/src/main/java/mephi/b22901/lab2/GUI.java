/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import java.awt.event.ActionEvent;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author ������
 */
public class GUI extends JFrame {

    public GUI() {
        JFrame frame = new JFrame("Final Battle Army");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(450, 300);

        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
        JPanel createPanel = new JPanel();
        createPanel.setLayout(new BoxLayout(createPanel, BoxLayout.Y_AXIS));
        JLabel chooseTribe = new JLabel("Choose a tribe:");
        JRadioButton btn1 = new JRadioButton("Mordor");
        JRadioButton btn2 = new JRadioButton("Dol Guldur");
        JRadioButton btn3 = new JRadioButton("Misty Mountains");

        btn1.setActionCommand("Mordor");
        btn2.setActionCommand("Dol Guldur");
        btn3.setActionCommand("Misty Mountains");

        ButtonGroup tribe = new ButtonGroup();
        tribe.add(btn1);
        tribe.add(btn2);
        tribe.add(btn3);

        createPanel.add(chooseTribe);
        createPanel.add(btn1);
        createPanel.add(btn2);
        createPanel.add(btn3);

        JLabel chooseRole = new JLabel("Choose a role:");
        JRadioButton btn4 = new JRadioButton("Basic");
        JRadioButton btn5 = new JRadioButton("Scout");
        JRadioButton btn6 = new JRadioButton("Leader");

        btn4.setActionCommand("Basic");
        btn5.setActionCommand("Scout");
        btn6.setActionCommand("Leader");

        ButtonGroup role = new ButtonGroup();
        role.add(btn4);
        role.add(btn5);
        role.add(btn6);

        createPanel.add(Box.createVerticalGlue());

        createPanel.add(chooseRole);
        createPanel.add(btn4);
        createPanel.add(btn5);
        createPanel.add(btn6);

        createPanel.add(Box.createVerticalGlue());

        JButton createBtn = new JButton("Create ork");
        createPanel.add(createBtn);
        createPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Army of Mordor");
        DefaultMutableTreeNode armyMordor = new DefaultMutableTreeNode("Mordor");
        DefaultMutableTreeNode armyMisty = new DefaultMutableTreeNode("Misty Mountains");
        DefaultMutableTreeNode armyGuldur = new DefaultMutableTreeNode("Dol Guldur");
        root.add(armyMordor);
        root.add(armyMisty);
        root.add(armyGuldur);
        DefaultTreeModel modelTree = new DefaultTreeModel(root);
        JTree armyTree = new JTree(modelTree);
        JScrollPane armyScrollP = new JScrollPane(armyTree);
        armyScrollP.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        splitPane.setLeftComponent(armyScrollP);
        splitPane.setRightComponent(createPanel);
        splitPane.setDividerLocation(225);

        frame.add(splitPane);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createBtn.addActionListener((ActionEvent e) -> {
            ButtonModel selectedTribe = tribe.getSelection();
            ButtonModel selectedRole = role.getSelection();
            if (selectedTribe != null && selectedRole != null) {
                //JOptionPane.showMessageDialog(null, "Selected tribe: " + selectedTribe.getActionCommand() + "\nSelected role:" + selectedRole.getActionCommand(), null, JOptionPane.INFORMATION_MESSAGE);
                Ork newOrk = createOrk(selectedTribe.getActionCommand(), selectedRole.getActionCommand());
                DefaultMutableTreeNode orkNode = new DefaultMutableTreeNode(newOrk);
                switch (selectedTribe.getActionCommand()) {
                    case "Mordor":
                        armyMordor.add(orkNode);
                        break;
                    case "Dol Guldur":
                        armyGuldur.add(orkNode);
                        break;
                    case "Misty Mountains":
                        armyMisty.add(orkNode);
                        break;
                }
                modelTree.reload();
            }
        });
    }

    private Ork createOrk(String tribe, String role) {
        OrkDirector director = new OrkDirector();
        OrkBuilder builder = OrkBuilderFactory.createBuilder(tribe);
        director.setOrkBuilder(builder);
        switch (role) {
            case "Basic":
                director.createBasicOrk();
                break;
            case "Scout":
                director.createScoutOrk();
                break;
            case "Leader":
                director.createLeaderOrk();
                break;
        }
        Ork ork = director.getOrk();
        return ork;
    }

}
