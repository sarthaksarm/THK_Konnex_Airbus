package com.sarm.konnex.ui.bug.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sarm.konnex.R;
import com.sarm.konnex.db.model.Bug;

import java.util.List;
import java.util.Locale;

public class BugAdapter extends RecyclerView.Adapter<BugAdapter.MyViewHolder> {
    private final List<Bug> bugList;

    public BugAdapter(List<Bug> bugList){
        this.bugList = bugList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bug, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.bugTitle.setText(bugList.get(position).title);
        holder.bugDetails.setText(String.format(Locale.getDefault(), "%s • %s",
                bugList.get(position).username,
                bugList.get(position).description));
    }

    @Override
    public int getItemCount() {
        return bugList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView bugTitle;
        private final TextView bugDetails;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            bugTitle = itemView.findViewById(R.id.bug_title);
            bugDetails = itemView.findViewById(R.id.bug_details);
        }
    }
}
