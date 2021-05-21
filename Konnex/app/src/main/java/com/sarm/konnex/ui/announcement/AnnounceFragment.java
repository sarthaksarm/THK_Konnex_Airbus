package com.sarm.konnex.ui.announcement;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sarm.konnex.R;

public class AnnounceFragment extends Fragment {

    public AnnounceFragment() {
        // Required empty public constructor
    }

    public static AnnounceFragment newInstance() {
        AnnounceFragment fragment = new AnnounceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_announcement, container, false);

    }
}