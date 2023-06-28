package GameComponents.Title;

import java.awt.Graphics2D;

import GameComponents.GamePanel;

public class TitleManager {

    public final int MAX_TITLE = 10;
    private GamePanel gamePanel;

    private Title[] Titles = new Title[MAX_TITLE];

    public int numTitle = 4;

    public Title[] getTitles(){
        return Titles;
    }

    public void createTitle() {
        Titles[0].create(64 * 10, 64*3, 64, 64 * 2);
        Titles[1].create(64 * 11, 64 * 5, 64 * 2, 64);
        Titles[2].create(64 * 10, 64 * 6, 64, 64 * 2);
        Titles[3].create(64 * 8, 64 * 5, 64 * 2, 64);

    }

    public void init() {
        for (int i = 0; i < MAX_TITLE; ++i) {
            Titles[i] = new Title(gamePanel, i);
        }
    }

    public TitleManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    public void update() {
        for (int i = 0; i < numTitle; ++i) {
            Titles[i].update();
        }
    }

    public void render(Graphics2D graphics2d) {
        for (int i = 0; i < numTitle; ++i) {
            Titles[i].render(graphics2d);
        }
    }
}

