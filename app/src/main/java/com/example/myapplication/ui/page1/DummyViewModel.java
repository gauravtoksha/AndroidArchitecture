package com.example.myapplication.ui.page1;

import android.arch.lifecycle.ViewModel;

import com.example.myapplication.viewmodel.BaseViewModel;

import javax.inject.Inject;
import javax.inject.Named;

public class DummyViewModel extends BaseViewModel {

    StringBuilder builder;

    @Inject
    public DummyViewModel( StringBuilder builder) {
        builder.append("fromViewModel");
        this.builder = builder;
    }

    public StringBuilder getBuilder() {
        return builder;
    }

    public void setBuilder(StringBuilder builder) {
        this.builder = builder;
    }
}
