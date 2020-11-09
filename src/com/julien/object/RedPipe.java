package com.julien.object;
import javax.swing.*;
import java.awt.*;

public class RedPipe extends Object {

    private Image imgRedPipe;
    private ImageIcon icoRedPipe;

    public RedPipe(int x, int y) {
        super(43, 65, x, y);

        this.icoRedPipe = new ImageIcon(getClass().getResource("/images/redPipe.png"));
        this.imgRedPipe = this.icoRedPipe.getImage();
    }

    public Image getImgRedPipe() {
        return imgRedPipe;
    }
}
