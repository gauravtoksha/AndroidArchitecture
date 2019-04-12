package com.example.myapplication.di;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.myapplication.ApplicationClass;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;
import dagger.android.support.HasSupportFragmentInjector;
import timber.log.Timber;

/*
it calls AndroidInjection.inject for every Activity or Fragment created
Remember to extend Activity with HasFragmentInjector interface
* */

public class AppInjector {
    private AppInjector(){}
    public static void init(ApplicationClass applicationClass){
        Timber.d("init");
        DaggerAppComponent.builder().application(applicationClass).build().inject(applicationClass);
        applicationClass.registerActivityLifecycleCallbacks(new Application.ActivityLifecycleCallbacks() {
            @Override
            public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
                handleActivity(activity);
                Timber.d("onActivityCreated"+activity.getLocalClassName());
            }

            @Override
            public void onActivityStarted(Activity activity) {

            }

            @Override
            public void onActivityResumed(Activity activity) {

            }

            @Override
            public void onActivityPaused(Activity activity) {

            }

            @Override
            public void onActivityStopped(Activity activity) {

            }

            @Override
            public void onActivitySaveInstanceState(Activity activity, Bundle outState) {

            }

            @Override
            public void onActivityDestroyed(Activity activity) {

            }
        });
    }
    private static void handleActivity(Activity activity){
        Timber.d("handleActivity:%s", activity.getLocalClassName());
        if(activity instanceof HasSupportFragmentInjector){
            AndroidInjection.inject(activity);
            Timber.d("HasSupportFragmentInjector:%s", activity.getLocalClassName());
        }
        if (activity instanceof FragmentActivity) {
            Timber.d("FragmentActivity:%s", activity.getLocalClassName());
            ((FragmentActivity) activity).getSupportFragmentManager()
                    .registerFragmentLifecycleCallbacks(
                            new FragmentManager.FragmentLifecycleCallbacks() {
                                @Override
                                public void onFragmentCreated(FragmentManager fm, Fragment f,
                                                              Bundle savedInstanceState) {
                                    if (f instanceof Injectable) {
                                        AndroidSupportInjection.inject(f);
                                        Timber.d("onFragmentCreated:%s", f.toString());
                                    }
                                }
                            }, true);
        }
    }
}
