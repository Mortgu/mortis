package de.mortis.game.entitys;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    public Player(Sprite sprite, Vector2f position, int size) {
        super(sprite, position, size);
    }

    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

}
