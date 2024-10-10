package com.delhi.gui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Frame extends JFrame{
    private int width = 800;
    private int height = 600;

    public Frame() {
        setTitle("Cosmetic");
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
    
    public Frame(int w, int h) {
        width = w;
        height = h;

        setTitle("Cosmetic");
        setSize(new Dimension(width, height));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}
