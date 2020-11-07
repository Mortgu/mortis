package de.mortis.game.graphics.font;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public class Font {

    private BufferedImage FONT_SHEET = null;

    public int w, h;
    private final int wLetter, hLetter;

    public Font(String file) {
        int TILE_SIZE = 32;
        w = TILE_SIZE;
        h = TILE_SIZE;

        System.out.println("Loading: " + file + "...");
        FONT_SHEET = loadFont(file);

        wLetter = FONT_SHEET.getWidth() / w;
        hLetter = FONT_SHEET.getHeight() / h;

        loadFontArray();
    }

    public Font(String file, int w, int h) {
        this.w = w;
        this.h = h;

        System.out.println("Loading: " + file + "...");
        FONT_SHEET = loadFont(file);

        wLetter = FONT_SHEET.getWidth() / w;
        hLetter = FONT_SHEET.getHeight() / h;

        loadFontArray();
    }

    public int getWidth() { return w; }
    public int getHeight() { return h; }

    private BufferedImage loadFont(String file) {
        BufferedImage sprite = null;
        try {
            sprite = ImageIO.read(Objects.requireNonNull(getClass().getClassLoader().getResourceAsStream(file)));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return sprite;
    }

    public void loadFontArray() {
        BufferedImage[][] SPRITE_ARRAY = new BufferedImage[wLetter][hLetter];

        for(int x = 0; x < wLetter; x++) {
            for(int y = 0; y < hLetter; y++) {
                SPRITE_ARRAY[x][y] = getLetter(x, y);
            }
        }
    }

    public BufferedImage getLetter(int x, int y) {
        return FONT_SHEET.getSubimage(x * w, y * h, w, h);
    }

    public BufferedImage getFont(char letter) {
        int x = (int) letter % wLetter;
        int y = (int) letter / wLetter;
        return getLetter(x, y);
    }
}
