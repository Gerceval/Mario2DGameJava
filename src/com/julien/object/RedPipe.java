package com.julien.object;
import javax.swing.*;

public class RedPipe extends Object {

    public RedPipe(int x, int y) {
        super(43, 65, x, y);

        super.icoObject = new ImageIcon(getClass().getResource("/images/redPipe.png"));
        super.imgObject = this.icoObject.getImage();
    }
}
