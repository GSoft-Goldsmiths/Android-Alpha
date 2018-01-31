package com.example.dylan.ilost;

<<<<<<< HEAD
import android.content.Intent;
import android.os.Handler;
=======
>>>>>>> 1b06a1da82b2d7b6bb742e9c6c762ce29e7b9dd2
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
<<<<<<< HEAD
    private static int SPLASH_TIME_OUT = 3000;
=======
>>>>>>> 1b06a1da82b2d7b6bb742e9c6c762ce29e7b9dd2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeIntent = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(homeIntent);
                finish();
            }
        }, SPLASH_TIME_OUT);
=======
>>>>>>> 1b06a1da82b2d7b6bb742e9c6c762ce29e7b9dd2
    }
}
