package com.severianfw.training_mobile.data.remote.local;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.severianfw.training_mobile.data.remote.NbaTeamItem;


@Database(entities = {NbaTeamItem.class}, version = 1)
public abstract class NbaTeamRoomDatabase extends RoomDatabase {
    public abstract NbaTeamDao mNbaTeamDao();

    public NbaTeamRoomDatabase(){

    }

    private static NbaTeamRoomDatabase INSTANCE;

    public static NbaTeamRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (NbaTeamRoomDatabase.class){
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),NbaTeamRoomDatabase.class, "nba_database").build();
            }
            return
        }
        return INSTANCE
    }
}
