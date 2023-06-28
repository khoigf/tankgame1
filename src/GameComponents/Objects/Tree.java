package GameComponents.Objects;

import Utilities.Image;
import Utilities.Tool;

public class Tree extends Object{
    public Tree(int x, int y) {
        super(x, y);
        image = new Image(Tool.getBufferedImage("../Assets/Images/Objects/tree06.png", 64, 64, 1));
    }
}


