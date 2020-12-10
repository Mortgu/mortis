package de.mortis.game.handlers;

import de.mortis.game.GamePanel;
import de.mortis.game.graphics.Effect;
import de.mortis.game.graphics.animation.AnimationObject;
import de.mortis.game.manager.states.Start;
import de.mortis.game.util.Vector2f;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    public static Effect[] effects = new Effect[5];

    public MouseHandler(GamePanel game) {
        game.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!AnimationObject.play) {
            Start.effect.setDelay(5);
           Start.effect.setPosition(new Vector2f(e.getX() - (int) (Start.effect.getSize() / 2), e.getY() - (int) (Start.effect.getSize() / 2)));
            // effects[0] = new Effect(Start.EXPLOSIVE_SPRITE, new Vector2f(e.getX() - (int) (Start.effect.getSize() / 2), e.getY() - (int) (Start.effect.getSize() / 2)), 230, 6);
        }
        AnimationObject.play = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
