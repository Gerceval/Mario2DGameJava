package com.julien.object;

import com.julien.game.Main;

import javax.swing.*;
import java.awt.*;

public class Object {

    private int width, height; // dimensions
    private int x, y; // position

    protected Image imgObject;
    protected ImageIcon icoObject;

    public Object(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }

    public void move() {
        if (Main.scene.getxPos() >= 0) {
            this.x = this.x - Main.scene.getDx();
        }
    }

    // GETTERS & SETTERS
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Image getImgObject() { return this.imgObject; }
}
