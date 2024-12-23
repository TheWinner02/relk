package com.relk.ui.tv;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TVViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public TVViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is SerieTV fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}