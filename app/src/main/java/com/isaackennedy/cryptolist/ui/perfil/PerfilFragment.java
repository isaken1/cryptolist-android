package com.isaackennedy.cryptolist.ui.perfil;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.isaackennedy.cryptolist.EditarActivity;
import com.isaackennedy.cryptolist.R;
import com.isaackennedy.cryptolist.databinding.FragmentPerfilBinding;
import com.isaackennedy.cryptolist.db.repository.UsuarioRepository;
import com.isaackennedy.cryptolist.model.Usuario;

public class PerfilFragment extends Fragment{

    private PerfilViewModel perfilViewModel;
    private FragmentPerfilBinding binding;

    private Button btnEditar;

    private  TextView tvNome;
    private TextView tvEmail;
    private  TextView tvNumMoedas;

    private Usuario u;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        perfilViewModel =
                new ViewModelProvider(this).get(PerfilViewModel.class);

        binding = FragmentPerfilBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tvNome = binding.tvNomeUsuario;
        tvEmail = binding.tvEmail;
        tvNumMoedas = binding.tvNumMoedas;

        carregarUsuario();

        this.btnEditar = binding.btnEditar;
        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(getActivity().getApplicationContext(), EditarActivity.class);
                it.putExtra("usuario", u);
                startActivity(it);
            }
        });


        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    private void carregarUsuario(){
        UsuarioRepository uRepo = new UsuarioRepository(getActivity().getApplicationContext());
        try{
            this.u = uRepo.listar().get(0);
            this.tvNome.setText(u.getNome());
            this.tvEmail.setText(u.getEmail());
            this.tvNumMoedas.setText(u.getNumeroMoedasFavoritas().toString());
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        carregarUsuario();
    }
}