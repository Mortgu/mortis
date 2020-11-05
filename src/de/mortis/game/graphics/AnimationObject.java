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

    public static boolean play = true;

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
            if(currentAnimation != 0 || animation.getDelay() == -1) {
                setAnimation(0, sprite.getSpriteArray(0), 10);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    public void stop() {
        if(animation.getCurrentFrame() == animation.getNumFrame() - 1) {
            play = false;
        }
    }

    public void update() {
        animate();

        animation.update();

        stop();
    }

    public abstract void render(Graphics2D g);

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public Sprite getSprite() {
        return sprite;
    }

    public void setSprite(Sprite sprite) {
        this.sprite = sprite;
    }

    public int getCurrentAnimation() {
        return currentAnimation;
    }

    public void setCurrentAnimation(int currentAnimation) {
        this.currentAnimation = currentAnimation;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
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

    public static boolean isPlay() {
        return play;
    }

    public static void setPlay(boolean play) {
        AnimationObject.play = play;
    }
}
