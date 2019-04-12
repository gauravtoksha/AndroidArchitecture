package com.example.myapplication;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import javax.inject.Inject;
import javax.inject.Singleton;

/*

AppExecutor to provide ThreadExecutors for background Task
* */


@Singleton
public class AppExecutors {


    /*
    Use this thread for Database CRUD operations
    * */
    private final Executor diskIO;



    /*
    Use this thread for network calls
    * */

    private final Executor networkIO;



    /*
    Use this thread for making UI changes
    * */

    private final Executor mainThread; // for UI changes

    public AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
        this.diskIO = diskIO;
        this.networkIO = networkIO;
        this.mainThread = mainThread;
    }

    @Inject
    public AppExecutors() {
        this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(3),
                new MainThreadExecutor());
    }

    public Executor diskIO() {
        return diskIO;
    }

    public Executor networkIO() {
        return networkIO;
    }

    public Executor mainThread() {
        return mainThread;
    }

    /*
    * This Inner class is made only to create object of MainThreadExecutor
    * */
    private static class MainThreadExecutor implements Executor {
        private Handler mainThreadHandler = new Handler(Looper.getMainLooper());
        @Override
        public void execute(@NonNull Runnable command) {
            mainThreadHandler.post(command);
        }
    }
}
