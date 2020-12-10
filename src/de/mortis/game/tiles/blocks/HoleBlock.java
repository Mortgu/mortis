package de.mortis.game.tiles.blocks;

import de.mortis.game.manager.states.Start;
import de.mortis.game.util.AABB;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HoleBlock extends Block {

    public HoleBlock(BufferedImage img, Vector2f position, int width, int height) {
        super(img, position, width, height);
    }

    public boolean update(AABB p) { return false; }


    public void render(Graphics2D g) {
        super.render(g);

        if(NormBlock.debug_lines_norm) {
            g.setColor(new Color(255, 255, 255));
            g.drawRect((int) position.getWorldVar().x - Start.camX, (int) position.getWorldVar().y - Start.camY, width, height);
        }
    }

}
