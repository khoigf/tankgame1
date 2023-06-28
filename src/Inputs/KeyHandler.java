package Inputs;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GameComponents.GamePanel;

public class KeyHandler implements KeyListener{
    private GamePanel gamePanel;
    private long[] currentTime,previousTime;
    int []i;
    int []h;


    private boolean[] p;

    public boolean isOnePressed(int id) {
       return p[id];
    }

    public KeyHandler(GamePanel gamePanel) {
        this.gamePanel = gamePanel;
        i= new int[5]  ;
        p=new boolean[5];
        currentTime=new long[5];
        previousTime=new long[5];

        h= new int[5]  ;



    }

    @Override
    public void keyPressed(KeyEvent event) {
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_1) {
            currentTime[0]=System.currentTimeMillis();
            if(!checkDoublePress(0))
            {   if(i[0]==0)
                {
                    gamePanel.getPlayerManager().shoot(0);
                    i[0]=1;                }

                p[0] = true;
            } else {
                gamePanel.getPlayerManager().shoot(0);
            }
        }

        if(code == KeyEvent.VK_2) {

                currentTime[1] = System.currentTimeMillis();
                if (!checkDoublePress(1)) {
                    if (i[1] == 0) {
                        gamePanel.getPlayerManager().shoot(1);
                        i[1] = 1;
                    }

                    p[1] = true;
                } else {
                    gamePanel.getPlayerManager().shoot(1);
                }

        }

        if(code == KeyEvent.VK_3) {
            currentTime[2]=System.currentTimeMillis();
            if(!checkDoublePress(2))
            {   if(i[2]==0)
            {
                gamePanel.getPlayerManager().shoot(2);
                i[2]=1;                }

                p[2] = true;
            } else {
                gamePanel.getPlayerManager().shoot(2);
            }
        }

        if(code == KeyEvent.VK_4) {
            currentTime[3]=System.currentTimeMillis();
            if(!checkDoublePress(3))
            {   if(i[3]==0)
            {
                gamePanel.getPlayerManager().shoot(3);
                i[3]=1;                }

                p[3] = true;
            } else {
                gamePanel.getPlayerManager().shoot(3);
            }
        }

        if(code == KeyEvent.VK_5) {
            currentTime[4]=System.currentTimeMillis();
            if(!checkDoublePress(4))
            {   if(i[4]==0)
            {
                gamePanel.getPlayerManager().shoot(4);
                i[4]=1;                }

                p[4] = true;
            } else {
                gamePanel.getPlayerManager().shoot(4);
            }
        }

    }


    @Override
    public void keyReleased(KeyEvent event) {
        int code = event.getKeyCode();
        if(code == KeyEvent.VK_1) {
            p[0] = false;
            i[0]=0;
            previousTime[0]=System.currentTimeMillis();

        }

        if(code == KeyEvent.VK_2) {
            p[1] = false;
            i[1]=0;
            previousTime[1]=System.currentTimeMillis();

        }

        if(code == KeyEvent.VK_3) {
            p[2] = false;
            i[2]=0;
            previousTime[2]=System.currentTimeMillis();

        }

        if(code == KeyEvent.VK_4) {
            p[3] = false;
            i[3]=0;
            previousTime[3]=System.currentTimeMillis();

        }

        if(code == KeyEvent.VK_5) {
            p[4] = false;
            i[4]=0;
            previousTime[4]=System.currentTimeMillis();

        }
    }

    @Override
    public void keyTyped(KeyEvent event) {

    }
    public boolean checkDoublePress( int id) {
        if (currentTime[id] - previousTime[id] < 150 && 40 < currentTime[id] - previousTime[id]) {
            System.out.println(currentTime[id] + " - " + previousTime[id] + " = " + (currentTime[id] - previousTime[id]));
            previousTime = currentTime;
            return true;    
        }
        return false;
    }
    public boolean waitXTime(int id) {
        double x=System.currentTimeMillis();
        if (x - currentTime[id] > 200 ) {
            return true;
        }
        return false;
    }
}
