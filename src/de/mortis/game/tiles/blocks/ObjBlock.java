package de.mortis.game.tiles.blocks;

import de.mortis.game.util.AABB;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class ObjBlock extends Block {

    public ObjBlock(BufferedImage img, Vector2f position, int width, int height) {
        super(img, position, width, height);
    }

    public boolean update(AABB p) { return true; }

    public void render(Graphics2D g) {
        super.render(g);
    }

}
