package com.delhi.gui;

import java.awt.*;
import javax.swing.*;

public class AppPanel extends JPanel {
    private final int SCREEN_WIDTH = 800;
    private final int SCREEN_HEIGHT = 600;
    private Color BACKGROUND_COLOR = Color.black;

    public AppPanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(BACKGROUND_COLOR);
    }
}
