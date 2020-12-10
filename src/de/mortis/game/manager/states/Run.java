package de.mortis.game.manager.states;

import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;

import java.awt.Graphics2D;
import java.awt.Color;

public class Run extends GameStates {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void render(Graphics2D g) {

        g.setColor(Color.WHITE);
        // g.fillRect(0, 0, Window.width, Window.height);

        for(int i = 0; i < Start.menuButtons.length; i++) {
            Start.menuButtons[i].render(g);
        }
    }

    @Override
    public void update() {

    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
