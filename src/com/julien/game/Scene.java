package com.julien.game;

import com.julien.character.Mario;
import com.julien.object.Block;
import com.julien.object.Coin;
import com.julien.object.Object;
import com.julien.object.RedPipe;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Scene extends JPanel {

    private final Image imgBackground_01;
    private final Image imgBackground_02;

    private final Image imgCastleStart;

    private final Image imgStart;

    private int xBackground_01;
    private int xBakcground_02;
    private int dx; // déplacement du fond d'écran
    private int xPos; // position absolue dans le jeu
    private int yBottom; // hauteur du sol
    private int topHeight; // hauteur du plafond;

    public Mario mario;

    public RedPipe redPipe_01;
    public RedPipe redPipe_02;
    public RedPipe redPipe_03;
    public RedPipe redPipe_04;
    public RedPipe redPipe_05;
    public RedPipe redPipe_06;
    public RedPipe redPipe_07;
    public RedPipe redPipe_08;

    public Block block_01;
    public Block block_02;
    public Block block_03;
    public Block block_04;
    public Block block_05;
    public Block block_06;
    public Block block_07;
    public Block block_08;
    public Block block_09;
    public Block block_10;
    public Block block_11;
    public Block block_12;

    public Coin coin_01;
    public Coin coin_02;
    public Coin coin_03;
    public Coin coin_04;
    public Coin coin_05;
    public Coin coin_06;
    public Coin coin_07;
    public Coin coin_08;
    public Coin coin_09;
    public Coin coin_10;

    private final Image imgCastleEnd;
    private final Image imgFlagEnd;

    private final ArrayList<Object> arrayObjects; // Tableau de tous les objets du jeu
    private final ArrayList<Coin> arrayCoins; // Tableau des "pièces en or" du jeux

    // CONSTRUCTOR
    public Scene() {
        super();

        this.xBackground_01 = -50;
        this.xBakcground_02 = 750;
        this.dx = 0;
        this.xPos = -1;
        this.yBottom = 293;
        this.topHeight = 0;

        ImageIcon icoBackground = new ImageIcon(getClass().getResource("/images/background.png"));
        imgBackground_01 = icoBackground.getImage();
        imgBackground_02 = icoBackground.getImage();

        ImageIcon icoCastleStart = new ImageIcon(getClass().getResource("/images/castle_01.png"));
        imgCastleStart = icoCastleStart.getImage();

        ImageIcon icoStart = new ImageIcon(getClass().getResource("/images/startPanel.png"));
        imgStart = icoStart.getImage();

        mario = new Mario(300, 245);

        redPipe_01 = new RedPipe(600, 230);
        redPipe_02 = new RedPipe(1000, 230);
        redPipe_03 = new RedPipe(1600, 230);
        redPipe_04 = new RedPipe(1900, 230);
        redPipe_05 = new RedPipe(2500, 230);
        redPipe_06 = new RedPipe(3000, 230);
        redPipe_07 = new RedPipe(3800, 230);
        redPipe_08 = new RedPipe(4500, 230);

        block_01 = new Block(400, 180);
        block_02 = new Block(1200, 180);
        block_03 = new Block(1270, 170);
        block_04 = new Block(1340, 160);
        block_05 = new Block(2000, 180);
        block_06 = new Block(2600, 160);
        block_07 = new Block(2650, 180);
        block_08 = new Block(3500, 160);
        block_09 = new Block(3550, 140);
        block_10 = new Block(4000, 170);
        block_11 = new Block(4200, 200);
        block_12 = new Block(4300, 210);

        coin_01 = new Coin(402, 145);
        coin_02 = new Coin(1002, 140);
        coin_03 = new Coin(1272, 95);
        coin_04 = new Coin(1342, 40);
        coin_05 = new Coin(1650, 145);
        coin_06 = new Coin(2650, 145);
        coin_07 = new Coin(3000, 135);
        coin_08 = new Coin(3400, 125);
        coin_09 = new Coin(4200, 145);
        coin_10 = new Coin(4600, 40);

        ImageIcon icoCastleEnd = new ImageIcon(getClass().getResource("/images/castleEnd.png"));
        imgCastleEnd = icoCastleEnd.getImage();

        ImageIcon icoFlagEnd = new ImageIcon(getClass().getResource("/images/flagEnd.png"));
        imgFlagEnd = icoFlagEnd.getImage();

        arrayObjects = new ArrayList<Object>();
        arrayCoins = new ArrayList<Coin>();

        arrayObjects.add(redPipe_01);
        arrayObjects.add(redPipe_02);
        arrayObjects.add(redPipe_03);
        arrayObjects.add(redPipe_04);
        arrayObjects.add(redPipe_05);
        arrayObjects.add(redPipe_06);
        arrayObjects.add(redPipe_07);
        arrayObjects.add(redPipe_08);

        arrayObjects.add(block_01);
        arrayObjects.add(block_02);
        arrayObjects.add(block_03);
        arrayObjects.add(block_04);
        arrayObjects.add(block_05);
        arrayObjects.add(block_06);
        arrayObjects.add(block_07);
        arrayObjects.add(block_08);
        arrayObjects.add(block_09);
        arrayObjects.add(block_10);
        arrayObjects.add(block_11);
        arrayObjects.add(block_12);

        arrayCoins.add(coin_01);
        arrayCoins.add(coin_02);
        arrayCoins.add(coin_03);
        arrayCoins.add(coin_04);
        arrayCoins.add(coin_05);
        arrayCoins.add(coin_06);
        arrayCoins.add(coin_07);
        arrayCoins.add(coin_08);
        arrayCoins.add(coin_09);
        arrayCoins.add(coin_10);

        this.setFocusable(true);
        this.requestFocusInWindow();
        this.addKeyListener(new Keyboard());

        Thread chronoScreen = new Thread(new Chrono());
        chronoScreen.start();
    }

    public void moveBackground() {

        if (xPos >= 0 && xPos <= 4430) {
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

        // Detection des collisions de Mario
        for (Object object : arrayObjects) { // Similaire à Array.forEach en JS
            if (this.mario.near(object)) {
                this.mario.collision(object);
            }
        }

        moveBackground();

        if (xPos >= 0 && xPos <= 4430) {
            for (Object object : arrayObjects) { // Similaire à Array.forEach en JS
                object.move();
            }
            for (Coin coin : arrayCoins) { // Similaire à Array.forEach en JS
                coin.move();
            }
        }

        // ((Graphics2D) g) = Cast de "Graphics g" en Graphics2D
        ((Graphics2D) g).drawImage(imgBackground_01, xBackground_01, 0, null); // Dessin de l'image de fond
        ((Graphics2D) g).drawImage(imgBackground_02, xBakcground_02, 0, null); // Dessin de l'image de fond
        ((Graphics2D) g).drawImage(imgCastleStart, 10 - xPos, 95, null);
        ((Graphics2D) g).drawImage(imgStart, 220 - xPos, 234, null);

        // Placement des objets
        for (Object object : arrayObjects) { // Similaire à Array.forEach en JS
            ((Graphics2D) g).drawImage(object.getImgObject(), object.getX(), object.getY(), null);
        }

        // Placement des "pièces en or"
        for (Coin coin : arrayCoins) { // Similaire à Array.forEach en JS
            ((Graphics2D) g).drawImage(coin.getImgObject(), coin.getX(), coin.getY(), null);
        }

        // Placement de Mario
        if (mario.getIsJumping()) {
            ((Graphics2D) g).drawImage(mario.jump(), mario.getX(), mario.getY(), null);
        } else {
            ((Graphics2D) g).drawImage(mario.walk("mario", 30), mario.getX(), mario.getY(), null);
        }

        ((Graphics2D) g).drawImage(imgFlagEnd, 4650 - xPos, 115, null);
        ((Graphics2D) g).drawImage(imgCastleEnd, 5000 - xPos, 145, null);
    }

    // GETTERS & SETTERS
    public int getDx() {
        return dx;
    }

    public int getxPos() {
        return xPos;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public void setxBackground_01(int i) {
        this.xBackground_01 = i;
    }

    public void setxBackground_02(int i) {
        this.xBakcground_02 = i;
    }

    public void setxPos(int i) {
        this.xPos = i;
    }

    public int getyBottom() {
        return yBottom;
    }

    public int getTopHeight() {
        return topHeight;
    }

    public void setyBottom(int yBottom) {
        this.yBottom = yBottom;
    }

    public void setTopHeight(int topHeight) {
        this.topHeight = topHeight;
    }
}
