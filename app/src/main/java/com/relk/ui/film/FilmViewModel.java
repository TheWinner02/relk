package com.relk.ui.film;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FilmViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public FilmViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is Film fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}