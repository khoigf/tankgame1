package GameComponents;

import GameComponents.Buff.Buff;
import GameComponents.Bullets.Bullet;
import GameComponents.Players.Player;

public class CollisionChecker {

    private GamePanel gamePanel;

    public CollisionChecker(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
    }

    public boolean objectCheck(Player player) {
        for (int i = 0; i < gamePanel.getMap().getObjectManager().MAX_OBJECT; ++i) {
            if (gamePanel.getMap().getObjectManager().getObjects()[i].inUse()) {
                if (player.getHitBox().isCollision(gamePanel.getMap().getObjectManager().getObjects()[i].getHitBox())) {
                    return true;
                }
            }
        }
        return false;
    }

//    public boolean bulletCheck(Bullet bullet) {
//        for (int i = 0; i < gamePanel.getMap().getObjectManager().MAX_OBJECT; ++i) {
//            if (gamePanel.getMap().getObjectManager().getObjects()[i].inUse()) {
//                if (bullet.getHitBox().isCollision(gamePanel.getMap().getObjectManager().getObjects()[i].getHitBox())) {
//                    bullet.delete();
//                    if (!(gamePanel.getMap().getObjectManager().getObjects()[i] instanceof Wall)) {
//                        gamePanel.getMap().getObjectManager().getObjects()[i].destroy();
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }

    public boolean bulletCheck(Bullet bullet) {
        for (int i = 0; i < gamePanel.getMap().getObjectManager().MAX_OBJECT; ++i) {
            if (gamePanel.getMap().getObjectManager().getObjects()[i].inUse()) {
                if (bullet.getHitBox().isCollision(gamePanel.getMap().getObjectManager().getObjects()[i].getHitBox())) {
                    bullet.delete();
                    gamePanel.getMap().getObjectManager().getObjects()[i].destroy();
                }
            }
        }
        return false;
    }

    public boolean tankCheck(Player player) {
        if (player.inUse() == false) return false;
        for(int i = 0; i < gamePanel.getBulletManager().MAX_BULLET; ++i) {
            if(gamePanel.getBulletManager().getBullets()[i].inUse()) {
                if(player.getHitBox().isCollision(gamePanel.getBulletManager().getBullets()[i].getHitBox())) {
                    if(player.getID() != gamePanel.getBulletManager().getBullets()[i].getOwnerID()) {
                        player.destroy();
                        gamePanel.getBulletManager().getBullets()[i].delete();
                    }
                }
            }
        }
        return false;
    }

    public int buffCheck(Buff buff) {
        for(Player player: gamePanel.getPlayerManager().getPlayer()) {
            if(player.inUse() == false) {
                continue;
            }
            if(buff.getHitBox().isCollision(player.getHitBox())) {
                return player.getID();
            }
        }
        return -1;
    }

    public boolean bulletCheckTitle(Bullet bullet){
        for (int i = 0; i< gamePanel.getTitleManager().numTitle ; i++){
            if (gamePanel.getTitleManager().getTitles()[i].getInUse()){
                if (bullet.getHitBox().isCollision(gamePanel.getTitleManager().getTitles()[i].getHitBox())){
                    bullet.delete();
                }
            }
        }
        return false;
    }

    public int tankCheckTitle(Player player){
        for (int i = 0; i< gamePanel.getTitleManager().numTitle; i++){
            if (gamePanel.getTitleManager().getTitles()[i].getInUse()){
                if (player.getHitBox().isCollision(gamePanel.getTitleManager().getTitles()[i].getHitBox())){
                    return i;
                }
            }
        }
        return -1;
    }

    public void update() {

    }
}
