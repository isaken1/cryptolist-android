package com.isaackennedy.cryptolist.ui.favoritas;

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
import com.isaackennedy.cryptolist.databinding.FragmentFavoritasBinding;
import com.isaackennedy.cryptolist.db.repository.MoedaRepository;
import com.isaackennedy.cryptolist.model.Moeda;

import java.util.ArrayList;
import java.util.List;

public class FavoritasFragment extends Fragment {

    private FavoritasViewModel favoritasViewModel;
    private FragmentFavoritasBinding binding;

    private List<Moeda> mMoedas = new ArrayList<Moeda>();
    private RecyclerView rvMoedasFavoritas;
    private AdapterMod adapterMod;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View layout = inflater.inflate(R.layout.fragment_listagem, container, false);

        rvMoedasFavoritas = layout.findViewById(R.id.rvMoedas);

        mMoedas = carregarMoedas();

        adapterMod = new AdapterMod(mMoedas);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
        rvMoedasFavoritas.setLayoutManager(layoutManager);

        rvMoedasFavoritas.setHasFixedSize(true);

        rvMoedasFavoritas.setAdapter(adapterMod);

        return layout;
    }

    private List<Moeda> carregarMoedas() {
        List<Moeda> moedas = new ArrayList<>();

        MoedaRepository mRepo = new MoedaRepository(getActivity().getApplicationContext());

        for(Moeda m : mRepo.listar()){
            if(m.isFavoritada()){
                moedas.add(m);
            }
        }

        return moedas;
    }

    @Override
    public void onStart(){
        super.onStart();
        this.mMoedas = carregarMoedas();
        this.adapterMod = new AdapterMod(mMoedas);
        rvMoedasFavoritas.setAdapter(adapterMod);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        binding = null;
    }
}