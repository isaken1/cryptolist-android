package com.isaackennedy.cryptolist.ui.detalhe;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.isaackennedy.cryptolist.R;
import com.isaackennedy.cryptolist.model.Moeda;


public class MoedaDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String MOEDA = "moeda";

    Moeda mMoeda;

    public MoedaDetalheFragment() {

    }

    public static MoedaDetalheFragment novaInstancia(Moeda moeda) {
        MoedaDetalheFragment fragment = new MoedaDetalheFragment();

        Bundle params = new Bundle();

        params.putSerializable(MOEDA, moeda);

        fragment.setArguments(params);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mMoeda = (Moeda) getArguments().getSerializable(MOEDA);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_moeda_detalhe, container, false);

        return layout;
    }
}