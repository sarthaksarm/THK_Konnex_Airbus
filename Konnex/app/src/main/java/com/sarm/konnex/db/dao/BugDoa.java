package com.sarm.konnex.db.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.sarm.konnex.db.KDatabase;
import com.sarm.konnex.db.model.Bug;

import java.util.List;

@Dao
public interface BugDoa {

    @Insert
    void insertBug(Bug bug);

    @Insert
    void insertBugList(List<Bug> bugList);

    @Query("SELECT * FROM " + KDatabase.TABLE_NAME_BUG)
    LiveData<List<Bug>> selectAllBugs();

    @Query("SELECT * FROM " + KDatabase.TABLE_NAME_BUG + " WHERE title = :title")
    List<Bug> selectBugsByTitle(String title);

    @Update
    int updateTodo(Bug bug);

    @Delete
    int deleteTodo(Bug bug);
}