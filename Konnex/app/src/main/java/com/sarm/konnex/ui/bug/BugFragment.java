package com.sarm.konnex.ui.bug;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.sarm.konnex.KConstants;
import com.sarm.konnex.R;
import com.sarm.konnex.db.KDatabase;
import com.sarm.konnex.ui.bug.adapter.BugAdapter;

public class BugFragment extends Fragment {


    private RecyclerView bugsLayout;

    public BugFragment() {
    }

    public static BugFragment newInstance() {
        BugFragment fragment = new BugFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_bug, container, false);
        KDatabase database = Room.databaseBuilder(requireActivity(), KDatabase.class, KDatabase.DB_NAME).build();
        getActivity().setTitle("Bug Report");

        bugsLayout = view.findViewById(R.id.bugs_layout);
        bugsLayout.setLayoutManager(new LinearLayoutManager(requireActivity()));
        bugsLayout.addItemDecoration(new DividerItemDecoration(requireActivity(), DividerItemDecoration.VERTICAL));

        database.bugDao().selectAllBugs().observe(this, bugList -> {
            Log.d(KConstants.DEBUG_TAG, String.valueOf(bugList.size()));
            bugsLayout.setAdapter(new BugAdapter(bugList));
        });

        view.findViewById(R.id.new_bug).setOnClickListener(view1 ->
                startActivity(new Intent(requireActivity(), AddBugActivity.class)));

        return view;
    }
}