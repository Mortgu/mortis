package de.mortis.game.util;

import java.awt.*;

public class Object {

    Vector2f position;
    int width, height;

    public Object(Vector2f position, int width, int height) {
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public void render(Graphics2D g) {

    }

    public Vector2f getPosition() {
        return position;
    }

    public void setPosition(Vector2f position) {
        this.position = position;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
