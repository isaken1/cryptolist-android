package com.isaackennedy.cryptolist.ui.detalhe;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.isaackennedy.cryptolist.R;
import com.isaackennedy.cryptolist.model.Moeda;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class MoedaDetalheFragment extends Fragment {

    public static final String TAG_DETALHE = "tagDetalhe";
    public static final String MOEDA = "moeda";

    Moeda mMoeda;

    TextView tvNome;
    TextView tvSimbolo;
    TextView tvPreco;
    TextView tvData;

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_moeda_detalhe, container, false);

        tvNome = layout.findViewById(R.id.tvNome);
        tvSimbolo = layout.findViewById(R.id.tvSimbolo);
        tvPreco = layout.findViewById(R.id.tvPreco);
        tvData = layout.findViewById(R.id.tvData);

        if(mMoeda != null) {
            tvNome.setText(mMoeda.getId());
            tvSimbolo.setText(mMoeda.getSimbolo());
            tvPreco.setText(Float.toString(mMoeda.getPreco()));
        }

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();

        tvData.setText("Última vez atualizado em " + dtf.format(now));

        return layout;
    }
}