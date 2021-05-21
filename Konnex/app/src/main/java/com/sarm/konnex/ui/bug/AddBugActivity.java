package com.sarm.konnex.ui.bug;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.google.android.material.textfield.TextInputEditText;
import com.sarm.konnex.R;
import com.sarm.konnex.db.KDatabase;
import com.sarm.konnex.db.model.Bug;
import com.sarm.konnex.helper.Validator;

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

            new Thread() {
                @Override
                public void run() {
                    database.bugDao().insertBug(bug);
                    finish();
                }
            }.start();
        }
    }
}