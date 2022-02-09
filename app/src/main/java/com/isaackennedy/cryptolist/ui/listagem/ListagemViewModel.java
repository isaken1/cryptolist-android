package com.isaackennedy.cryptolist.ui.listagem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ListagemViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ListagemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}