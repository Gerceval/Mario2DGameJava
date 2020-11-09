package com.julien.object;
import javax.swing.*;

public class Block extends Object {

    public Block(int x, int y) {
        super(30, 30, x, y);

        super.icoObject = new ImageIcon(getClass().getResource("/images/block.png"));
        super.imgObject = this.icoObject.getImage();
    }
}
