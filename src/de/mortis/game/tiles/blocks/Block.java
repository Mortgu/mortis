package de.mortis.game.tiles.blocks;

import de.mortis.game.manager.states.Start;
import de.mortis.game.util.AABB;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Block {

    protected int width, height;

    public BufferedImage img;
    public Vector2f position;

    public Block(BufferedImage img, Vector2f position, int width, int height) {
        this.img = img;
        this.position = position;
        this.width = width;
        this.height = height;
    }

    public abstract boolean update(AABB p);

    public void render(Graphics2D g) {
        g.drawImage(img, (int) position.getWorldVar().x - Start.camX, (int) position.getWorldVar().y - Start.camY, width, height, null);
    }

}
