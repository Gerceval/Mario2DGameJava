package com.julien.character;

import com.julien.game.Main;

import javax.swing.*;
import java.awt.*;

public class Mario extends Character {

    private ImageIcon icoMario;
    private Image imgMario;
    private boolean isJumping;
    private int jumpCount; // durée et hauteur du saut

    // CONSTRUCTOR
    public Mario(int x, int y) {
        super(28, 50, x, y);

        icoMario = new ImageIcon(getClass().getResource("/images/marioWalkRight.png"));
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
        if (jumpCount <= 35) {
            if (this.getY() > Main.scene.getTopHeight()) {
                this.setY(this.getY() - 4); // Mario monte de 4 pixels
            }
            else {
                jumpCount = 36;
            }
            if (this.getIsTurnToRight()) { imagePath = "/images/marioJumpRight.png"; }
            else { imagePath = "/images/marioJumpLeft.png"; }
        }
        // Retombée du saut
        else if (this.getY() + this.getHeight() < Main.scene.getyBottom()) {
            this.setY(this.getY() + 1); // Mario descend de 1 pixel
            if (this.getIsTurnToRight()) { imagePath = "/images/marioJumpRight.png"; }
            else { imagePath = "/images/marioJumpLeft.png"; }
        }
        // Saut terminé
        else {
            if (this.getIsTurnToRight()) { imagePath = "/images/marioStopRight.png"; }
            else { imagePath = "/images/marioStopLeft.png"; }
            this.isJumping = false;
            this.jumpCount = 0;
        }

        ico = new ImageIcon(getClass().getResource(imagePath));
        img = ico.getImage();
        return img;
    }

    // GETTERS & SETTERS
    public Image getImgMario() {
        return imgMario;
    }

    public boolean getIsJumping() { return isJumping; }

    public void setIsJumping(boolean jumping) { isJumping = jumping; }
}
