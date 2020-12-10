package de.mortis.game.tiles;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.tiles.blocks.Block;
import de.mortis.game.tiles.blocks.HoleBlock;
import de.mortis.game.tiles.blocks.ObjBlock;
import de.mortis.game.util.Vector2f;

import java.awt.*;
import java.util.HashMap;

public class TileMapObj extends TileMap {

    public static HashMap<String, Block> tmo_blocks;

    public TileMapObj(String data, Sprite sprite, int width, int height, int tileWidth, int tileHeight, int tileColumns) {
        Block tempBlock;
        tmo_blocks = new HashMap<>();

        String[] block = data.split(",");
        for(int i = 0; i < (width * height); i++) {
            int temp = Integer.parseInt(block[i].replaceAll("\\s+", ""));
            if(temp != 0) {
                if(temp == 172) {
                    tempBlock = new HoleBlock(sprite.getSprite((temp - 1) % tileColumns, (temp - 1) / tileColumns), new Vector2f((i % width) * tileWidth, (i / height) * tileHeight), tileWidth, tileHeight);
                } else {
                    tempBlock = new ObjBlock(sprite.getSprite((temp - 1) % tileColumns, (temp - 1) / tileColumns), new Vector2f((i % width) * tileWidth, (i / height) * tileHeight), tileWidth, tileHeight);
                }
                tmo_blocks.put((i % width) + "," + (i / height), tempBlock);
            }
        }
    }

    @Override
    public void render(Graphics2D g) {
        for(Block block : tmo_blocks.values()) {
            block.render(g);
        }
    }
}
