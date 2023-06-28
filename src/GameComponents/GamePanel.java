package GameComponents;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JPanel;

import GameComponents.Buff.Buff;
import GameComponents.Buff.BuffManager;
import GameComponents.Bullets.BulletManager;
import GameComponents.Cannon.CannonManager;
import GameComponents.Map.Map;
import GameComponents.Map.Map01;
import GameComponents.Map.Map02;
import GameComponents.Map.Map03;
import GameComponents.Players.PlayerManager;
import GameComponents.Title.TitleManager;
import Inputs.KeyHandler;

public class GamePanel extends JPanel implements Runnable {

    public final int SCREEN_WIDTH = 1408;
    public final int SCREEN_HEIGHT = 64 * 12;
    public final int PIXEL = 64;
    public final int SCREEN_ROW = SCREEN_HEIGHT / PIXEL;
    public final int SCREEN_COLUMN = SCREEN_WIDTH / PIXEL;

    public final int GAME_FPS = 120;
    public final int GAME_UPS = 100;

    private int displayFPS = GAME_FPS, displayUPS = GAME_UPS;

    private Thread gameThread;
    private KeyHandler keyHandler = new KeyHandler(this);
    private Map map = new Map(this);
    private PlayerManager playerManager = new PlayerManager(this);
    private CannonManager cannonManager = new CannonManager(this);

    private BulletManager bulletManager = new BulletManager(this);
    private CollisionChecker collisionChecker = new CollisionChecker(this);
    private BuffManager buffManager = new BuffManager(this);
    private TitleManager titleManager = new TitleManager(this);

    public Map getMap() {
        return map;
    }

    public TitleManager getTitleManager() {
        return titleManager;
    }

    public CannonManager cannonManager() {
        return cannonManager;
    }

    public PlayerManager getPlayerManager() {
        return playerManager;
    }

    public BulletManager getBulletManager() {
        return bulletManager;
    }

    public CollisionChecker getCollisionChecker() {
        return collisionChecker;
    }

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public GamePanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.setFocusable(true); // gamePanel can be focused to receive key input
    }

    public void start() {

        gameThread = new Thread(this);
        gameThread.start(); // Automatic call run method

        playerManager.createPlayer();

        playerManager.createPlayer();

        playerManager.createPlayer();

        cannonManager.createCannon();

        buffManager.createRandom(5);

        titleManager.createTitle();

    }

    @Override
    public void run() {

        double timePerFrame = (double) (1000000000.0 / GAME_FPS);// đổi sang ns
        double timePerUpdate = (double) (1000000000.0 / GAME_UPS);

        long currentTime;

        long lastCheck = System.currentTimeMillis();// ms
        long previousTime = System.nanoTime();// ns

        double deltaF = 0;
        double deltaU = 0;

        int updates = 0;
        int frames = 0;

        while (gameThread != null) {
            currentTime = System.nanoTime();
            deltaF += (currentTime - previousTime) / timePerFrame;
            deltaU += (currentTime - previousTime) / timePerUpdate;
            previousTime = currentTime;
            if (deltaU >= 1) {
                // 1. UPDATE: Update game variant such as character position, heal,...
                update();
                deltaU = deltaU - 1;
                updates = updates + 1;
            }
            if (deltaF >= 1) {
                // 2. DRAW: render the screen with the updated game variant
                repaint();
                deltaF = deltaF - 1;
                frames = frames + 1;

            }

            if (System.currentTimeMillis() - lastCheck >= 1000) {
                lastCheck = System.currentTimeMillis();
                // System.out.println("FPS: " + frames + " | UPS: " + updates);
                displayFPS = frames;
                displayUPS = updates;
                frames = 0;
                updates = 0;
            }
        }
    }

    public void update() {
        map.update();
        playerManager.update();
        bulletManager.update();
        collisionChecker.update();
        buffManager.update();
        // cannonManager.update();
        titleManager.update();
    }

    public void paintComponent(Graphics graphics) {

        Toolkit.getDefaultToolkit().sync(); // os is Linux

        super.paintComponent(graphics);

        Graphics2D graphics2d = (Graphics2D) graphics;

        map.render(graphics2d);
        playerManager.render(graphics2d);
        bulletManager.render(graphics2d);
        cannonManager.render(graphics2d);
        titleManager.render(graphics2d);
        buffManager.render(graphics2d);
    }

    public int getFPS() {
        return displayFPS;
    }

    public int getUPS() {
        return displayUPS;
    }
}
