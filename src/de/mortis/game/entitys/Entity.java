package de.mortis.game.entitys;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.graphics.animation.Animation;
import de.mortis.game.util.Object;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Entity extends Object {

    protected Animation animation;
    protected Sprite sprite;
    protected Vector2f position;
    protected int size, currentAnimation;
    protected Object object;

    public static boolean up, down, right, left, attack;
    protected float dx, dy, maxSpeed = 0.5f, acc = 1f, deacc = 1f;

    public Entity(Sprite sprite, Vector2f position, int size) {
        super(position, size, size);

        this.sprite = sprite;
        this.position = position;
        this.size = size;

        animation = new Animation();

        setAnimation(2, sprite.getSpriteArray(2), 30);
    }

    public void setAnimation(int i, BufferedImage[] frames, int delay) {
        currentAnimation = i;
        animation.setFrames(frames);
        animation.setDelay(delay);
    }

    public void animate() {
        if(up) {
            int UP = 3;
            if(currentAnimation != UP || animation.getDelay() == -1) {
                setAnimation(UP, sprite.getSpriteArray(UP), 30);
            }
        } else if(down) {
            int DOWN = 2;
            if(currentAnimation != DOWN || animation.getDelay() == -1) {
                setAnimation(DOWN, sprite.getSpriteArray(DOWN), 30);
            }
        } else if(left) {
            int LEFT = 1;
            if(currentAnimation != LEFT || animation.getDelay() == -1) {
                setAnimation(LEFT, sprite.getSpriteArray(LEFT), 30);
            }
        } else if(right) {
            int RIGHT = 0;
            if(currentAnimation != RIGHT || animation.getDelay() == -1) {
                setAnimation(RIGHT, sprite.getSpriteArray(RIGHT), 30);
            }
        } else {
            setAnimation(currentAnimation, sprite.getSpriteArray(currentAnimation), -1);
        }
    }

    public void update() {
        animate();

        animation.update();
    }

    public void render(Graphics2D g) {object.render(g);}

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
