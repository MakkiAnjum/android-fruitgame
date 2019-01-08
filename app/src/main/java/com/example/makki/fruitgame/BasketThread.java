package com.example.makki.fruitgame;
// Makki Anjum

public class BasketThread extends Thread {
    int x, y, dx, dy, width;

    public BasketThread(int x, int y, int dx, int dy, int width) {
        this.x = x;
        this.y = y;
        this.dx = dx;
        this.dy = dy;
        this.width = width;
    }

    @Override
    public void run() {

        if (x < width) {
            x += dx;
        } else {
            dx = -1 * dx;
        }
        try {
            Thread.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
