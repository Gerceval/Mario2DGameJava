package com.julien.game;

public class Chrono implements Runnable {

    public void run() {
        while(true) {
            Main.scene.repaint();
            try {
                int PAUSE = 3; // temps d'attente en ms entre 2 tours de boucle
                Thread.sleep(PAUSE);
            } catch (InterruptedException ignored) {}
        }
    }
}
