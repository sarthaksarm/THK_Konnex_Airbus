package com.sarm.konnex;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Announcements extends AppCompatActivity {
    private FirebaseAuth.AuthStateListener mauthStateListener;
    ListView listView;
    DatabaseReference reference;
    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_announcements);

        recyclerView=findViewById(R.id.recycler_view);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);

        //reference= FirebaseDatabase.getInstance().getReference("Announcements");

    }
/*
    @Override
    protected void onStart() {
        super.onStart();
        FirebaseRecyclerAdapter<Blog, BlogViewHolder> firebaseRecyclerAdapter = new FirebaseRecyclerAdapter<Blog, Announcements.BlogViewHolder>
                (Blog.class, R.layout.cardviewnotific, Announcements.BlogViewHolder.class, reference) {
            @Override
            protected void populateViewHolder(Announcements.BlogViewHolder viewHolder, Blog model, int position) {
                viewHolder.setTitle(model.getTitle());
                viewHolder.setDesc(model.getDesc());
                viewHolder.setImage(getApplicationContext(), model.getImage());

            }
        };
        recyclerView.setAdapter(firebaseRecyclerAdapter);
    }

    public static class BlogViewHolder extends RecyclerView.ViewHolder {
        View mview;

        public BlogViewHolder(final View itemView) {
            super(itemView);
            mview = itemView;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    try {
                        TextView post_desc = (TextView) mview.findViewById(R.id.item_desc);

                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(post_desc.getText().toString()));
                        itemView.getContext().startActivity(i);
                    }
                    catch (Exception e)
                    {
                        View parentlayout = itemView.findViewById(android.R.id.content);
                        Snackbar snackbar = Snackbar.make(parentlayout,"Try again after sometime!", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }
                }
            });
        }

        public void setTitle(String title) {
            TextView post_title = (TextView) mview.findViewById(R.id.item_title);
            post_title.setText(title);
        }

        public void setDesc(String desc) {
            TextView post_desc = (TextView) mview.findViewById(R.id.item_desc);
            post_desc.setText(desc);
        }

        public void setImage(final Context ctx, final String image) {
            final ImageView post_Image = (ImageView)mview.findViewById(R.id.item_image);

//            Picasso.get().load(image).placeholder(R.drawable.splashlogo).into(post_Image);
        }
    }

 */
}
