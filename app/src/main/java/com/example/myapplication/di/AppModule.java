package com.example.myapplication.di;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.example.myapplication.ApplicationClass;
import com.example.myapplication.api.Service;
import com.example.myapplication.database.DummyDao;
import com.example.myapplication.database.DummyDatabase;
import com.google.gson.Gson;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/*
* Application Module for Application level objects
*
* */

@Module(includes = ViewModelModule.class)
class AppModule {


    //db
    //Dao

    @Singleton
    @Provides
    DummyDao provideDao(DummyDatabase db){
        return db.dummyDao();
    }

    DummyDatabase provideDatabase(ApplicationClass applicationClass){
        return Room.databaseBuilder(applicationClass.getApplicationContext(),DummyDatabase.class,"dummyDb").build();
    }



    @Singleton
    @Provides
    Service provideService(Gson gson, OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl("www.dummyUrl.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build().create(Service.class);
    }


    @Provides
    @Singleton
    StringBuilder provideStringBuilder(){return new StringBuilder("this is something");}


    @Singleton
    @Provides
    Context provideContext(Application application){
        return application.getApplicationContext();
    }
}
