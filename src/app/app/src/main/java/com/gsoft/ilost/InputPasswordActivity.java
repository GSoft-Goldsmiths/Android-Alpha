package com.gsoft.ilost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

/**
 * Created by Dylan on 04/02/2018.
 */

public class InputPasswordActivity extends AppCompatActivity {

    PatternLockView mPatternLockView;
    static String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_password);

        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        password = preferences.getString("password", "0");

        mPatternLockView = (PatternLockView) findViewById(R.id.pattern_lock_view);
        mPatternLockView.addPatternLockListener(new PatternLockViewListener() {
            @Override
            public void onStarted() {

            }

            @Override
            public void onProgress(List<PatternLockView.Dot> progressPattern) {

            }

            @Override
            public void onComplete(List<PatternLockView.Dot> pattern) {
                if (password.equals(PatternLockUtils.patternToString(mPatternLockView, pattern))) {
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else
                    Toast.makeText(InputPasswordActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                mPatternLockView.clearPattern();
            }

            @Override
            public void onCleared() {

            }
        });
    }
}
