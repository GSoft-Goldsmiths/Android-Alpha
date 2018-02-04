package com.gsoft.ilost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        SharedPreferences wmbPreference = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isFirstRun = wmbPreference.getBoolean("FIRSTRUN", true);
        if (isFirstRun) {
            // Code to run once
            SharedPreferences preferences = getSharedPreferences("PREFS", 0);
            String password = preferences.getString("Password", "0");
            password = preferences.getString("Password", "0");
            if (password.equals("0")) {
                Intent intent = new Intent(getApplicationContext(), CreatePasswordActivity.class);
                startActivity(intent);
                finish();
            }
            SharedPreferences.Editor editor = wmbPreference.edit();
            editor.putBoolean("FIRSTRUN", false);
            editor.commit();
        }else {
            Intent intent = new Intent(getApplicationContext(), InputPasswordActivity.class);
            startActivity(intent);
            finish();
        }
        setContentView(R.layout.activity_login);
    }
}
