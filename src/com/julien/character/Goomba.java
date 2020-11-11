package com.julien.character;

import com.julien.object.Object;

import javax.swing.*;
import java.awt.*;

public class Goomba extends Character implements Runnable {

    private final Image imgGoomba;

    private final int PAUSE = 15;
    private int dxGoomba;

    public Goomba(int x, int y) {
        super(27, 30, x, y);
        super.setTurnToRight(true);
        super.setWalking(true);

        ImageIcon icoGoomba = new ImageIcon(getClass().getResource("/images/goomba/goombaStopRight.png"));
        this.imgGoomba = icoGoomba.getImage();

        this.dxGoomba = 1;

        Thread chronoGoomba = new Thread(this);
        chronoGoomba.start();
    }

    public void walk() {
        if (super.getIsTurnToRight()) { this.dxGoomba = 1; }
        else { this.dxGoomba = -1; }

        super.setX(super.getX() + this.dxGoomba);
    }

    public void collision(Object object) {
        if (super.collisionFront(object) && this.getIsTurnToRight()) {
            super.setTurnToRight(false);
            this.dxGoomba = -1;
        }
        else if (super.collisionBack(object) && !this.getIsTurnToRight()) {
            super.setTurnToRight(true);
            this.dxGoomba = 1;
        }
    }

    public void collision(Character character) {
        if (super.collisionFront(character) && this.getIsTurnToRight()) {
            super.setTurnToRight(false);
            this.dxGoomba = -1;
        }
        else if (super.collisionBack(character) && !this.getIsTurnToRight()) {
            super.setTurnToRight(true);
            this.dxGoomba = 1;
        }
    }

    public Image dies() {
        ImageIcon ico;
        Image img;
        String str;

        if (this.isTurnToRight) { str = "/images/goomba/goombaCrushedRight.png"; }
        else { str = "/images/goomba/goombaCrushedLeft.png"; }

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
                 try { Thread.sleep(this.PAUSE); }
                 catch(InterruptedException ignored) { }
             }
         }
    }

    // GETTERS & SETTERS
    public Image getImgGoomba() {
        return imgGoomba;
    }
}
