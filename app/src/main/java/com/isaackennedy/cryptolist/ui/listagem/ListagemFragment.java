package com.isaackennedy.cryptolist.ui.listagem;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.List;

public class ListagemFragment extends Fragment {

//    private ListagemViewModel listagemViewModel;
//    private FragmentListagemBinding binding;
    private List<Moeda> mMoedas = new ArrayList<Moeda>();
    RecyclerView rvMoedas;
    AdapterMod adapterMod;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_listagem, container, false);

        rvMoedas = layout.findViewById(R.id.rvMoedas);

        mMoedas = carregaMoedas();

        adapterMod = new AdapterMod(mMoedas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMoedas.setLayoutManager(layoutManager);

        rvMoedas.setHasFixedSize(true);

        rvMoedas.setAdapter(adapterMod);

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

        moedas.add(new Moeda(1, "bitcoin", 1, "BTC", true));
        moedas.add(new Moeda(2, "gabodes", 2, "GBS", false));

        return moedas;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}