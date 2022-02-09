package com.isaackennedy.cryptolist.ui.favoritas;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class FavoritasViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public FavoritasViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is notifications fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}