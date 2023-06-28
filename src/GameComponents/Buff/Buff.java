package GameComponents.Buff;

import java.awt.Graphics2D;

import GameComponents.GamePanel;
import Utilities.HitBox;
import Utilities.Image;
import Utilities.Tool;

public class Buff {

    private int x, y;
    private boolean inUse;
    private Image image;
    private HitBox hitBox;
    private int powerId;
    private GamePanel gamePanel;

    public boolean inUse() {
        return inUse;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public Buff(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        inUse = false;
        // image = new Image();
        hitBox = new HitBox(x, y, 0, 0, 30, 30);
    }

    public void active(int x, int y) {
        this.x = x;
        this.y = y;
        hitBox.update(this.x, this.y);
        inUse = true;
    }

    public void execute(int player_id) {

        if (player_id < 0)
            return;
        powerId = Tool.Random(1, 4);
        if (powerId == 1) {
            // tang toc
            gamePanel.getPlayerManager().getPlayer(player_id).setMovementSpeed(4.0);
        }
        if (powerId == 2) {
            gamePanel.getPlayerManager().getPlayer(player_id).setMovementSpeed(4.0);
        }
        if (powerId == 3) {
            gamePanel.getPlayerManager().getPlayer(player_id).setMovementSpeed(4.0);

        }
        if (powerId == 4) {
            gamePanel.getPlayerManager().getPlayer(player_id).setMovementSpeed(4.0);

        }
        delete();
    }

    public void delete() {
        inUse = false;
    }

    public void update() {
        if (inUse) {
            execute(gamePanel.getCollisionChecker().buffCheck(this));
        }
    }

    public void render(Graphics2D graphics2d) {
        if (inUse) {
            if (image == null) {
                graphics2d.fillRect(x, y, 30, 30);
            } else {
                graphics2d.drawImage(image.getImage(), x, y, image.getWidth(), image.getHeight(), null);
            }
            hitBox.render(graphics2d);
        }
    }

}
