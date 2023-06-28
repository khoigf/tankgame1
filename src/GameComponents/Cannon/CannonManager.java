package GameComponents.Cannon;

import java.awt.Graphics2D;

import GameComponents.GamePanel;

public class CannonManager {

    public final int MAX_PLAYER = 5;
    private GamePanel gamePanel;

    private Cannon[] Cannons = new Cannon[MAX_PLAYER];

    private int numCannon = 2;

    public void createCannon() {
        Cannons[1].create(64 * 14, 64 * 3);
        Cannons[0].create(64 * 7, 64 * 8);

    }

    public void init() {
        for (int i = 0; i < MAX_PLAYER; ++i) {
            Cannons[i] = new Cannon(gamePanel, i);
        }
    }

    public CannonManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    public void update() {
        for (int i = 0; i < numCannon; ++i) {
            Cannons[i].update();
        }
    }

    public void render(Graphics2D graphics2d) {
        for (int i = 0; i < numCannon; ++i) {
            Cannons[i].render(graphics2d);
        }
    }
}
