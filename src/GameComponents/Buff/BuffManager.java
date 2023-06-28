package GameComponents.Buff;

import java.awt.Graphics2D;

import GameComponents.GamePanel;
import Utilities.Tool;

public class BuffManager {

    public final int MAX = 100;

    private Buff[] buffs = new Buff[MAX];
    private GamePanel gamePanel;

    public void createRandom(int number) {
        for (int i = 0; i < number; ++i) {
            createBuff(Tool.Random(0, gamePanel.SCREEN_WIDTH), Tool.Random(0, gamePanel.SCREEN_HEIGHT));
        }
    }

    public BuffManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    public void init() {
        for (int i = 0; i < MAX; ++i) {
            buffs[i] = new Buff(gamePanel);
        }
    }

    public void createBuff(int x, int y) {
        for (int i = 0; i < MAX; ++i) {
            if (buffs[i].inUse() == false) {
                buffs[i].active(x, y);
                break;
            }
        }
    }

    public void update() {
        for (int i = 0; i < MAX; ++i) {
            buffs[i].update();
        }
    }

    public void render(Graphics2D graphics2d) {
        for (int i = 0; i < MAX; ++i) {
            buffs[i].render(graphics2d);
        }
    }
}
