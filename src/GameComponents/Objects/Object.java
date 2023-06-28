package GameComponents.Objects;

import java.awt.Graphics2D;

import Utilities.HitBox;
import Utilities.Image;

public class  Object {

    protected int x, y;
    protected HitBox hitBox;
    protected Image image;
    protected int cd;
    protected boolean inUse;

    public boolean inUse() {
        if(cd != 0) return false;
        return inUse;
    }

    public Object() {
        inUse = false;
    }

    public Object(int x, int y) {
        inUse = true;
        this.x = x;
        this.y = y;
        hitBox = new HitBox(x, y, 7, 7, 50, 50);
    }

    public HitBox getHitBox() {
        return hitBox;
    }

    public void update() {
        if (inUse) {
            cd = cd - 1;
            if (cd < 0)
                cd = 0;
        }
    }

    public void destroy() {
        cd = 600;
    }

    public void render(Graphics2D graphics2d) {
        if (inUse) {
            if (cd == 0) {
                graphics2d.drawImage(image.getImage(), x, y, image.getWidth(), image.getHeight(), null);
                hitBox.render(graphics2d);
            }
        }
    }
}
