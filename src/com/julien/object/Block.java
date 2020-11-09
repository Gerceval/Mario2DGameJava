package com.julien.object;

import javax.swing.*;
import java.awt.*;

public class Block extends Object {

    private Image imgBlock;
    private ImageIcon icoBlock;

    public Block(int x, int y) {
        super(30, 30, x, y);

        this.icoBlock = new ImageIcon(getClass().getResource("/images/block.png"));
        this.imgBlock = this.icoBlock.getImage();
    }

    public Image getImgBlock() {
        return imgBlock;
    }
}
