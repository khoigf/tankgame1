package GameComponents.Players;

import java.awt.Graphics2D;

import GameComponents.GamePanel;

public class PlayerManager {
    
    public final int MAX_PLAYER = 5;
    private GamePanel gamePanel;

    private Player[] players = new Player[MAX_PLAYER];

    private int numPlayer = 0;

    public Player[] getPlayer() {
        return players;
    }

    public Player getPlayer(int player_id) {
        return players[player_id];
    }

    public void shoot(int id) {
        players[id].shoot();
    }

    public void createPlayer() {
        players[numPlayer].create((numPlayer + 1) * 200, 100);
        numPlayer = numPlayer + 1;
    }

    public void init() {
        for(int i = 0; i < MAX_PLAYER; ++i) {
            players[i] = new Player(gamePanel, i);
        }
    }

    public PlayerManager(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        init();
    }

    public void update() {
        for(int i = 0; i < numPlayer; ++i) {
            players[i].update();
        }
    }

    public void render(Graphics2D graphics2d) {
        for(int i = 0; i < numPlayer; ++i) {
            players[i].render(graphics2d);
        }
    }
}
