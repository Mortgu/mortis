package de.mortis.game.graphics;

import de.mortis.game.graphics.font.Font;
import de.mortis.game.util.Vector2f;

import javax.imageio.ImageIO;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Sprite {

    public BufferedImage spritesheet;
    public BufferedImage[][] spriteArray;

    private int w, h, wSprite, hSprite;

    public Sprite(String file, int tile_size) {
        w = tile_size;
        h = tile_size;

        System.out.println("Loading: " + file + "...");
        spritesheet = loadSprite(file);

        wSprite = spritesheet.getWidth() / w;
        hSprite = spritesheet.getHeight() / h;

        loadSpriteArray();
    }

    public Sprite(String file, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading: " + file + "...");
        spritesheet = loadSprite(file);

        wSprite = spritesheet.getWidth() / w;
        hSprite = spritesheet.getHeight() / h;

        loadSpriteArray();
    }

    private BufferedImage loadSprite(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sprite;
    }

    private void loadSpriteArray() {
        spriteArray = new BufferedImage[hSprite][wSprite];

        for(int y = 0; y < hSprite; y++) {
            for(int x = 0; x < wSprite; x++) {
                spriteArray[y][x] = getSprite(x, y);
            }
        }
    }

    public static void drawArray(Graphics2D g, Font font, String word, Vector2f pos, int width, int height, int xOffset, int yOffset) {
        float x = pos.x;
        float y = pos.y;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != 32) {
                g.drawImage(font.getFont(word.charAt(i)), (int) x, (int) y, width, height, null);
            }

            x += xOffset;
            y += yOffset;
        }
    }

    public BufferedImage getSpriteSheet() {
        return spritesheet;
    }

    public BufferedImage getSprite(int x, int y) {
        return spritesheet.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage[] getSpriteArray(int i) {
        return spriteArray[i];
    }
}
