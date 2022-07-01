package com.severianfw.training_mobile.data.remote.local;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.severianfw.training_mobile.data.remote.NbaTeamItem;

import java.util.List;

@Dao

public class NbaTeamDao {


    @Insert
    void insert(NbaTeamItem nbaTeamItem);

    @Query("SELECT * from NbaTeamItem")
    LiveData<List<NbaTeamItem>> getNbaTeams() {
        return null;
    }

}
