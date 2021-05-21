package com.sarm.konnex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import com.google.android.material.tabs.TabLayout;
import com.sarm.konnex.adapter.MainPagerAdapter;
import com.sarm.konnex.db.KDatabase;
import com.sarm.konnex.db.model.Bug;
import com.sarm.konnex.helper.KPref;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private KDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = Room.databaseBuilder(MainActivity.this, KDatabase.class, KDatabase.DB_NAME).build();
        if(! KPref.getUserInstance(MainActivity.this)) {
            writeSomeDummyBugs();
            KPref.storeUserInstance(MainActivity.this);
        }

        ViewPager viewPager = findViewById(R.id.bottom_nav);
        viewPager.setAdapter(new MainPagerAdapter(getSupportFragmentManager()));

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        for(int i = 0; i < tabLayout.getTabCount(); i++){
            tabLayout.getTabAt(i).setIcon(KConstants.TAB_ICONS[i]);
        }
    }

    private void writeSomeDummyBugs() {
        List<Bug> bugs = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            bugs.add(new Bug("Bug " + i, "Bug des " + i, "User " + i));
        }

        new Thread(){
            @Override
            public void run() {
                database.bugDao().insertBugList(bugs);
            }
        }.start();
    }
}