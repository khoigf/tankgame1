package GameComponents.Map;

import java.awt.Graphics2D;

import GameComponents.GamePanel;
import GameComponents.Objects.ObjectManager;
import Utilities.Image;
import Utilities.Tool;

public class Map {

    private GamePanel gamePanel;
    private ObjectManager objectManager;

    private int[][] map = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
    };

    private Image[] mapImages = new Image[10];

    public ObjectManager getObjectManager() {
        return objectManager;
    }

    public Map(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        objectManager = new ObjectManager();

        mapImages[0] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/sand05.png", 64, 64, 1));
        //mapImages[1] = new Image(Tool.getBufferedImage("../Assets/Images/Maps/co.png", 64, 64, 1));

        initObject();
    }

    public void initObject() {

        for (int i = 0; i < 5; ++i) {
            objectManager.createObject("Tree1", 64 * 3 + i * 64, 64 * 3);
            objectManager.createObject("Tree1", 64 * 3 + i * 64, 64 * 2);
        }

        for (int i = 2; i < 6; ++i) {
            objectManager.createObject("Tree1", 64 * 16, i * 64);
            objectManager.createObject("Tree1", 64 * 17, i * 64);
        }

        for (int i = 14; i < 19; ++i) {
            objectManager.createObject("Tree1", i * 64, 64 * 8);
            objectManager.createObject("Tree1", i * 64, 64 * 9);
        }
        for (int i = 6; i < 10; ++i) {
            objectManager.createObject("Tree1", 64 * 4, i * 64);
            objectManager.createObject("Tree1", 64 * 5, i * 64);
        }
        objectManager.createObject("Rock", 64 * 12, 64 * 3);
        objectManager.createObject("Rock", 64 * 8, 64 * 9);
        objectManager.createObject("Rock", 64 * 4, 64 * 4);
        objectManager.createObject("Rock", 64 * 14, 64 * 10);
        objectManager.createObject("Rock", 64 * 16, 64 * 7);

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
