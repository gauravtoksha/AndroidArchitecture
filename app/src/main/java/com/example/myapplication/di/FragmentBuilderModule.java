package com.example.myapplication.di;

import com.example.myapplication.firstFragment;
import com.example.myapplication.secondFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/*
 * Builder class for Fragment
 * Note: Remember to add newly created fragment here with @ContributeAndroidInjector Annotation
 * */


@Module
public abstract class FragmentBuilderModule {

    @ContributesAndroidInjector(modules = {})
    abstract firstFragment contributeFirstFragment();

    @ContributesAndroidInjector(modules = {})
    abstract secondFragment contributeSecondFragment();
}
