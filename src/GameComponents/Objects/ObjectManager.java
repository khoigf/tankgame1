package GameComponents.Objects;

import java.awt.Graphics2D;

public class ObjectManager {

    public final int MAX_OBJECT = 200;

    private Object[] objects = new Object[MAX_OBJECT];

    public Object[] getObjects() {
        return objects;
    }
    
    public ObjectManager() {
        for(int i = 0; i < MAX_OBJECT; ++i) {
            objects[i] = new Object();
        }
    }

    public void createObject(String type, int x, int y) {
        for(int i = 0; i < MAX_OBJECT; ++i) {
            if(objects[i].inUse() == false) {
                if(type == "Tree") {
                    objects[i] = new Tree(x, y);
                    break;
                }
                if(type == "Wall") {
                    objects[i] = new Wall(x, y);
                    break;
                }
                if(type == "Tree1") {
                    objects[i] = new Tree1(x, y);
                    break;
                }
                if(type == "Rock") {
                    objects[i] = new Rock(x, y);
                    break;
                }
                if(type == "Tree2") {
                    objects[i] = new Tree2(x, y);
                    break;
                }
            }
        }
    }

    public void update() {
        for(int i = 0; i < MAX_OBJECT; ++i) {
            objects[i].update();
        }
    }

    public void render(Graphics2D graphics2d) {
        for(int i = 0; i < MAX_OBJECT; ++i) {
            objects[i].render(graphics2d);
        }
    }
}
