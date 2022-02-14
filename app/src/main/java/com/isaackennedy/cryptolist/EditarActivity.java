package com.isaackennedy.cryptolist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.isaackennedy.cryptolist.db.repository.UsuarioRepository;
import com.isaackennedy.cryptolist.model.Usuario;

public class EditarActivity extends AppCompatActivity {

    private Button btnSalvar;

    private EditText etNome;
    private EditText etEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar);

        etNome = findViewById(R.id.etNome);
        etEmail = findViewById(R.id.etEmail);


        btnSalvar = findViewById(R.id.btnSalvar);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = etNome.getText().toString();
                String email = etEmail.getText().toString();
                UsuarioRepository uRepo = new UsuarioRepository(getApplicationContext());

                if(nome.isEmpty() || email.isEmpty()){
                    return;
                }

                Usuario u = new Usuario();
                if(uRepo.listar().size() == 0){
                    u.setNome(nome);
                    u.setEmail(email);
                    uRepo.inserir(u);
                } else{
                    u = uRepo.listar().get(0);
                    u.setEmail(email);
                    u.setNome(nome);
                    uRepo.atualizar(u);
                }

                finish();

            }
        });

    }
}