package com.sarm.konnex;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    Intent i=new Intent(MainActivity.this,NavSearch.class);
                    Toast.makeText(MainActivity.this, "Switching to Application Navigation page", Toast.LENGTH_LONG).show();
                    startActivity(i);
                    return true;
//                case R.id.navigation_voice:
//                    //voice();
//                    return true;

                case R.id.navigation_chatbot:
                    Intent i1=new Intent(MainActivity.this,ChatBot.class);
                    Toast.makeText(MainActivity.this, "Contacting Chat-bot support", Toast.LENGTH_LONG).show();
                    startActivity(i1);
                    return true;

                case R.id.navigation_feedback:
                    Intent i2=new Intent(MainActivity.this,ReportBug.class);
                    Toast.makeText(MainActivity.this, "Opening a 'Report Bug' case", Toast.LENGTH_LONG).show();
                    startActivity(i2);
                    return true;

                case R.id.navigation_announce:
                    Intent i3=new Intent(MainActivity.this,Announcements.class);
                    Toast.makeText(MainActivity.this, "Checking Collective Announcements section", Toast.LENGTH_LONG).show();
                    startActivity(i3);
                    return true;

                case R.id.navigation_performance:
                    Intent i4=new Intent(MainActivity.this,Performance.class);
                    Toast.makeText(MainActivity.this, "Measuring application usage and performance", Toast.LENGTH_LONG).show();
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