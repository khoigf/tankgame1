package GameComponents.Map;

import java.awt.Graphics2D;

import GameComponents.GamePanel;
import GameComponents.Objects.ObjectManager;
import Utilities.Image;
import Utilities.Tool;

public class Map02 {
    private GamePanel gamePanel;
    private ObjectManager objectManager;

    private int[][] map = {
            { 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2 },
            { 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 3, 2, 3, 2, 3, 2 },
            { 2, 3, 2, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 2, 3, 2 },
            { 2, 3, 2, 3, 2, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 2, 3, 2, 3, 2 },
            { 2, 3, 2, 3, 2, 3, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2 },
            { 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3 },
            { 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2, 3, 2 },
    };

    private Image[] mapImages = new Image[50];

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public Map02(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        objectManager = new ObjectManager();

        mapImages[0] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/dirt.png", 64, 64, 1));
        mapImages[1] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/soil02.png", 64, 64, 1));
        mapImages[2] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/grass01.jpg", 64, 64, 1));
        mapImages[3] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/grass03.jpg", 64, 64, 1));
        // mapImages[5] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/co.png", 64, 64, 1));

        initObject();
    }

    public void initObject() {

        for (int i = 18; i < 22; ++i) {
            objectManager.createObject("Tree", i * 64, 192);
        }
        for (int i = 6; i < 10; ++i) {
            objectManager.createObject("Tree", 64 * i, 64 * 2);
        }
        for (int i = 2; i < 6; ++i) {
            objectManager.createObject("Tree", 64 * 5, 64 * i);
        }
        for (int i = 12; i < 16; ++i) {
            objectManager.createObject("Tree", 64 * i, 64 * 9);
        }
        for (int i = 6; i < 10; ++i) {
            objectManager.createObject("Tree", 64 * 16, 64 * i);
        }
        objectManager.createObject("Tree", 64 * 10, 64 * 10);
        objectManager.createObject("Tree", 64 * 19, 64 * 10);
        objectManager.createObject("Tree", 64 * 2, 64 * 5);
        objectManager.createObject("Tree", 64 * 3, 64 * 6);
        objectManager.createObject("Tree", 64 * 17, 64 * 1);
        for (int i = 0; i < 4; ++i) {
            objectManager.createObject("Tree", i * 64, 8 * 64);
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
