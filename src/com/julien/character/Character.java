package com.julien.character;

import com.julien.game.Main;
import com.julien.object.Object;

import javax.swing.*;
import java.awt.*;

public class Character {

    private int width, height; // dimensions
    private int x, y; // position
    private boolean isWalking;
    private boolean isTurnToRight; // est-il tourné vers la droite
    public int count; // compteur de pas

    // CONSTRUCTOR
    public Character(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.isWalking = false;
        this.isTurnToRight = true;
        this.count = 0;
    }

    // METHODS
    public Image walk(String name, int frequence) {

        String str;
        ImageIcon ico;
        Image img;

        if (!isWalking || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {
            if (isTurnToRight) {
                str = "/images/" + name + "StopRight.png";
            } else {
                str = "/images/" + name + "StopLeft.png";
            }
        } else {
            this.count++;
            if (this.count / frequence == 0) {
                if (isTurnToRight) {
                    str = "/images/" + name + "StopRight.png";
                } else {
                    str = "/images/" + name + "StopLeft.png";
                }
            } else {
                if (isTurnToRight) {
                    str = "/images/" + name + "WalkRight.png";
                } else {
                    str = "/images/" + name + "WalkLeft.png";
                }
            }
            if (this.count == (2 * frequence)) {
                this.count = 0;
            }
        }

        // Affichage de l'image du personnage
        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();

        return img;
    }

    // COLLISIONS
    // Détection contact à droite de Mario
    public boolean collisionFront(Object object) {
        if (this.x + this.width < object.getX() || this.x + this.width > object.getX() + 5 ||
                this.y + this.height <= object.getY() || this.y >= object.getY() + object.getHeight()) {
            return false;
        } else {
            return true;
        }
    }

    // Détection contact à gauche de Mario
    protected boolean collisionBack(Object object) {
        if (this.x > object.getX() + object.getWidth() || this.x + this.width < object.getX() + object.getWidth() - 5 ||
                this.y + this.height <= object.getY() || this.y >= object.getY() + object.getHeight()) {
            return false;
        } else {
            return true;
        }
    }

    // Détection contact en dessous de Mario
    protected boolean collisionBottom(Object object) {
        if (this.x + this.width < object.getX() + 5 || this.x > object.getX() + object.getWidth() - 5 ||
                this.y + this.height < object.getY() || this.y + this.height > object.getY() + 5) {
            return false;
        } else {
            return true;
        }
    }

    // Détection contact au-dessus de Mario
    protected boolean collisionTop(Object object) {
        if (this.x + this.width < object.getX() + 5 || this.x > object.getX() + object.getWidth() - 5 ||
                this.y < object.getY() + object.getHeight() || this.y > object.getY() + object.getHeight() + 5) {
            return false;
        } else {
            return true;
        }
    }

    public boolean near(Object object) {
        if ((this.x > object.getX() - 10 && this.x < object.getX() + object.getWidth() + 10)
                || (this.x + this.width > object.getX() - 10 && this.x + this.width < object.getX() + object.getWidth() + 10)) {
            return true;
        } else {
            return false;
        }
    }

    // GETTERS
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean getIsWalking() {
        return isWalking;
    }

    public boolean getIsTurnToRight() {
        return isTurnToRight;
    }

    public int getCount() {
        return count;
    }

    // SETTERS
    public void setHeight(int height) {
        this.height = height;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWalking(boolean walking) {
        isWalking = walking;
    }

    public void setTurnToRight(boolean turnToRight) {
        isTurnToRight = turnToRight;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
