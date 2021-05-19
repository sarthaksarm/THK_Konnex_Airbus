package com.sarm.konnex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i=new Intent(MainActivity.this,NavSearch.class);
                    startActivity(i);
                    return true;
                case R.id.navigation_voice:
                    //voice();
                    return true;

                case R.id.navigation_chatbot:
                    Intent i1=new Intent(MainActivity.this,MapsActivity.class);
                    startActivity(i1);
                    return true;

                case R.id.navigation_feedback:
                    Intent i2=new Intent(MainActivity.this,ReportBug.class);
                    startActivity(i2);
                    return true;

                case R.id.navigation_announce:
                    Intent i3=new Intent(MainActivity.this,Announcements.class);
                    startActivity(i3);
                    return true;

                case R.id.navigation_performance:
                    Intent i4=new Intent(MainActivity.this,Performance.class);
                    startActivity(i4);
                    return true;



            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }
}