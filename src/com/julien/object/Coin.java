package com.julien.object;
import javax.swing.*;
import java.awt.*;

public class Coin extends Object implements Runnable {

    private int count;
    private final int PAUSE = 15; // temps d'attente entre 2 tours de boucle (en ms)

    public Coin(int x, int y) {
        super(30, 30, x, y);

        super.icoObject = new ImageIcon(getClass().getResource("/images/coin_01.png"));
        super.imgObject = this.icoObject.getImage();
    }

    public Image flipCoin() {

        ImageIcon ico;
        Image img;
        String str;

        this.count++;

        if (this.count / 100 == 0) { str = "/images/coin_01.png"; }
        else { str = "/images/coin_02.png"; }

        if (this.count == 200) { this.count = 0; }

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    @Override
    public void run() {
        try { Thread.sleep(20); } // On attends 20 ms pour que tous les objets aient le temps de se créer
        catch(InterruptedException ignored) { }

        while(true) {
            this.flipCoin();
            try { Thread.sleep(this.PAUSE); }
            catch(InterruptedException ignored) { }
        }
    }
}