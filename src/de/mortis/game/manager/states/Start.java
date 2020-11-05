package de.mortis.game.manager.states;

import de.mortis.game.Main;
import de.mortis.game.Window;
import de.mortis.game.entitys.Player;
import de.mortis.game.graphics.Effect;
import de.mortis.game.graphics.Sprite;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;
import de.mortis.game.tilemap.TileMapManager;
import de.mortis.game.util.Vector2f;

import java.awt.*;

public class Start extends GameStates {

    public static Player player;
    public static int CamX = 0, CamY = 0;

    public static Effect effect;

    private static TileMapManager tileMapManager;

    @Override
    public void start() {
        player = new Player(new Sprite("entitys/player.png", 32), new Vector2f((float) (Window.width / 2) - 50 - CamX, (float) (Window.height / 2) - 50 - CamY), 100);

        // TODO: MAKE IT WORK
        tileMapManager = new TileMapManager("maps/tiledawmap.xml");

        effect = new Effect(new Sprite("effects/shatter_effect.png", 96), new Vector2f(100, 100), 230, 8);
        effect.setDelay(0);
    }

    @Override
    public void stop() {

    }

    @Override
    public void render(Graphics2D g) {
        tileMapManager.render(g);

        effect.render(g);
    }

    @Override
    public void update() {
        player.update();
        effect.update();
    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
