package GameComponents.Objects;

import Utilities.Image;
import Utilities.Tool;

public class Wall extends Object {
    public Wall(int x, int y) {
        super(x, y);
        image = new Image(Tool.getBufferedImage("../Assets/Images/Objects/wall.png", 64, 64, 1));
    }
}
