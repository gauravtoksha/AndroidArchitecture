package com.example.myapplication.di;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProvider;

import com.example.myapplication.ui.page1.DummyViewModel;
import com.example.myapplication.viewmodel.ViewModelFactory;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;


/*
* add a binding for every newly created ViewModel class
*
* */


@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(DummyViewModel.class) //Key for the object, Factory class will look for this.
    abstract ViewModel bindDummyViewModel(DummyViewModel dummyViewModel);//object returned when get method is called from the above key.




    @Binds
    abstract ViewModelProvider.Factory bindViewModelFactory(ViewModelFactory factory);
}
