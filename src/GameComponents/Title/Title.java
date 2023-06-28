package GameComponents.Title;

import java.awt.Color;
import java.awt.Graphics2D;

import GameComponents.GamePanel;
import Utilities.HitBox;

public class Title {
    public final int TANK_SIZE = 60;
    private GamePanel gamePanel;
    private int id;
    private double x, y, w, h;
    private int timeChange = 0, timeChange1 = 0;
    private HitBox hitBox;
    private boolean inUse = false;
    private boolean change = false;

    public boolean getChange(){
        return change;
    }

    public boolean getInUse(){
        return inUse;
    }

    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public double getW(){
        return w;
    }
    public double getH(){
        return h;
    }


    public int getID() {
        return id;
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public Title(GamePanel gamePanel, int id) {
        this.gamePanel = gamePanel;
        this.id = id;
    }

    public void create(int x, int y, int w, int h) {
        inUse = true;
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        hitBox = new HitBox(x, y, 0, 0, w, h);

    }

    public void update(){
        if (id % 4 == 0){
            if (timeChange < 100){
                timeChange++;
                y--;
                change = true;
                if (timeChange == 100) timeChange1 = 100;
            } else{
                timeChange1--;
                y++;
                change = false;
                if (timeChange1 == 0) timeChange = 0;

            }
        }

        if (id % 4 == 1){
            if (timeChange < 100){
                timeChange++;
                x++;
                change = true;
                if (timeChange == 100) timeChange1 = 100;
            } else{
                timeChange1--;
                x--;
                change = false;
                if (timeChange1 == 0) timeChange = 0;
            }
        }

        if (id % 4 == 2){
            if (timeChange < 100){
                timeChange++;
                y++;
                change = true;
                if (timeChange == 100) timeChange1 = 100;
            } else{
                timeChange1--;
                y--;
                change = false;
                if (timeChange1 == 0) timeChange = 0;
            }
        }

        if (id % 4 == 3){
            if (timeChange < 100){
                timeChange++;
                x--;
                change = true;
                if (timeChange == 100) timeChange1 = 100;
            } else{
                timeChange1--;
                x++;
                change = false;
                if (timeChange1 == 0) timeChange = 0;
            }
        }

        hitBox.update((int) x, (int) y);
    }

    public void render(Graphics2D graphics2d) {
        //System.out.println("render");
        graphics2d.setColor(Color.BLACK);
        graphics2d.fillRect((int)x, (int)y, (int) w, (int) h);
        //hitBox.render(graphics2d);
        
    }
}
