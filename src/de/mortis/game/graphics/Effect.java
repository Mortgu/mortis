package de.mortis.game.graphics;

import de.mortis.game.graphics.animation.AnimationObject;
import de.mortis.game.util.Vector2f;

import java.awt.*;

public class Effect extends AnimationObject {

    public Effect(Sprite sprite, Vector2f position, int size, int delay) {
        super(sprite, position, size, delay);
    }

    public void update() {
        super.update();
    }

    @Override
    public void render(Graphics2D g) {
        g.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }


}
