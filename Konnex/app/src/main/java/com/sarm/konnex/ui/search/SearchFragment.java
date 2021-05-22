package com.sarm.konnex.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import androidx.fragment.app.Fragment;

import com.sarm.konnex.R;

import java.util.ArrayList;

public class SearchFragment extends Fragment {
    ListView lv;
    ListAdapter listAdapter;
    EditText editText;
    ListView listView;
    ListViewAdapter adapter;
    String[] Name;
    String[] author;
    ArrayList<PeopleName> nameArrayList = new ArrayList<PeopleName>();
    public SearchFragment() {
        // Required empty public constructor
    }

    public static SearchFragment newInstance() {
        SearchFragment fragment = new SearchFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootview= inflater.inflate(R.layout.fragment_search, container, false);


        //Create string array
        Name = new String[]{"Airbus", "Event","Team"};

        author = new String[]{"Company", "Hackathon", "Details"};

        //Listview
        listView = (ListView)rootview.findViewById(R.id.list);

        //Set Data
        for (int i = 0; i < Name.length; i++){
            PeopleName PN = new PeopleName(Name[i],author[i]);
            nameArrayList.add(PN);
        }

        //The custom adapter
        adapter = new ListViewAdapter(rootview.getContext(), nameArrayList);

        //Listview
        listView.setAdapter(adapter);

        //Edittext
        editText = (EditText)rootview.findViewById(R.id.Edt);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                //Search or Filter
                String who = editText.getText().toString().toLowerCase(Locale.getDefault());
                adapter.filter(who);
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        
        return rootview;
    }
}