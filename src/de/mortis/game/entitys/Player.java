package de.mortis.game.entitys;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.handlers.KeyHandler;
import de.mortis.game.handlers.MouseHandler;
import de.mortis.game.manager.states.Start;
import de.mortis.game.util.Vector2f;

import java.awt.*;

public class Player extends Entity {

    public static int HEALTH = 100, CURRENT_HEALTH = 75;

    public Player(Sprite sprite, Vector2f position, int size) {
        super(sprite, position, size);
    }

    public void move() {
        if(up) {
            dy -= acc;
            if(dy < -maxSpeed)
                dy = -maxSpeed;
        } else {
            if(dy < 0) {
                dy += deacc;
                if(dy > 0) {
                    dy = 0;
                }
            }
        }

        if(down) {
            dy += acc;
            if(dy > maxSpeed)
                dy = maxSpeed;
        } else {
            if(dy > 0) {
                dy -= deacc;
                if(dy < 0) {
                    dy = 0;
                }
            }
        }

        if(left) {
            dx -= acc;
            if(dx < -maxSpeed)
                dx = -maxSpeed;
        } else {
            if(dx < 0) {
                dx += deacc;
                if(dx > 0) {
                    dx = 0;
                }
            }
        }

        if(right) {
            dx += acc;
            if(dx > maxSpeed)
                dx = maxSpeed;
        } else {
            if(dx > 0) {
                dx -= deacc;
                if(dx < 0) {
                    dx = 0;
                }
            }
        }
    }

    public void update() {
        super.update();
        move();

        Start.camX += dx;
        Start.camY += dy;
    }

    @Override
    public void render(Graphics2D graphics) {
        graphics.drawImage(animation.getImage(), (int) (position.x), (int) (position.y), size, size, null);
    }

    public void input(KeyHandler key, MouseHandler mouse) {
        up = key.up.down;
        down = key.down.down;
        left = key.left.down;
        right = key.right.down;
        attack = key.attack.down;
    }
}
