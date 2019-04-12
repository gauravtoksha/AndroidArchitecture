package com.example.myapplication.di;

import com.example.myapplication.Main2Activity;
import com.example.myapplication.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
* Builder class for Activities
* Note: Remember to add newly created activity here with @ContributeAndroidInjector Annotation
* */

@Module
public abstract class MainActivityModule {

    @ContributesAndroidInjector(modules = {FragmentBuilderModule.class})
    abstract MainActivity contributeMainActivity();

    @ContributesAndroidInjector(modules = {FragmentBuilderModule.class})
    abstract Main2Activity contributeMain2Activity();

}
