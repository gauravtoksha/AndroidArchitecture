package com.example.myapplication.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;

/*
* GsonModule for providing Gson object
*
* */

@Module
public class GsonModule {

    @Provides
    Gson provideGson(){
        return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();

    }
}
