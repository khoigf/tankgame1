package GameComponents.Objects;

import Utilities.Image;
import Utilities.Tool;

public class Tree1 extends Object{
    public Tree1(int x, int y) {
        super(x, y);
        image = new Image(Tool.getBufferedImage("../Assets/Images/Objects/tree1.png", 70, 70, 1));
    }
}