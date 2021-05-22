package com.sarm.konnex.ui.search;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.sarm.konnex.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ListViewAdapter extends BaseAdapter {

    Context cont;
    LayoutInflater layinf;
    List<PeopleName> modellist;
    ArrayList<PeopleName> arrayList;

    //constructor
    public ListViewAdapter(Context context, List<PeopleName> modellist) {
        cont = context;
        this.modellist = modellist;
        layinf = LayoutInflater.from(context);
        this.arrayList = new ArrayList<PeopleName>();
        this.arrayList.addAll(modellist);
    }

    public class ViewHolder{
        TextView mTitleTv, mDescTv;
    }

    @Override
    public int getCount() {
        return modellist.size();
    }

    @Override
    public Object getItem(int i) {
        return modellist.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int postition, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view==null){
            holder = new ViewHolder();
            view = layinf.inflate(R.layout.listitems, null);
            //locate the views in row.xml
            holder.mTitleTv = view.findViewById(R.id.musicname);
            holder.mDescTv = view.findViewById(R.id.musiccmp);

            view.setTag(holder);

        }
        else {
            holder = (ViewHolder)view.getTag();
        }
        //set the results into textviews
        holder.mTitleTv.setText(modellist.get(postition).getName());
        holder.mDescTv.setText(modellist.get(postition).getAuthor());

        //listview item clicks
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //code later
                Toast.makeText(cont,"We'll add details later",Toast.LENGTH_SHORT).show();

            }
        });


        return view;
    }

    //filter
    public void filter(String charText){
        charText = charText.toLowerCase(Locale.getDefault());
        modellist.clear();
        if (charText.length()==0){
            modellist.addAll(arrayList);
        }
        else {
            for (PeopleName model : arrayList){
                if (model.getName().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
                else if (model.getAuthor().toLowerCase(Locale.getDefault())
                        .contains(charText)){
                    modellist.add(model);
                }
            }
        }
        notifyDataSetChanged();
    }
}

