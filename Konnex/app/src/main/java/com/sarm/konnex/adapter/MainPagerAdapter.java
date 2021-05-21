package com.sarm.konnex.adapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.sarm.konnex.ui.announcement.AnnounceFragment;
import com.sarm.konnex.ui.bug.BugFragment;
import com.sarm.konnex.ui.chat.ChatBotFragment;
import com.sarm.konnex.ui.performance.PerformanceFragment;
import com.sarm.konnex.ui.search.SearchFragment;

import java.util.ArrayList;
import java.util.List;

public class MainPagerAdapter extends FragmentPagerAdapter {

    List<Fragment> fragments = new ArrayList<>();

    public MainPagerAdapter(FragmentManager fm) {
        super(fm, FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        setFragments();
    }

    public void setFragments() {
        fragments.add(SearchFragment.newInstance());
        fragments.add(ChatBotFragment.newInstance());
        fragments.add(BugFragment.newInstance());
        fragments.add(PerformanceFragment.newInstance());
        fragments.add(AnnounceFragment.newInstance());
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return null;
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
}