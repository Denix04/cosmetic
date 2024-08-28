package com.delhi.gui;

import javax.swing.*;

public class AppFrame extends JFrame{
    public AppFrame(JPanel panel) {
        this.add(panel);
        this.pack();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Cosmetic");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
