package com.gsoft.ilost;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout nDrawerLayout;
    private ActionBarDrawerToggle nToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nDrawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
        nToggle = new ActionBarDrawerToggle(this, nDrawerLayout, R.string.open, R.string.close);

        nDrawerLayout.addDrawerListener(nToggle);
        nToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            // method invoked only when the actionBar is not null.
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

    }

    public boolean onOptionsItemSelected(MenuItem item) {

        if (nToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
