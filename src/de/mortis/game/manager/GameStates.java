package de.mortis.game.manager;

import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;

import java.awt.Graphics2D;

public abstract class GameStates {

    public static final int START = 0, RUN = 1, END = 2;

    public abstract void start();
    public abstract void stop();

    public abstract void render(Graphics2D g);
    public abstract void update();
    public abstract void input(KeyHandler keyHandler, MouseHandler mouseHandler);

}
