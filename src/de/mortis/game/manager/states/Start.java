package de.mortis.game.manager.states;

import de.mortis.game.Window;
import de.mortis.game.entitys.Player;
import de.mortis.game.graphics.Effect;
import de.mortis.game.graphics.Sprite;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Start extends GameStates {

    public static Player player;
    public static int CamX = 0, CamY = 0;

    public static Effect effect;

    public static Sprite explosion_sprite;

    private static Sprite HEALTH_BAR, RIGHT_UI_ELEMENT;
    private static Sprite HEALTH_BAR_START;

    private static BufferedImage image, middle;

    @Override
    public void start() {
        player = new Player(new Sprite("entitys/player.png", 32), new Vector2f((float) (Window.width / 2) - 50 - CamX, (float) (Window.height / 2) - 50 - CamY), 100);

        explosion_sprite = new Sprite("effects/explosion.png", 64);
        effect = new Effect(explosion_sprite, new Vector2f((float) (Window.width / 2) - 115 - CamX, (float) (Window.height / 2) - 115 - CamY), 230, 6);

        // HEALTH BAR
        HEALTH_BAR = new Sprite("UI/healthbar/health_bar_back.png", 58, 10);

        HEALTH_BAR_START = new Sprite("UI/healthbar/healthbar_sheet.png", 1, 1);
        image = HEALTH_BAR_START.getSpriteSheet();

        RIGHT_UI_ELEMENT = new Sprite("UI/healthbar/right_ui_element.png", 58, 10);
    }

    @Override
    public void stop() {

    }

    // LIVE BAR
    public static int bar_width = 225, bar_x = 60;
    public static int bar_end = bar_x + bar_width;

    @Override
    public void render(Graphics2D g) {
        // player.render(g);
        effect.render(g);

        // HEALTH PROGRESSBAR

        // START IMAGE
        g.drawImage(image.getSubimage(0, 0, 4, 4), 45, 25, 20, 20, null);
        // MIDDLE IMAGE
        g.drawImage(image.getSubimage(5, 0, 1, 4), bar_x, 25, bar_width, 20, null);
        // END IMAGE
        g.drawImage(image.getSubimage(10, 0, 4, 4), bar_end, 25, 20, 20, null);

        g.drawImage(HEALTH_BAR.getSpriteSheet(), 20, 20, 58 * 5, 10 * 5, null);
        g.drawImage(RIGHT_UI_ELEMENT.getSpriteSheet(), Window.width - (58*5) - 20, 20, 58 * 5, 10 * 5, null);
    }

    @Override
    public void update() {
        //player.update();
        effect.update();
    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
