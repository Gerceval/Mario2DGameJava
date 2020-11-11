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
    private int deadCount;

    // CONSTRUCTOR
    public Mario(int x, int y) {
        super(28, 50, x, y);

        ImageIcon icoMario = new ImageIcon(getClass().getResource("/images/mario/marioWalkRight.png"));
        imgMario = icoMario.getImage();

        this.isJumping = false;
        this.jumpCount = 0;
        this.deadCount = 0;
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
                imagePath = "/images/mario/marioJumpRight.png";
            } else {
                imagePath = "/images/mario/marioJumpLeft.png";
            }
        }
        // Retombée du saut
        else if (this.getY() + this.getHeight() < Main.scene.getyBottom()) {
            this.setY(this.getY() + 1); // Mario descend de 1 pixel
            if (this.getIsTurnToRight()) {
                imagePath = "/images/mario/marioJumpRight.png";
            } else {
                imagePath = "/images/mario/marioJumpLeft.png";
            }
        }
        // Saut terminé
        else {
            if (this.getIsTurnToRight()) {
                imagePath = "/images/mario/marioStopRight.png";
            } else {
                imagePath = "/images/mario/marioStopLeft.png";
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

    public void collision(Character character) {
        if (character.isAlive) {
            if (super.collisionFront(character) || super.collisionBack(character)) {
                this.setWalking(false);
                this.setAlive(false);
            } else if (super.collisionBottom(character)) {
                character.setWalking(false);
                character.setAlive(false);
            }
        }
    }

    public Image dies() {
        ImageIcon ico;
        Image img;
        String str;

        str = "/images/boom.png";
        deadCount++;

        if (deadCount > 100) {
            str = "/images/mario/marioDie.png";
            setY(getY() - 1);
        }

        ico = new ImageIcon(getClass().getResource(str));
        img = ico.getImage();
        return img;
    }

    @Override // On override pour modifier le premier "if" qui doit prendre en compte le fait que mario soit tout à gauche ou à droite de l'écran pour s'arrêter de marcher
    public Image walk(String name, int frequence) {
        String str;
        ImageIcon ico;
        Image img;

        if (!isWalking || Main.scene.getxPos() <= 0 || Main.scene.getxPos() > 4430) {
            if (isTurnToRight) {
                str = "/images/" + name + "/" + name + "StopRight.png";
            } else {
                str = "/images/" + name + "/" + name + "StopLeft.png";
            }
        } else {
            this.count = this.count + 1;
            if (this.count / frequence == 0) {
                if (isTurnToRight) {
                    str = "/images/" + name + "/" + name + "StopRight.png";
                } else {
                    str = "/images/" + name + "/" + name + "StopLeft.png";
                }
            } else {
                if (isTurnToRight) {
                    str = "/images/" + name + "/" + name + "WalkRight.png";
                } else {
                    str = "/images/" + name + "/" + name + "WalkLeft.png";
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
