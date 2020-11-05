package de.mortis.game.handlers;

import de.mortis.game.GamePanel;
import de.mortis.game.graphics.AnimationObject;
import de.mortis.game.manager.states.Start;
import de.mortis.game.util.Vector2f;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {

    public MouseHandler(GamePanel game) {
        game.addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if(!AnimationObject.play) {
            Start.effect.setPosition(new Vector2f(e.getX() - (int) (Start.effect.getSize() / 2), e.getY() - (int) (Start.effect.getSize() / 2)));
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
