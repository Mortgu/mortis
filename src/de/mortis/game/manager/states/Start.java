package de.mortis.game.manager.states;

import de.mortis.game.UI.Health;
import de.mortis.game.Window;
import de.mortis.game.buttons.MenuButtons;
import de.mortis.game.entitys.Player;
import de.mortis.game.graphics.Effect;
import de.mortis.game.graphics.Sprite;
import de.mortis.game.graphics.font.Font;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.GameStates;
import de.mortis.game.tiles.TileManager;
import de.mortis.game.util.Vector2f;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Start extends GameStates {

    public static Player player;
    private static Font font;

    public static Effect effect;

    public static Sprite EXPLOSIVE_SPRITE;
    private static Sprite RIGHT_UI_ELEMENT;
    private static Sprite HEALTH_BAR;

    private static BufferedImage image;

    // HEALTH BAR
    public static int BAR_WIDTH = 225, BAR_X = 60;
    public static int BAR_END = BAR_X + BAR_WIDTH;

    // CAMERA
    public static int camX = 0, camY = 0;

    // MENU BUTTONS
    public static MenuButtons[] menuButtons = new MenuButtons[3];

    // TILEMAP
    private static TileManager tileMapManager;

    @Override
    public void start() {

        // PLAYER / FONT
        player = new Player(new Sprite("entity/player.png", 32), new Vector2f((float) (Window.width / 2) - 72 - camX, (float) (Window.height / 2) - 72 - camY), 100);
        font = new Font("font/font.png", 10, 10);

        // TILEMAP MANAGER
        tileMapManager = new TileManager("maps/map.xml");

        // EFFECT
        EXPLOSIVE_SPRITE = new Sprite("effects/explosion.png", 64);
        effect = new Effect(EXPLOSIVE_SPRITE, new Vector2f((float) (Window.width / 2) - 115, (float) (Window.height / 2) - 115), 230, 6);

        // UI

        // HEALTH BAR
        HEALTH_BAR = new Sprite("UI/healthbar/health_bar_back.png", 58, 10);

        Sprite HEALTH_BAR_START = new Sprite("UI/healthbar/healthbar_sheet.png", 1, 1);
        image = HEALTH_BAR_START.getSpriteSheet();

        RIGHT_UI_ELEMENT = new Sprite("UI/healthbar/right_ui_element.png", 58, 10);

        // MENU BUTTONS
        Sprite button_sprite = new Sprite("UI/buttons/button_sheeet.png", 38, 13);
        for(int i = 0; i < menuButtons.length; i++) {
            menuButtons[i] = new MenuButtons(Window.width / 2 - 19, 13, 38, 13, button_sprite, false);
        }
    }

    @Override
    public void stop() {

    }

    @Override
    public void render(Graphics2D g) {


        // TILEMAP MANAGER RENDER
        tileMapManager.render(g);

        // TEST EFFECT RENDER
        effect.render(g);

        // PLAYER RENDER
        player.render(g);

        // HEALTH PROGRESSBAR

        // START IMAGE
        g.drawImage(image.getSubimage(0, 0, 4, 4), 45, 25, 20, 20, null);
        // MIDDLE IMAGE
        g.drawImage(image.getSubimage(5, 0, 1, 4), BAR_X, 25, BAR_WIDTH, 20, null);
        // END IMAGE
        g.drawImage(image.getSubimage(10, 0, 4, 4), BAR_END, 25, 20, 20, null);

        g.drawImage(HEALTH_BAR.getSpriteSheet(), 20, 20, 58 * 5, 10 * 5, null);
        g.drawImage(RIGHT_UI_ELEMENT.getSpriteSheet(), Window.width - (58*5) - 20, 20, 58 * 5, 10 * 5, null);

        // QUEST TEST TEXT
        Sprite.drawArray(g, font, "> KILL 10 ENEMYS [0/10]", new Vector2f(20 - camX, 100 - camY), 23, 23, 15, 0);
    }

    @Override
    public void update() {

        // EFFECT UPDATE
        effect.update();

        // PLAYER UPDATE
        player.update();

        // HEALTH BAR UPDATE
        Start.BAR_WIDTH = (int) Math.round(new Health().calculatePercentage(Player.CURRENT_HEALTH, Player.HEALTH) * 2 + 25);
        Start.BAR_END = Start.BAR_X + Start.BAR_WIDTH;
    }

    @Override
    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {
        player.input(keyHandler, mouseHandler);
    }
}
