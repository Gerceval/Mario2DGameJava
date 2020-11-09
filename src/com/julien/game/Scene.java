package com.julien.game;

import com.julien.character.Mario;
import com.julien.object.Block;
import com.julien.object.RedPipe;

import javax.swing.*;
import java.awt.*;

public class Scene extends JPanel {

    private ImageIcon icoBackground;
    private Image imgBackground_01;
    private Image imgBackground_02;

    private ImageIcon icoCastle_1;
    private Image imgCastle_1;

    private ImageIcon icoStart;
    private Image imgStart;

    private int xBackground_01;
    private int xBakcground_02;
    private int dx;
    private int xPos;

    public Mario mario;
    public RedPipe redPipe_01;
    public Block block_01;

    // CONSTRUCTOR
    public Scene() {
        super();

        this.xBackground_01 = -50;
        this.xBakcground_02 = 750;
        this.dx = 0;
        this.xPos = -1;

        icoBackground = new ImageIcon(getClass().getResource("/images/background.png"));
        imgBackground_01 = icoBackground.getImage();
        imgBackground_02 = icoBackground.getImage();

        icoCastle_1 = new ImageIcon(getClass().getResource("/images/castle_01.png"));
        imgCastle_1 = icoCastle_1.getImage();

        icoStart = new ImageIcon(getClass().getResource("/images/startPanel.png"));
        imgStart = icoStart.getImage();

        mario = new Mario(300, 245);
        redPipe_01 = new RedPipe(600, 230);
        block_01 = new Block(400, 180);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        Thread chronoScreen = new Thread(new Chrono());
        chronoScreen.start();
    }

    // GETTERS
    public int getDx() {
        return dx;
    }

    public int getxPos() {
        return xPos;
    }

    // SETTERS
    public int setDx(int dx) {
        return this.dx = dx;
    }

    public int setxBackground_01(int i) {
        return this.xBackground_01 = i;
    }

    public int setxBackground_02(int i) {
        return this.xBakcground_02 = i;
    }

    public int setxPos(int i) {
        return this.xPos = i;
    }

    public void moveBackground() {

        if (xPos >= 0) {
            xPos = xPos + dx;
            this.xBackground_01 = this.xBackground_01 - this.dx;
            this.xBakcground_02 = this.xBakcground_02 - this.dx;
        }

        if (this.xBackground_01 == -800) {
            this.xBackground_01 = 800;
        } else if (this.xBakcground_02 == -800) {
            this.xBakcground_02 = 800;
        } else if (this.xBackground_01 == 800) {
            this.xBackground_01 = -800;
        } else if (this.xBakcground_02 == 800) {
            this.xBakcground_02 = -800;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics g2 = (Graphics2D) g;

        this.moveBackground();

        g2.drawImage(imgBackground_01, xBackground_01, 0, null); // Dessin de l'image de fond
        g2.drawImage(imgBackground_02, xBakcground_02, 0, null); // Dessin de l'image de fond
        g2.drawImage(mario.walk("mario", 30), 300, 245, null);
        g2.drawImage(imgCastle_1, 10 - xPos, 95, null);
        g2.drawImage(imgStart, 220 - xPos, 234, null);
        g2.drawImage(redPipe_01.getImgRedPipe(), redPipe_01.getX() - xPos, redPipe_01.getY(), null);
        g2.drawImage(block_01.getImgBlock(), block_01.getX() - xPos, block_01.getY(), null);
    }
}
