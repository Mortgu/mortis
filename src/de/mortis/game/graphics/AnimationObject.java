package de.mortis.game.graphics;

import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class AnimationObject {

    protected int currentAnimation;

    protected Animation animation;
    protected Sprite sprite;
    protected Vector2f position;
    protected int size, delay;

    public static boolean play;

    public AnimationObject(Sprite sprite, Vector2f position, int size, int delay) {
        this.sprite = sprite;
        this.position = position;
        this.size = size;
        this.delay = delay;

        animation = new Animation();

        setAnimation(0, sprite.getSpriteArray(0), delay);
    }

    private void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;

        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    private void animate() {
        if(play) {
            setAnimation(0, sprite.getSpriteArray(0), 0);
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    public void update() {
        animation.update();
    }

    public abstract void render(Graphics2D g);

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
}
