package com.sarm.konnex.ui.performance;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.sarm.konnex.R;

public class PerformanceFragment extends Fragment {

    public PerformanceFragment() {
        // Required empty public constructor
    }

    public static PerformanceFragment newInstance() {
        PerformanceFragment fragment = new PerformanceFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_performance, container, false);
    }
}