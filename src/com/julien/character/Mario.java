package com.julien.character;

import com.julien.game.Main;
import com.julien.object.Coin;
import com.julien.object.Object;

import javax.swing.*;
import java.awt.*;

public class Mario extends Character {

    private final Image imgMario;
    private boolean isJumping;
    private int jumpCount; // durée et hauteur du saut

    // CONSTRUCTOR
    public Mario(int x, int y) {
        super(28, 50, x, y);

        ImageIcon icoMario = new ImageIcon(getClass().getResource("/images/marioWalkRight.png"));
        imgMario = icoMario.getImage();
        this.isJumping = false;
        this.jumpCount = 0;
    }

    public Image jump() {

        ImageIcon ico;
        Image img;
        String imagePath;

        jumpCount++;

        // Montée du saut
        if (jumpCount <= 40) {
            if (this.getY() > Main.scene.getTopHeight()) {
                this.setY(this.getY() - 4); // Mario monte de 4 pixels
            } else {
                jumpCount = 41;
            }
            if (this.getIsTurnToRight()) {
                imagePath = "/images/marioJumpRight.png";
            } else {
                imagePath = "/images/marioJumpLeft.png";
            }
        }
        // Retombée du saut
        else if (this.getY() + this.getHeight() < Main.scene.getyBottom()) {
            this.setY(this.getY() + 1); // Mario descend de 1 pixel
            if (this.getIsTurnToRight()) {
                imagePath = "/images/marioJumpRight.png";
            } else {
                imagePath = "/images/marioJumpLeft.png";
            }
        }
        // Saut terminé
        else {
            if (this.getIsTurnToRight()) {
                imagePath = "/images/marioStopRight.png";
            } else {
                imagePath = "/images/marioStopLeft.png";
            }
            this.isJumping = false;
            this.jumpCount = 0;
        }

        ico = new ImageIcon(getClass().getResource(imagePath));
        img = ico.getImage();
        return img;
    }

    public void collision(Object object) {
        // contact horizontal
        if ((super.collisionFront(object) && this.getIsTurnToRight()) || (super.collisionBack(object) && !this.getIsTurnToRight())) {
            Main.scene.setDx(0);
            this.setWalking(false);
        }
        // contact avec un objet en dessous
        if (super.collisionBottom(object) && this.isJumping) { // Mario saute sur un objet
            Main.scene.setyBottom(object.getY());
        } else if (!super.collisionBottom(object)) { // Mario tombe sur le sol initial
            Main.scene.setyBottom(293); // altitude du sol initial
            if (!this.isJumping) {
                this.setY(243); // altitude initiale de Mario
            }
        }
        if (super.collisionTop(object)) { // contact avec un objet au-dessus
            Main.scene.setTopHeight(object.getY() + object.getHeight()); // le plafond devient le dessous de l'objet
        } else if (!super.collisionBottom(object) && !this.isJumping) {
            Main.scene.setTopHeight(0); // altitude du plafond initial (ciel)
        }
    }

    public boolean collisionCoin(Coin coin) {
        return super.collisionBack(coin) || super.collisionFront(coin) || super.collisionBottom(coin) || super.collisionTop(coin);
    }

    // GETTERS & SETTERS
    public Image getImgMario() {
        return imgMario;
    }

    public boolean getIsJumping() {
        return isJumping;
    }

    public void setIsJumping(boolean jumping) {
        isJumping = jumping;
    }
}
