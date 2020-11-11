package com.julien.game;

import com.julien.character.Goomba;
import com.julien.character.Koopa;
import com.julien.character.Mario;
import com.julien.display.Countdown;
import com.julien.display.Score;
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

    public Goomba goomba_01;
    public Goomba goomba_02;
    public Goomba goomba_03;
    public Goomba goomba_04;
    public Goomba goomba_05;
    public Goomba goomba_06;
    public Goomba goomba_07;
    public Goomba goomba_08;

    public Koopa koopa_01;
    public Koopa koopa_02;
    public Koopa koopa_03;
    public Koopa koopa_04;
    public Koopa koopa_05;
    public Koopa koopa_06;
    public Koopa koopa_07;
    public Koopa koopa_08;
    public Koopa koopa_09;

    private final Image imgCastleEnd;
    private final Image imgFlagEnd;

    private final ArrayList<Object> arrayObjects; // Tableau de tous les objets du jeu
    private final ArrayList<Coin> arrayCoins; // Tableau des "pièces en or" du jeux
    private final ArrayList<Goomba> arrrayGoomba; // Tableau des Goombas
    private final ArrayList<Koopa> arrayKoopa; // Tableau des Koopas

    private Score score;
    private Font font;

    private Countdown countdown;

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

        ImageIcon icoCastleStart = new ImageIcon(getClass().getResource("/images/objects/castle_01.png"));
        imgCastleStart = icoCastleStart.getImage();

        ImageIcon icoStart = new ImageIcon(getClass().getResource("/images/objects/startPanel.png"));
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

        goomba_01 = new Goomba(800, 263);
        goomba_02 = new Goomba(1100, 263);
        goomba_03 = new Goomba(2100, 263);
        goomba_04 = new Goomba(2400, 263);
        goomba_05 = new Goomba(3200, 263);
        goomba_06 = new Goomba(3500, 263);
        goomba_07 = new Goomba(3700, 263);
        goomba_08 = new Goomba(4500, 263);

        koopa_01 = new Koopa(950, 243);
        koopa_02 = new Koopa(1500, 243);
        koopa_03 = new Koopa(1800, 243);
        koopa_04 = new Koopa(2400, 243);
        koopa_05 = new Koopa(3100, 243);
        koopa_06 = new Koopa(3600, 243);
        koopa_07 = new Koopa(3900, 243);
        koopa_08 = new Koopa(4200, 243);
        koopa_09 = new Koopa(4400, 243);

        ImageIcon icoCastleEnd = new ImageIcon(getClass().getResource("/images/objects/castleEnd.png"));
        imgCastleEnd = icoCastleEnd.getImage();

        ImageIcon icoFlagEnd = new ImageIcon(getClass().getResource("/images/objects/flagEnd.png"));
        imgFlagEnd = icoFlagEnd.getImage();

        arrayObjects = new ArrayList<Object>();
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

        arrayCoins = new ArrayList<Coin>();
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

        arrrayGoomba = new ArrayList<Goomba>();
        arrrayGoomba.add(goomba_01);
        arrrayGoomba.add(goomba_02);
        arrrayGoomba.add(goomba_03);
        arrrayGoomba.add(goomba_04);
        arrrayGoomba.add(goomba_05);
        arrrayGoomba.add(goomba_06);
        arrrayGoomba.add(goomba_07);
        arrrayGoomba.add(goomba_08);

        arrayKoopa = new ArrayList<Koopa>();
        arrayKoopa.add(koopa_01);
        arrayKoopa.add(koopa_02);
        arrayKoopa.add(koopa_03);
        arrayKoopa.add(koopa_04);
        arrayKoopa.add(koopa_05);
        arrayKoopa.add(koopa_06);
        arrayKoopa.add(koopa_07);
        arrayKoopa.add(koopa_08);
        arrayKoopa.add(koopa_09);

        score = new Score();
        font = new Font("Arial", Font.PLAIN, 18);

        countdown = new Countdown();

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

    public boolean win() {
        return countdown.getTimeCount() > 0 && mario.isAlive() && score.getNbrCoins() == score.getTotalCoins() && xPos > 4400;
    }

    public boolean loose() {
        return !mario.isAlive() || countdown.getTimeCount() <= 0;
    }

    public boolean endGame() {
        return win() || loose();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Detection des collisions avec les objets proches
        for (Object object : arrayObjects) { // Similaire à Array.forEach en JS
            // Mario
            if (this.mario.near(object)) { this.mario.collision(object); }
            // Goombas
            for (Goomba goomba : arrrayGoomba) {
                if (goomba.near(object)) { goomba.collision(object); }
            }
            // Koopas
            for (Koopa koopa : arrayKoopa) {
                if (koopa.near(object)) { koopa.collision(object); }
            }
        }

        // Detection des collisions de Mario avec les "pièces en or"
        for (Coin coin : arrayCoins) {
            if (this.mario.near(coin)) {
                if (this.mario.collisionCoin(coin)) {
                    arrayCoins.remove(coin);
                    score.setNbrCoins(score.getNbrCoins() + 1);
                }
            }
        }

        // Détection des collisions des goombas avec les autres personnages (hors Mario)
        for (Goomba goomba : arrrayGoomba) {
            // contacts avec d'autres goombas
            for (Goomba otherGoomba : arrrayGoomba) {
                if (goomba != otherGoomba) {
                    if (goomba.near(otherGoomba)) { goomba.collision(otherGoomba); }
                }
            }
            // contacts avec les koopas
            for (Koopa koopa : arrayKoopa) {
                if (koopa.near(goomba)) { goomba.collision(koopa); }
            }
        }

        // Détection des collisions des koopas avec les autres personnages (hors Mario)
        for (Koopa koopa : arrayKoopa) {
            // contacts avec d'autres koopas
            for (Koopa otherKoopa : arrayKoopa) {
                if (koopa != otherKoopa) {
                    if (koopa.near(otherKoopa)) { koopa.collision(koopa); }
                }
            }
            // contacts avec les goombas
            for (Goomba goomba : arrrayGoomba) {
                if (koopa.near(goomba)) { koopa.collision(goomba); }
            }
        }

        // Détection des collisions de Mario avec les autres personnages
        for (Goomba goomba : arrrayGoomba) {
            if (mario.near(goomba) && goomba.isAlive()) { mario.collision(goomba); }
        }
        for (Koopa koopa : arrayKoopa) {
            if (mario.near(koopa) && koopa.isAlive()) { mario.collision(koopa); }
        }

        moveBackground();

        // Déplacement de tous les objets "fixes" du jeu
        if (xPos >= 0 && xPos <= 4430) {
            for (Object object : arrayObjects) { // Similaire à Array.forEach en JS
                object.move();
            }
            for (Coin coin : arrayCoins) {
                coin.move();
            }
            for (Goomba goomba : arrrayGoomba) {
                goomba.move();
            }
            for (Koopa koopa : arrayKoopa) {
                koopa.move();
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
            ((Graphics2D) g).drawImage(coin.flipCoin(), coin.getX(), coin.getY(), null);
        }

        // Placement de Mario
        if (mario.isAlive()) {
            if (mario.getIsJumping()) {
                ((Graphics2D) g).drawImage(mario.jump(), mario.getX(), mario.getY(), null);
            } else {
                ((Graphics2D) g).drawImage(mario.walk("mario", 30), mario.getX(), mario.getY(), null);
            }
        }
        else {
            ((Graphics2D) g).drawImage(mario.dies(), mario.getX(), mario.getY(), null);
        }


        // Placement des goombas
        for (Goomba goomba : arrrayGoomba) {
            if (goomba.isAlive()) {
                ((Graphics2D) g).drawImage(goomba.walk("goomba", 45), goomba.getX(), goomba.getY(), null);
            }
            else {
                ((Graphics2D) g).drawImage(goomba.dies(), goomba.getX(), goomba.getY() + 20, null);
            }
        }

        // Placement des koopas
        for (Koopa koopa : arrayKoopa) {
            if (koopa.isAlive()) {
                ((Graphics2D) g).drawImage(koopa.walk("koopa", 45), koopa.getX(), koopa.getY(), null);
            }
            else {
                ((Graphics2D) g).drawImage(koopa.dies(), koopa.getX(), koopa.getY() + 30, null);
            }
        }

        ((Graphics2D) g).drawImage(imgFlagEnd, 4650 - xPos, 115, null);
        ((Graphics2D) g).drawImage(imgCastleEnd, 5000 - xPos, 145, null);

        // Affichage et màj du Score
        ((Graphics2D) g).setFont(font);
        ((Graphics2D) g).drawString(score.getNbrCoins() + " / " + score.getTotalCoins() + " coins", 580, 25);

        // Affichage du compte à rebours
        ((Graphics2D) g).drawString(countdown.getStr(), 5, 25);

        // Fin de la partie
        if (endGame()) {
            Font endFont = new Font("Arial", Font.BOLD, 50);
            ((Graphics2D) g).setFont(endFont);
            if (win()) {
                ((Graphics2D) g).drawString("Gagné !", 120, 180);
            }
            else {
                ((Graphics2D) g).drawString("Perdu ! T'es nul mon gars !", 20, 180);
            }
        }
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
