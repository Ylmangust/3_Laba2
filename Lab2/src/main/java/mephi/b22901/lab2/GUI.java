/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mephi.b22901.lab2;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import javax.swing.tree.*;

/**
 *
 * @author Регина
 */
public class GUI extends JFrame {

    public GUI() {

        try {
            InputStream fontStream = getClass().getResourceAsStream("/tolkien.ttf");
            if (fontStream == null) {
                throw new IOException("Font not found in resources");
            }
            Font customFont = Font.createFont(Font.TRUETYPE_FONT, fontStream).deriveFont(Font.BOLD, 16f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(customFont);

            UIManager.put("Label.font", customFont);
            UIManager.put("Button.font", customFont);
            UIManager.put("TextField.font", customFont);
            UIManager.put("TextArea.font", customFont);
            UIManager.put("RadioButton.font", customFont);
            UIManager.put("ProgressBar.foreground", Color.BLACK);
            UIManager.put("ProgressBar.background", Color.WHITE);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

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
      
        armyTree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreePath path = ((JTree) e.getSource()).getSelectionPath();
                    DefaultMutableTreeNode node = (DefaultMutableTreeNode) path.getLastPathComponent();
                    if (node.isLeaf() && node.getLevel() == 2) {
                        Ork selectedOrk = (Ork) node.getUserObject();
                        showOrkInfo(selectedOrk);
                    }
                }
            }
        });

        frame.add(splitPane);
        pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        createBtn.addActionListener((ActionEvent e) -> {
            ButtonModel selectedTribe = tribe.getSelection();
            ButtonModel selectedRole = role.getSelection();
            if (selectedTribe != null && selectedRole != null) {
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

    private void showOrkInfo(Ork ork) {
        JFrame frame = new JFrame("Ork Info");
        frame.setSize(500, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8, 2, 2, 10));
        JLabel nameLbl = new JLabel("Name: ");
        JLabel nameValue = new JLabel(ork.getName());
        JLabel bannerLbl = new JLabel("Banner: ");
        JLabel bannerValue = new JLabel(ork.getBanner());
        JLabel weaponLbl = new JLabel("Weapon: ");
        JLabel weaponValue = new JLabel(ork.getWeapon());
        JLabel armorLbl = new JLabel("Armor: ");
        JLabel armorValue = new JLabel(ork.getArmor());
        JLabel strengthLbl = new JLabel("Strength: ");
        JLabel agilityLbl = new JLabel("Agility: ");
        JLabel intelligenceLbl = new JLabel("Intelligence: ");
        JLabel hpLbl = new JLabel("HP: ");

        JProgressBar strengthBar = new JProgressBar(1, 100);
        strengthBar.setValue(ork.getStrength());
        strengthBar.setStringPainted(true);
        strengthBar.setString(Integer.toString(ork.getStrength()));

        JProgressBar agilityBar = new JProgressBar(1, 100);
        agilityBar.setValue(ork.getAgility());
        agilityBar.setStringPainted(true);
        agilityBar.setString(Integer.toString(ork.getAgility()));

        JProgressBar intelligenceBar = new JProgressBar(1, 50);
        intelligenceBar.setValue(ork.getIntelligence());
        intelligenceBar.setStringPainted(true);
        intelligenceBar.setString(Integer.toString(ork.getAgility()));

        JProgressBar hpBar = new JProgressBar(50, 200);
        hpBar.setValue(ork.getHp());
        hpBar.setStringPainted(true);
        hpBar.setString(Integer.toString(ork.getHp()));

        panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        panel.add(nameLbl);
        panel.add(nameValue);
        panel.add(bannerLbl);
        panel.add(bannerValue);
        panel.add(weaponLbl);
        panel.add(weaponValue);
        panel.add(armorLbl);
        panel.add(armorValue);
        panel.add(strengthLbl);
        panel.add(strengthBar);
        panel.add(agilityLbl);
        panel.add(agilityBar);
        panel.add(intelligenceLbl);
        panel.add(intelligenceBar);
        panel.add(hpLbl);
        panel.add(hpBar);
        frame.add(panel);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

}
