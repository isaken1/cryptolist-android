package com.isaackennedy.cryptolist.ui.listagem;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.isaackennedy.cryptolist.R;
import com.isaackennedy.cryptolist.adapters.AdapterMod;
import com.isaackennedy.cryptolist.databinding.FragmentListagemBinding;
import com.isaackennedy.cryptolist.model.Moeda;
import com.isaackennedy.cryptolist.service.retrofit.MoedaService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.Callback;
import retrofit2.converter.gson.GsonConverterFactory;

public class ListagemFragment extends Fragment {

//    private ListagemViewModel listagemViewModel;
//    private FragmentListagemBinding binding;
    private List<Moeda> mMoedas = new ArrayList<Moeda>();
    RecyclerView rvMoedas;
    AdapterMod adapterMod;

    private Retrofit retrofit;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        retrofit = new Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

        View layout = inflater.inflate(R.layout.fragment_listagem, container, false);

        rvMoedas = layout.findViewById(R.id.rvMoedas);

        mMoedas = carregaMoedas();

        adapterMod = new AdapterMod(mMoedas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMoedas.setLayoutManager(layoutManager);

        rvMoedas.setHasFixedSize(true);

        rvMoedas.setAdapter(adapterMod);

        adapterMod.implementaAoClicarNaLista(new AdapterMod.AoClicarNaLista() {
            @Override
            public void clicouNoElemento(int position) {
                Toast.makeText(getActivity(), "Você clicou em " + mMoedas.get(position).getNome(),Toast.LENGTH_SHORT).show();

                Activity activity = getActivity();

                if(activity instanceof AoClicarNaMoedaMod){

                    AoClicarNaMoedaMod listener = (AoClicarNaMoedaMod) activity;
                    listener.clicouNaMoedaMod(mMoedas.get(position));
                }

            }
        });

        return layout;

//        listagemViewModel =
//                new ViewModelProvider(this).get(ListagemViewModel.class);
//
//        binding = FragmentListagemBinding.inflate(inflater, container, false);
//        View root = binding.getRoot();
        
//        final TextView textView = binding.textHome;
//        listagemViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });
//        return root;
    }

    private List<Moeda> carregaMoedas() {
        List<Moeda> moedas = new ArrayList<>();

//         moedas.add(new Moeda(1L, "bitcoin", 1, "BTC", true));
//         moedas.add(new Moeda(2L, "gabodes", 2, "GBS", false));

        MoedaService service = retrofit.create(MoedaService.class);

        Call<List<Moeda>> chamada = service.getMoedas();

        chamada.enqueue(new Callback<List<Moeda>>(){

            @Override
            public void onResponse(Call<List<Moeda>> call, Response<List<Moeda>> response){
                if(response.isSuccessful()){
                    for(int i = 0; i < response.body().toArray().length; i++){
                        moedas.add(response.body().get(i));
                        
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Moeda>> call, Throwable t){

            }
        });

        return moedas;
    }

    public interface AoClicarNaMoedaMod{
        public void clicouNaMoedaMod(Moeda moeda);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}