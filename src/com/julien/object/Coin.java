package com.julien.object;
import javax.swing.*;

public class Coin extends Object {

    public Coin(int x, int y) {
        super(30, 30, x, y);

        super.icoObject = new ImageIcon(getClass().getResource("/images/coin_01.png"));
        super.imgObject = this.icoObject.getImage();
    }
}
