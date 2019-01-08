package com.example.makki.fruitgame;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

public class Graphics extends View {

    int width = 1000;
    int height = 1400;

    int LeftArea, RightArea, CenterPoint, RightCenter, LeftCenter = 0;

    Bitmap bananaBmp, appleBmp, orangeBmp, cartBmp;
    sprites banana, apple, orange;
    BasketThread cart;

    public Graphics(Context context) {
        super(context);

        LeftArea = width / 3;
        RightArea = LeftArea * 2;
        CenterPoint = width / 2;

        RightCenter = width - (LeftArea / 2);
        LeftCenter = LeftArea / 2;

        banana = new sprites(LeftCenter, 0, 0, 5, height);
        apple = new sprites(CenterPoint, -50, 0, 5, height);
        orange = new sprites(RightCenter, -100, 0, 5, height);
        cart = new BasketThread(500, (height - 5), 1, 0, width);


        bananaBmp = BitmapFactory.decodeResource(getResources(), R.drawable.banana);
        appleBmp = BitmapFactory.decodeResource(getResources(), R.drawable.apple);
        orangeBmp = BitmapFactory.decodeResource(getResources(), R.drawable.orange);
        cartBmp = BitmapFactory.decodeResource(getResources(), R.drawable.basket);
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(bananaBmp, banana.x, banana.y, null);
        canvas.drawBitmap(appleBmp, apple.x, apple.y, null);
        canvas.drawBitmap(orangeBmp, orange.x, orange.y, null);
        canvas.drawBitmap(cartBmp, cart.x, cart.y, null);

        if (cart.x < LeftArea) {
            if (banana.y >= cart.y) {
                banana.y = -100;
                Toast.makeText(null, "Banana is captured", Toast.LENGTH_SHORT).show();
            }
        }
        else if (cart.x > RightArea) {
            if (orange.y >= cart.y) {
                orange.y = -100;
                Toast.makeText(null, "Orange is captured", Toast.LENGTH_SHORT).show();
            }
        }
        else{
            if (apple.y >= cart.y) {
                apple.y = -100;
                Toast.makeText(null, "Apple is captured", Toast.LENGTH_SHORT).show();
            }
        }


        banana.start();
        apple.start();
        orange.start();
        cart.start();

        invalidate();

    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
            int touchX = Math.round(motionEvent.getX());
            int touchY = Math.round(motionEvent.getY());

            cart.dx = 0;

            if (touchX < LeftArea) {
                cart.x = LeftCenter;
            } else if (touchX > LeftArea && touchX < RightArea) {
                cart.x = CenterPoint;
            } else {
                cart.x = RightCenter;
            }
            postInvalidate();
        }
        return true;
    }
}

