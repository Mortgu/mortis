package de.mortis.game.handlers;

import de.mortis.game.GamePanel;
import de.mortis.game.graphics.AnimationObject;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public KeyHandler(GamePanel game) {
        game.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            AnimationObject.play = !AnimationObject.play;
            System.out.println("test");
        }
    }
}
