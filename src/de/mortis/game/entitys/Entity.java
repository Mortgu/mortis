package de.mortis.game.entitys;

import de.mortis.game.graphics.Animation;
import de.mortis.game.graphics.Sprite;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity {

    protected Animation animation;
    protected Sprite sprite;
    protected Vector2f position;
    protected int size;

    // TODO: ADD KEY FUNCTIONS
    private final int DOWN = 2, LEFT = 1, RIGHT = 0, UP = 3;

    public Entity(Sprite sprite, Vector2f position, int size) {
        this.sprite = sprite;
        this.position = position;
        this.size = size;

        animation = new Animation();

        // -1 = NO ANIMATION
        setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 60);
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public void update() {
        animation.update();
    }

    public abstract void render(Graphics2D g);

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
