package com.julien.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) { // flèche droite
            if (Main.scene.getxPos() == -1) { // Annule le décalage de 1
                Main.scene.setxPos(0);
                Main.scene.setxBackground_01(-50);
                Main.scene.setxBackground_02(750);
            }
            Main.scene.mario.setWalking(true);
            Main.scene.mario.setTurnToRight(true);
            Main.scene.setDx(1); // déplace le fond vers la gauche
        }
        else if (e.getKeyCode() == KeyEvent.VK_LEFT) { // flèche gauche
            Main.scene.mario.setWalking(true);
            Main.scene.mario.setTurnToRight(false);
            Main.scene.setDx(-1); // déplace le fond vers la droite
        }
        else if (e.getKeyCode() == KeyEvent.VK_SPACE) { // espace
            Main.scene.mario.setIsJumping(true);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        Main.scene.mario.setWalking(false);
        Main.scene.setDx(0);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // useless in this program but required by KeyListener
    }
}
