package com.example.myapplication.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/*
* Data Access Object for reading and writing into DB
* */

@Database(entities = DummyEntity.class,version = 1,exportSchema = false)
public abstract class DummyDatabase extends RoomDatabase {
    public abstract DummyDao dummyDao();
}
