package de.mortis.game.entitys;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    public static int HEALTH = 100, CURRENT_HEALTH = 100;

    public Player(Sprite sprite, Vector2f position, int size) {
        super(sprite, position, size);
    }

    public void move() {
        if(up) {
            dy -= acc;
            if(dy < -maxSpeed) dy = -maxSpeed;
        } else {
            if(dy < 0) { dy += deacc; if(dy > 0) { dy = 0; } }
        }

        if(down) {
            dy += acc;
            if(dy > maxSpeed) dy = maxSpeed;
        } else {
            if(dy > 0) { dy -= deacc;
                if(dy < 0) { dy = 0; }
            }
        }

        if(left) {
            dx -= acc;
            if(dx < -maxSpeed) dx = -maxSpeed;
        } else {
            if(dx < 0) { dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }

        if(right) {
            dx += acc;
            if(dx > maxSpeed) dx = maxSpeed;
        } else {
            if(dx > 0) { dx -= deacc; if(dx < 0) { dx = 0; } }
        }
    }

    public void update() {
        super.update();

        move();
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

    public void input(KeyHandler keyHandler, MouseHandler mouseHandler) {
        up = keyHandler.up.down;
        down = KeyHandler.down.down;
        left = KeyHandler.left.down;
        right = KeyHandler.right.down;
        attack = KeyHandler.attack.down;
    }


    public static int getHEALTH() {
        return HEALTH;
    }

    public static void setHEALTH(int HEALTH) {
        Player.HEALTH = HEALTH;
    }

    public static int getCurrentHealth() {
        return CURRENT_HEALTH;
    }

    public static void setCurrentHealth(int currentHealth) {
        CURRENT_HEALTH = currentHealth;
    }
}
