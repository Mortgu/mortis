package de.mortis.game.buttons;

import de.mortis.game.Window;
import de.mortis.game.graphics.Sprite;

import java.awt.*;

public class MenuButtons extends ButtonObject {

    public MenuButtons(int x, int y, int width, int height, Sprite sprite, boolean hover) {
        super(x, y, width, height, sprite, hover);
    }

    public void render(Graphics2D g) {
        g.drawImage(sprite.getSpriteSheet().getSubimage(41, 0, 32, 13), Window.width / 2 - (13*3), Window.height / 2, 32 * 6, 13 * 6, null);
        g.drawImage(sprite.getSpriteSheet().getSubimage(0, 0, 38, 13), Window.width / 2 - (19*3), Window.height / 2, 38 * 6, 13 * 6, null);
    }

    public void update() {
        // setHover(!isHover());
    }
}
