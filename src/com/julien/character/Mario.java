package com.julien.character;

import javax.swing.*;
import java.awt.*;

public class Mario extends Character {

    private ImageIcon icoMario;
    private Image imgMario;

    // CONSTRUCTOR
    public Mario(int x, int y) {
        super(28, 50, x, y);

        icoMario = new ImageIcon(getClass().getResource("/images/marioWalkRight.png"));
        imgMario = icoMario.getImage();
    }

    // GETTERS
    public Image getImgMario() {
        return imgMario;
    }
}
