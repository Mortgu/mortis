package de.mortis.game.manager.states;

import de.mortis.game.UI.Health;
import de.mortis.game.Window;
import de.mortis.game.entitys.Player;
import de.mortis.game.graphics.Effect;
import de.mortis.game.graphics.Sprite;
import de.mortis.game.graphics.font.Font;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Start extends GameStates {

    public static Player player;
    private static Font font;

    public static Effect effect;

    public static Sprite EXPLOSIVE_SPRITE;
    private static Sprite RIGHT_UI_ELEMENT, HEALTH_BAR;

    private static BufferedImage image;

    @Override
    public void start() {

        player = new Player(new Sprite("entity/player.png", 32), new Vector2f((float) (Window.width / 2) - 50, (float) (Window.height / 2) - 50), 100);
        font = new Font("font/font.png", 10, 10);

        EXPLOSIVE_SPRITE = new Sprite("effects/explosion.png", 64);
        effect = new Effect(EXPLOSIVE_SPRITE, new Vector2f((float) (Window.width / 2) - 115, (float) (Window.height / 2) - 115), 230, 6);

        // HEALTH BAR
        HEALTH_BAR = new Sprite("UI/healthbar/health_bar_back.png", 58, 10);

        Sprite HEALTH_BAR_START = new Sprite("UI/healthbar/healthbar_sheet.png", 1, 1);
        image = HEALTH_BAR_START.getSpriteSheet();

        RIGHT_UI_ELEMENT = new Sprite("UI/healthbar/right_ui_element.png", 58, 10);
    }

    @Override
    public void stop() {

    }

    // LIVE BAR
    public static int BAR_WIDTH = 225, BAR_X = 60;
    public static int BAR_END = BAR_X + BAR_WIDTH;

    @Override
    public void render(Graphics2D g) {
        effect.render(g);

        // HEALTH PROGRESSBAR

        // START IMAGE
        g.drawImage(image.getSubimage(0, 0, 4, 4), 45, 25, 20, 20, null);
        // MIDDLE IMAGE
        g.drawImage(image.getSubimage(5, 0, 1, 4), BAR_X, 25, BAR_WIDTH, 20, null);
        // END IMAGE
        g.drawImage(image.getSubimage(10, 0, 4, 4), BAR_END, 25, 20, 20, null);

        g.drawImage(HEALTH_BAR.getSpriteSheet(), 20, 20, 58 * 5, 10 * 5, null);
        g.drawImage(RIGHT_UI_ELEMENT.getSpriteSheet(), Window.width - (58*5) - 20, 20, 58 * 5, 10 * 5, null);

        Sprite.drawArray(g, font, "HALLO", new Vector2f(Window.width - 190, 30), 25, 25, 17, 0);
    }

    @Override
    public void update() {
        effect.update();

        Start.BAR_WIDTH = (int) Math.round(new Health().calculatePercentage(Player.CURRENT_HEALTH, Player.HEALTH) * 2);
        Start.BAR_END = Start.BAR_X + Start.BAR_WIDTH;
    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {

    }
}
