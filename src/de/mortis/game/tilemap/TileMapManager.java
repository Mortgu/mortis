package de.mortis.game.tilemap;

import de.mortis.game.graphics.Sprite;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;

public class TileMapManager {

    public static ArrayList<TileMap> tileMaps;

    public TileMapManager() {
        tileMaps = new ArrayList<>();
    }

    public TileMapManager(String path) {
        this();
    }

    private void addTileMap(String path, int blockWidth, int blockHeight) {
        String imagePath;
        String[] data = new String[10];

        Sprite sprite;

        try {
            System.out.println("Loading: " + path);

            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document document = builder.parse(new File(getClass().getClassLoader().getResource(path).toURI()));
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("tileset");
            Node node = list.item(0);
            Element element = (Element) node;

            imagePath = element.getAttribute("name");

            int tileWidth = Integer.parseInt(element.getAttribute("tileWidth"));
            int tileHeight = Integer.parseInt(element.getAttribute("tileHeight"));
            int tileCount = Integer.parseInt(element.getAttribute("tilecount"));
            int tileColumns = Integer.parseInt(element.getAttribute("columns"));

            sprite = new Sprite("tile/maps/image" + imagePath + ".png", tileWidth, tileHeight);

            list = document.getElementsByTagName("layer");
            int layers = list.getLength();

            for(int i = 0; i < layers; i++) {
                node = list.item(i);
                element = (Element) node;

                if(i <= 0) {
                    int width = Integer.parseInt(element.getAttribute("width"));
                    int height = Integer.parseInt(element.getAttribute("height"));
                }

                data[i] = element.getElementsByTagName("data").item(0).getTextContent();

                if(i >= 1) tileMaps.add(null);
                else tileMaps.add(null);
            }

        } catch (ParserConfigurationException | URISyntaxException | SAXException | IOException e) {
            System.out.println("ERROR (TILEMAPMANAGER): can not read tilemap.");
            System.exit(0);
        }
    }

    public void render(Graphics2D g) {
        for(int i = 0; i < tileMaps.size(); i++) {
            tileMaps.get(i).render(g);
        }
    }
}
