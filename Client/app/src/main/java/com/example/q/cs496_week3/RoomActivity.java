package com.example.q.cs496_week3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class RoomActivity extends AppCompatActivity {

    public static String ROOM;

    boolean doubleBack = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ROOM = getIntent().getStringExtra("room");

//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setDisplayUseLogoEnabled(true);
//        actionBar.setLogo(R.drawable.chickenleg);

        setContentView(R.layout.activity_room);
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
////        MenuInflater inflater = getMenuInflater();
////        inflater.inflate(R.menu.room_menu, menu);
//
//        ActionBar actionBar = getSupportActionBar();
//        actionBar.setDisplayShowCustomEnabled(true);
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.room_toolbar);
//        setSupportActionBar(toolbar);
//        toolbar.setNavigationIcon(R.drawable.chat);
//        toolbar.setTitle(ROOM);
//        toolbar.inflateMenu(R.menu.main);
//        return true;
//    }

    @Override
    public void onBackPressed() {
        if (doubleBack) {
            super.onBackPressed();
            Intent intent = new Intent(RoomActivity.this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
        }

        doubleBack = true;
        Toast.makeText(this, "Press BACK again to leave room", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                doubleBack = false;
            }
        }, 2000);
    }

    @Override
    public boolean onOptionsItemSelected (MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            finish();
        }
        return true;
    }
}
