package com.isaackennedy.cryptolist.ui.listagem;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.isaackennedy.cryptolist.model.Moeda;

public class ListagemViewModel extends ViewModel {

    private MutableLiveData<String> mText;
    private MutableLiveData<Moeda> rvMoedas;

    public ListagemViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is list fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}