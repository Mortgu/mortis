package de.mortis.game;

import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStateManager;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class GamePanel extends JPanel implements Runnable {

    private Graphics2D g;
    private BufferedImage image;
    private final GameStateManager gameStateManager;
    private Thread thread;

    private Main main;

    private KeyHandler keyHandler;
    private MouseHandler mouseHandler;

    public GamePanel(int width, int height) {
        Window.width = width;
        Window.height = height;

        gameStateManager = Main.getGameStateManager();

        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
        requestFocus();
    }

    @Override
    public void addNotify() {
        super.addNotify();

        if(thread == null) {
            thread = new Thread(this, "GameThread");
            thread.start();
        }
    }

    @Override
    public void run() {
        image = new BufferedImage(Window.width, Window.height, BufferedImage.TYPE_INT_ARGB);
        g = (Graphics2D) image.getGraphics();

        mouseHandler = new MouseHandler(this);
        keyHandler = new KeyHandler(this);

        while(true) {
            input(keyHandler, mouseHandler);
            render();
            draw();
            update();
        }
    }

    public void render() {
        if(g != null) {
            g.setColor(new Color(255, 255, 255));
            g.fillRect(0, 0, Window.width, Window.height);

            gameStateManager.render(g);
        }
    }

    public void draw() {
        Graphics g2 = (Graphics) this.getGraphics();
        g2.drawImage(image, 0, 0, getWidth(), getHeight(), null);
        g2.dispose();
    }

    public void update() {
        gameStateManager.update();
    }

    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {
        gameStateManager.input(keyHandler, mouseHandler);
    }
}
