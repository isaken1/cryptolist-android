package com.isaackennedy.cryptolist.ui.perfil;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.isaackennedy.cryptolist.db.repository.UsuarioRepository;
import com.isaackennedy.cryptolist.model.Usuario;
import com.isaackennedy.cryptolist.R;

public class PerfilDialogFragment extends DialogFragment{

    public static final String DIALOG_TAG = "addDialog";
    private EditText etNome;
    private EditText etEmail;

    private Button btnSalvar;

    private Usuario usuario;

    public static PerfilDialogFragment novaInstancia(){
        PerfilDialogFragment perfilDialogFragment = new PerfilDialogFragment();
        return perfilDialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        UsuarioRepository uRepo = new UsuarioRepository(getContext());

        if(uRepo.listar().get(0) != null){
            this.usuario = uRepo.listar().get(0);
        } else {
            this.usuario = null;
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_perfil_dialog, container, false);

        etNome = layout.findViewById(R.id.etNome);
        etEmail = layout.findViewById(R.id.etEmail);

        

        btnSalvar = layout.findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                UsuarioRepository uRepo = new UsuarioRepository(getContext());

                if(nome.isEmpty() || email.isEmpty()){
                    return;
                }

                if(usuario == null){

                    usuario = new Usuario();
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    uRepo.inserir(usuario);
 
                } else {
                    usuario.setNome(nome);
                    usuario.setEmail(email);
                    uRepo.atualizar(usuario);
                }
            }
        });

        getDialog().setTitle("Editar Perfil");

        return layout;
    }

}
