package de.mortis.game.handlers;

import de.mortis.game.GamePanel;
import de.mortis.game.UI.Health;
import de.mortis.game.entitys.Player;
import de.mortis.game.graphics.AnimationObject;
import de.mortis.game.manager.states.Start;

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
        if(e.getKeyCode() == KeyEvent.VK_UP) {
            if(!(Start.bar_width >= 225)) {
                Start.bar_width += 4;
                Start.bar_end = Start.bar_x + Start.bar_width;
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN) {
            if(!(Start.bar_width <= 0)) {
                Start.bar_width -= 4;
                Start.bar_end = Start.bar_x + Start.bar_width;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_Q) {
            AnimationObject.play = !AnimationObject.play;
            System.out.println("test");
        }
    }
}
