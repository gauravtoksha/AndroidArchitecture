package com.example.myapplication.database;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/*
* Entity class representing single table in SQL
* This is a dummy class , make sure to change this according to your requirements
* */

@Entity
public class DummyEntity {
    @PrimaryKey
    int id;
}
