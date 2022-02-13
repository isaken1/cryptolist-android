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
import androidx.recyclerview.widget.RecyclerView;

import com.isaackennedy.cryptolist.adapters.AdapterMod;
import com.isaackennedy.cryptolist.databinding.FragmentListagemBinding;
import com.isaackennedy.cryptolist.model.Moeda;

public class ListagemFragment extends Fragment {

    private ListagemViewModel listagemViewModel;
    private FragmentListagemBinding binding;
    private List<Moeda> mMoedas = new ArrayList<Moeda>();
    RecyclerView rvMoedas;
    AdapterMod adapterMod;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        listagemViewModel =
                new ViewModelProvider(this).get(ListagemViewModel.class);

        binding = FragmentListagemBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textHome;
        listagemViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}