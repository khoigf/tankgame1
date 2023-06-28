package GameComponents.Objects;

import Utilities.Image;
import Utilities.Tool;

public class Tree2 extends Object {
    public Tree2(int x, int y) {
        super(x, y);
        image = new Image(Tool.getBufferedImage("../Assets/Images/Objects/tree2.png", 75, 80, 1));
    }
}
