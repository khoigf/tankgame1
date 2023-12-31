package TankGame;

import javax.swing.JFrame;

import GameComponents.GamePanel;

public class    TankGame {
    public static void main(String[] args) throws Exception {

        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Tank");
        GamePanel gamePanel = new GamePanel();

        window.add(gamePanel);
        window.pack();
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        gamePanel.start();
    }   
}
