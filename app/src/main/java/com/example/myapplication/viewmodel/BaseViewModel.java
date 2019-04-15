package com.example.myapplication.viewmodel;

import android.arch.lifecycle.ViewModel;

public class BaseViewModel extends ViewModel {
    private boolean busy;

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }
}
