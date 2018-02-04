package com.gsoft.ilost;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.andrognito.patternlockview.PatternLockView;
import com.andrognito.patternlockview.listener.PatternLockViewListener;
import com.andrognito.patternlockview.utils.PatternLockUtils;

import java.util.List;

/**
 * Created by Dylan on 04/02/2018.
 */

public class CreatePasswordActivity extends AppCompatActivity {

    PatternLockView mPatternLockView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_password);

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
                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("password", PatternLockUtils.patternToString(mPatternLockView, pattern));
                editor.apply();

                Intent intent = new Intent(getApplicationContext(), InputPasswordActivity.class);
                startActivity(intent);
                finish();
            }

            @Override
            public void onCleared() {

            }
        });

    }
}
