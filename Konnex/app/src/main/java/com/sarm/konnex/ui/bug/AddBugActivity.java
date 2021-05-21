package com.sarm.konnex.ui.bug;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.sarm.konnex.R;
import com.sarm.konnex.db.KDatabase;
import com.sarm.konnex.db.model.Bug;
import com.sarm.konnex.helper.Validator;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class AddBugActivity extends AppCompatActivity {

    private TextInputEditText bugTitle;
    private TextInputEditText userName;
    private TextInputEditText bugDescription;

    private KDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bug_actvity);
        database = Room.databaseBuilder(this, KDatabase.class, KDatabase.DB_NAME).build();

        bugTitle = findViewById(R.id.bug_title);
        userName = findViewById(R.id.user_name);
        bugDescription = findViewById(R.id.bug_desc);

        findViewById(R.id.add).setOnClickListener(v -> submitBug());
    }

    private void submitBug() {
        if (Validator.validateString(bugTitle, "Title cannot be empty") &&
                Validator.validateString(userName, "User name cannot be empty") &&
                Validator.validateString(bugDescription, "Bug description must contain some information")) {
            Bug bug = new Bug(bugTitle.getText().toString(), bugDescription.getText().toString(), userName.getText().toString());

            String title = bugTitle.getText().toString();
            String desc = bugDescription.getText().toString();
            String username = userName.getText().toString();

            new Thread() {
                @Override
                public void run() {
                    database.bugDao().insertBug(bug);
                    finish();
                }
            }.start();

            //Uploading bug to database
            DatabaseReference refvalue= FirebaseDatabase.getInstance().getReference("Bug_Reports");

            refvalue.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    String id=System.currentTimeMillis()+"";

                    DatabaseReference refdate= FirebaseDatabase.getInstance().getReference("Bug_Reports").child(id).child("Date of report");

                    final String date = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss", Locale.getDefault()).format(new Date());
                    refdate.setValue(date);

                    DatabaseReference reftitle= FirebaseDatabase.getInstance().getReference("Bug_Reports").child(id)
                            .child("title");

                    DatabaseReference refdesc=FirebaseDatabase.getInstance().getReference("Bug_Reports").child(id).child("description");

                    DatabaseReference refname=FirebaseDatabase.getInstance().getReference("Bug_Reports").child(id).child("username");

                    reftitle.setValue(title);
                    refdesc.setValue(desc);
                    refname.setValue(username);


                    Toast.makeText(AddBugActivity.this, "Uploaded successfully!", Toast.LENGTH_SHORT).show();
//
//                    Intent i=new Intent(getApplicationContext(),MainActivity.class);
//                    startActivity(i);
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });



        }
    }
}