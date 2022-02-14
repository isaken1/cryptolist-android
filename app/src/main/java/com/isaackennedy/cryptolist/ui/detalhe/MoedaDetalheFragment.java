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
import com.isaackennedy.cryptolist.service.retrofit.CoinDetailInitializer;
import com.isaackennedy.cryptolist.service.retrofit.MoedaDetalheService;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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

//        Moeda[] m = new Moeda[1];

        MoedaDetalheService service = new CoinDetailInitializer().coinDetailService() ;

        Call<Moeda> chamada = service.getDetalhesMoeda(mMoeda.getId());

        chamada.enqueue(new Callback<Moeda>(){

            @Override
            public void onResponse(Call<Moeda> call, Response<Moeda> response){

                mMoeda = response.body();

//                rvMoedas.notify();


            }

            @Override
            public void onFailure(Call<Moeda> call, Throwable t){

            }
        });


        View layout = inflater.inflate(R.layout.fragment_moeda_detalhe, container, false);

        tvNome = layout.findViewById(R.id.tvNome);
        tvSimbolo = layout.findViewById(R.id.tvSimbolo);
        tvPreco = layout.findViewById(R.id.tvPreco);
        tvData = layout.findViewById(R.id.tvData);

        if(mMoeda != null) {
            tvNome.setText(mMoeda.getNome());
            tvSimbolo.setText(mMoeda.getSimbolo());
            tvPreco.setText(Float.toString(mMoeda.getPreco()));
        }

        Instant now = Instant.now();
        ZoneId zone = ZoneId.of("America/Recife");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        ZonedDateTime zonedNow = ZonedDateTime.ofInstant(now, zone);

        String data = "Última vez atualizado em " + dtf.format(zonedNow);

        tvData.setText(data);

        return layout;
    }
}