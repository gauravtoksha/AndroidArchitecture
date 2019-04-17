package com.example.myapplication.viewmodel;

//paprent for list  view such as recycler view,etc.
public class BaseListViewModel extends BaseViewModel {
    //selected items
    //position
    //object
    //view if needed
    int selectedItemPosition;

    public int getSelectedItemPosition() {
        return selectedItemPosition;
    }

    public void setSelectedItemPosition(int selectedItemPosition) {
        this.selectedItemPosition = selectedItemPosition;
    }
}
