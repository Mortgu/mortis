package de.mortis.game;

import javax.swing.*;

public class Window extends JFrame {

    public static int width = 1000, height = 600;

    public Window() {
        setTitle("Space Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new GamePanel(width, height));
        setResizable(false);
        pack();
        setLocationRelativeTo(null);

        setVisible(true);
    }
}
