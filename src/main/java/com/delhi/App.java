package com.delhi;

import com.delhi.gui.*;

public class App {
    public static void main(String[] args ) {

        AppPanel panel = new AppPanel();
        AppFrame frame = new AppFrame(panel);
        System.out.println("Hello World!" );
    }
}
