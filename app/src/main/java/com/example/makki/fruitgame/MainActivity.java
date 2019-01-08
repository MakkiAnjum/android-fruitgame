package com.example.makki.fruitgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
// Makki Anjum

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new Graphics(this));
    }
}
