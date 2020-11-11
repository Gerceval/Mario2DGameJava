package com.julien.character;

import com.julien.object.Object;

import javax.swing.*;
import java.awt.*;

public class Koopa extends Character implements Runnable {

    private final Image imgKoopa;

    private int dxKoopa;

    public Koopa(int x, int y) {
        super(43, 50, x, y);
        super.setTurnToRight(true);
        super.setWalking(true);

        ImageIcon icoKoopa = new ImageIcon(getClass().getResource("/images/koopa/koopaStopLeft.png"));
        this.imgKoopa = icoKoopa.getImage();

        this.dxKoopa = 1;

        Thread chronoGoomba = new Thread(this);
        chronoGoomba.start();
    }

    public void walk() {
        if (super.getIsTurnToRight()) { this.dxKoopa = 1; }
        else { this.dxKoopa = -1; }

        super.setX(super.getX() + this.dxKoopa);
    }

    public void collision(Object object) {
        if (super.collisionFront(object) && this.getIsTurnToRight()) {
            super.setTurnToRight(false);
            this.dxKoopa = -1;
        }
        else if (super.collisionBack(object) && !this.getIsTurnToRight()) {
            super.setTurnToRight(true);
            this.dxKoopa = 1;
        }
    }

    public void collision(Character character) {
        if (super.collisionFront(character) && this.getIsTurnToRight()) {
            super.setTurnToRight(false);
            this.dxKoopa = -1;
        }
        else if (super.collisionBack(character) && !this.getIsTurnToRight()) {
            super.setTurnToRight(true);
            this.dxKoopa = 1;
        }
    }

    public Image dies() {
        ImageIcon ico;
        Image img;
        String str;

        str = "/images/koopa/koopaLocked.png";

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    @Override
    public void run() {
        try { Thread.sleep(20); }
        catch(InterruptedException ignored) { }
        while (true) {
            if (this.isAlive) {
                this.walk();
                try {
                    int PAUSE = 15;
                    Thread.sleep(PAUSE); }
                catch(InterruptedException ignored) { }
            }
        }
    }

    // GETTERS & SETTERS
    public Image getImgKoopa() {
        return imgKoopa;
    }
}
