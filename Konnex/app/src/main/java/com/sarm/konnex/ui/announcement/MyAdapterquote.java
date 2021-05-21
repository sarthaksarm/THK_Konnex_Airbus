package com.sarm.konnex.ui.announcement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import com.sarm.konnex.R;

import java.util.List;

public class MyAdapterquote extends RecyclerView.Adapter<MyAdapterquote.MyViewHolder> {
    private List<writingsModel> userList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.firetitle);
        }
    }

    public MyAdapterquote(List<writingsModel> moviesList) {
        this.userList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_listquote, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String writ = userList.get(position).getWritings();
        holder.title.setText(writ);
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }
}