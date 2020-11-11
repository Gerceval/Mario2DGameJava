package com.julien.display;

public class Countdown implements Runnable {

    private final int PAUSE = 1000;
    private int timeCount;
    private String str;

    public Countdown() {
        this.timeCount = 100;
        this.str = "Time : 100";

        Thread countdown = new Thread(this);
        countdown.start();
    }

    @Override
    public void run() {
        while(true) {
            try {
                Thread.sleep(PAUSE);
            }
            catch(InterruptedException ignored) { }
            timeCount--;
            str = "Time : " + timeCount;
        }
    }

    // GETTERS
    public int getTimeCount() {
        return timeCount;
    }

    public String getStr() {
        return str;
    }
}
