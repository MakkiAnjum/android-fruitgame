package com.example.makki.fruitgame;
// Makki Anjum

public class sprites extends Thread {

    int x, y, dx, dy, height;

    public sprites(int x, int y, int dx, int dy, int height) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.height = height;
    }

    @Override
    public void run() {

        if (y < height) {
            y += dy;
        }
        else {
            y = 0;
        }
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

