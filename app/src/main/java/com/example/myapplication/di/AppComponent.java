package com.example.myapplication.di;

import android.app.Application;

import com.example.myapplication.ApplicationClass;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;

/*
Application Level Component
* */

@Singleton
@Component(modules = {AndroidInjectionModule.class,AppModule.class,MainActivityModule.class,GsonModule.class,OkHttpModule.class})
public interface AppComponent {


    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
    void inject(ApplicationClass applicationClass);
}
