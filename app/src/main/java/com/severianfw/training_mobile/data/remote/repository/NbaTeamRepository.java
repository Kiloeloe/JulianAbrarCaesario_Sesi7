package com.severianfw.training_mobile.data.remote.repository;

import android.app.Application;

import androidx.lifecycle.LiveData;

import com.severianfw.training_mobile.data.remote.NbaTeamItem;
import com.severianfw.training_mobile.data.remote.local.NbaTeamDao;
import com.severianfw.training_mobile.data.remote.local.NbaTeamRoomDatabase;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class NbaTeamRepository {
    private final NbaTeamDao mNbaTeamDao;
    private final ExecutorService mExecutorService;

    public NbaTeamRepository(Application application){
        ExecutorService = Executors.newSingleThreadExecutor();
        NbaTeamRoomDatabase db = NbaTeamRoomDatabase.getDatabase(application);
        mNbaTeamDao = db.mNbaTeamDao();
    }

    //asynchronus di background
    public LiveData<List<NbaTeamItem>> getNbaItems(){
        return mNbaTeamDao.getNbaTeams();
    }


    //synchronous
    public void insert(final NbaTeamItem nbaTeamItem){
//        mExecutorService.execute(new Runnable() {
//            @Override
//            public void run() {
//                mNbaTeamDao.insert(nbaTeamItem);
//            }
//        }{});
        mExecutorService.execute(() -> mNbaTeamDao.insert(nbaTeamItem));
    }



}
