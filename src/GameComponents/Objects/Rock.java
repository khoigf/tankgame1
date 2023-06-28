package GameComponents.Objects;

import Utilities.Image;
import Utilities.Tool;

public class Rock extends Object {
    public Rock(int x, int y) {
        super(x, y);
        image = new Image(Tool.getBufferedImage("../Assets/Images/Objects/rock1.png", 64, 64, 1));
    }
}
