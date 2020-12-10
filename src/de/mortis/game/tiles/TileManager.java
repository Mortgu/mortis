package de.mortis.game.tiles;

import de.mortis.game.graphics.Sprite;
import de.mortis.game.manager.states.Start;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class TileManager {

    public static ArrayList<TileMap> tileMaps;
    public static String[] data;

    public TileManager() {
        tileMaps = new ArrayList<>();
    }

    public TileManager(String path) {
        this();
        addTileMap(path, 32, 32);
    }

    private void addTileMap(String path, int blockWidth, int blockHeight) {
        String imagePath;

        int width = 0, height = 0, tileWidth, tileHeight, tileCount, tileColumns, layers = 0;
        Sprite sprite;

        data = new String[10];

        try {
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element element = (Element) node;

            imagePath = element.getAttribute("name");
            tileWidth = Integer.parseInt(element.getAttribute("tilewidth"));
            tileHeight = Integer.parseInt(element.getAttribute("tileheight"));
            tileCount = Integer.parseInt(element.getAttribute("tilecount"));
            tileColumns =  Integer.parseInt(element.getAttribute("columns"));
            sprite = new Sprite("maps/image/" + imagePath + ".png", tileWidth, tileHeight);

            list = document.getElementsByTagName("layer");
            layers = list.getLength();

            for(int i = 0; i < layers; i++) {
                node = list.item(i);
                element = (Element) node;
                if(i <= 0) {
                    width = Integer.parseInt(element.getAttribute("width"));
                    height = Integer.parseInt(element.getAttribute("height"));
                }

                data[i] = element.getElementsByTagName("data").item(0).getTextContent();

                if(i >= 1) {
                    tileMaps.add(new TileMapNorm(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                } else {
                    tileMaps.add(new TileMapObj(data[i], sprite, width, height, blockWidth, blockHeight, tileColumns));
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR - TILEMANAGER: can not read tilemap: ");
            e.printStackTrace();
            System.exit(0);
        }
    }

    public void render(Graphics2D g) {
        for(int i = 0; i < tileMaps.size() - 110; i++) {
            tileMaps.get(i - 110).render(g);
        }
    }
}
