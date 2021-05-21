package com.sarm.konnex.ui.announcement;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sarm.konnex.R;

import java.util.ArrayList;
import java.util.List;

public class AnnounceFragment extends Fragment {
    MyAdapterquote myAdapter;
    List<writingsModel> movieList=new ArrayList<>();

    ProgressBar progressBar;
    private OnFragmentInteractionListener mListener;

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
        View rootview= inflater.inflate(R.layout.fragment_announce, container, false);
        progressBar=rootview.findViewById(R.id.progressbar);

        final RecyclerView rv=rootview.findViewById(R.id.recycler_view);
        rv.setAdapter(myAdapter);

        LinearLayoutManager lm=new LinearLayoutManager(getActivity());
        rv.setLayoutManager(lm);

        DatabaseReference ref1= FirebaseDatabase.getInstance().getReference("Announcement");

        try {
            ref1.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    movieList.clear();
                    String title = "";

                    if (dataSnapshot.exists() && dataSnapshot.getChildrenCount() > 0) {
                        for (DataSnapshot x : dataSnapshot.getChildren()) {
                            title = x.child("content").getValue().toString();
                            movieList.add(new writingsModel(title));
                            myAdapter = new MyAdapterquote(movieList);
                            progressBar.setVisibility(View.INVISIBLE);
                            rv.setAdapter(myAdapter);
                            progressBar.setVisibility(View.INVISIBLE);
                        }

                    } else {
                        title = "No record found currently! Please try again later.";
                    }


                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            rv.smoothScrollToPosition(0);
                        }
                    });
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                    View parentLayout = getActivity().findViewById(android.R.id.content);
                    Snackbar snackbar = Snackbar.make(parentLayout,
                            "Database error! Try again later", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            });
        }
        catch (Exception e)
        {
            Log.d("fds",e+"");

        }
        return rootview;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}