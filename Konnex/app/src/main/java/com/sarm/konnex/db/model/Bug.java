package com.sarm.konnex.db.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.sarm.konnex.db.KDatabase;

import java.io.Serializable;

@Entity(tableName = KDatabase.TABLE_NAME_BUG)
public class Bug implements Serializable {

    @PrimaryKey(autoGenerate = true)
    public int bug_id;

    public String title;
    public String description;
    public String username;

    public Bug(String title, String description, String username) {
        this.title = title;
        this.description = description;
        this.username = username;
    }
}