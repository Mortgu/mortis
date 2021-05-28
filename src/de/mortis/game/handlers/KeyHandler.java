package de.mortis.game.handlers;

import de.mortis.game.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
    }

    public static Key up = new Key();
    public static Key down = new Key();
    public static Key left = new Key();
    public static Key right = new Key();
    public static Key attack = new Key();
    public static Key menu = new Key();
    public static Key enter = new Key();
    public static Key escape = new Key();

    public void toggle(KeyEvent event, boolean pressed) {
        if (event.getKeyCode() == KeyEvent.VK_W)
            up.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_S)
            down.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_A)
            left.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_D)
            right.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_SPACE)
            attack.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_E)
            menu.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_ENTER)
            enter.toggle(pressed);
        if (event.getKeyCode() == KeyEvent.VK_ESCAPE)
            escape.toggle(pressed);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        toggle(e, true);
    }

    @Override
    public void keyReleased(KeyEvent e) {
        toggle(e, false);
    }
}
