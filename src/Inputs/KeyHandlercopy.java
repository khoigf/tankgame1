//package Inputs;
//
//import java.awt.event.KeyEvent;
//import java.awt.event.KeyListener;
//
//import GameComponents.GamePanel;
//
//public class KeyHandler implements KeyListener{
//    private GamePanel gamePanel;
//
//    private boolean p0, p1, p2, p3, p4;
//
//    public boolean isPressed(int id) {
//        if(id == 0) return p0;
//        if(id == 1) return p1;
//        if(id == 2) return p2;
//        if(id == 3) return p3;
//        if(id == 4) return p4;
//
//        return false;
//    }
//
//    public KeyHandler(GamePanel gamePanel) {
//        this.gamePanel = gamePanel;
//    }
//
//    @Override
//    public void keyPressed(KeyEvent event) {
//        int code = event.getKeyCode();
//
//        if(code == KeyEvent.VK_1) {
//            p0 = true;
//        }
//
//        if(code == KeyEvent.VK_2) {
//            p1 = true;
//        }
//
//        if(code == KeyEvent.VK_3) {
//            p2 = true;
//        }
//
//        if(code == KeyEvent.VK_4) {
//            p3 = true;
//        }
//
//        if(code == KeyEvent.VK_5) {
//            p4 = true;
//        }
//
//        if(code == KeyEvent.VK_SPACE) {
//            gamePanel.getPlayerManager().shoot(0);
//        }
//    }
//
//    @Override
//    public void keyReleased(KeyEvent event) {
//        int code = event.getKeyCode();
//
//        if(code == KeyEvent.VK_1) {
//            p0 = false;
//        }
//
//        if(code == KeyEvent.VK_2) {
//            p1 = false;
//        }
//
//        if(code == KeyEvent.VK_3) {
//            p2 = false;
//        }
//
//        if(code == KeyEvent.VK_4) {
//            p3 = false;
//        }
//
//        if(code == KeyEvent.VK_5) {
//            p4 = false;
//        }
//    }
//
//    @Override
//    public void keyTyped(KeyEvent event) {
//
//    }
//
//}
