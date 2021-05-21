package com.sarm.konnex.db;


import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.sarm.konnex.db.dao.BugDoa;
import com.sarm.konnex.db.model.Bug;

@Database(entities = {Bug.class}, version = 1, exportSchema = false)
public abstract class KDatabase extends RoomDatabase {

    public static final String DB_NAME = "app_db";
    public static final String TABLE_NAME_BUG = "bug";

    public abstract BugDoa bugDao();

}