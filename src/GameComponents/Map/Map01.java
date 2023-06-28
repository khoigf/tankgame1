package GameComponents.Map;

import java.awt.Graphics2D;

import GameComponents.GamePanel;
import GameComponents.Objects.ObjectManager;
import Utilities.Image;
import Utilities.Tool;

public class Map01 {
    private GamePanel gamePanel;
    private ObjectManager objectManager;

    private int[][] map = {
            { 3, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 2, 1, 1, 1, 1, 2, 3, 3, 3, 3, 3, 3, 3, 3 },
            { 3, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 3, 3, 3, 3, 3, 3, 3, 3, 3 },
            { 2, 2, 2, 2, 2, 2, 2, 2, 0, 1, 1, 1, 1, 3, 2, 2, 2, 2, 2, 2, 2, 2 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 },
            { 2, 2, 2, 2, 2, 2, 2, 2, 3, 1, 1, 1, 1, 0, 2, 2, 2, 2, 2, 2, 2, 2 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 3, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 3, 3, 3, 3, 3, 3, 3, 3, 2, 1, 1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0 },
    };

    private Image[] mapImages = new Image[50];

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public Map01(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        objectManager = new ObjectManager();

        mapImages[0] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/betong01.png", 64, 64, 1));
        mapImages[1] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/road00.png", 64, 64, 1));
        mapImages[2] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/brickbrown.png", 64, 64, 1));
        mapImages[3] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/soil.png", 64, 64, 1));
        
        
        initObject();
    }

    public void initObject() {

        for (int i = 18; i < 22; ++i) {
            objectManager.createObject("Tree", i * 64, 192);
        }
        // for (int i = 0; i < 3; ++i) {
        //     objectManager.createObject("Tree", 0, 64 * i);
        // }
        objectManager.createObject("Tree", 64 * 8, 64 * 7);
        for (int i = 0; i < 4; ++i) {
            objectManager.createObject("Tree", i * 64, 8 * 64);
        }
        // for (int i = 0; i < 2; ++i) {
        //     objectManager.createObject("Wall", 64 * 14, i * 64);
        // }
        for (int i = 0; i < 2; ++i) {
            objectManager.createObject("Wall", 64 * 7, i * 64);
        }

        // for (int i = 10; i < 12; ++i) {
        //     objectManager.createObject("Wall", 7 * 64, i * 64);
        // }
        for (int i = 0; i < 4; ++i) {
            objectManager.createObject("Wall", i * 64, 64 * 3 + 32);
        }
        for (int i = 18; i < 22; ++i) {
            objectManager.createObject("Wall", i * 64, 8 * 64 - 32);
        }
    }

    public void update() {
        objectManager.update();
    }

    public void render(Graphics2D graphics2d) {
        for (int i = 0; i < gamePanel.SCREEN_ROW; ++i) {
            for (int j = 0; j < gamePanel.SCREEN_COLUMN; ++j) {
                graphics2d.drawImage(mapImages[map[i][j]].getImage(), j * gamePanel.PIXEL, i * gamePanel.PIXEL,
                        mapImages[map[i][j]].getWidth(), mapImages[map[i][j]].getHeight(), null);
            }
        }

        objectManager.render(graphics2d);
    }
}
