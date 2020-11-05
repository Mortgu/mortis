package de.mortis.game.manager.states;

import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;

import java.awt.*;

public class Run extends GameStates {

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public void render(Graphics2D g) {
        Start.effect.render(g);
    }

    @Override
    public void update() {
        Start.effect.update();
    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
