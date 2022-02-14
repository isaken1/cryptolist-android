package com.isaackennedy.cryptolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

import com.isaackennedy.cryptolist.model.Moeda;
import com.isaackennedy.cryptolist.ui.detalhe.MoedaDetalheFragment;

public class MoedaDetalheActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moeda_detalhe);

        Intent it = getIntent();

        //Recupera o dado que veio na intent
        Moeda moeda = (Moeda) it.getExtras().getSerializable("moeda");




        MoedaDetalheFragment moedaDetalheFragment = MoedaDetalheFragment.novaInstancia(moeda);

        //2 Exibir o fragmento (coloca-lo no layout)

        //2.1 Fragment Manager - gerenciador de fragmentos
        FragmentManager fm = getSupportFragmentManager();

        //2.2 Fragment Transaction - adiciona ou troca um fragmento
        FragmentTransaction ft = fm.beginTransaction();

        //(layout onde será exibido o fragment - id, passar a instancia do fragment, a TAG)
        ft.replace(R.id.detalhe,moedaDetalheFragment,MoedaDetalheFragment.TAG_DETALHE);
        ft.commit();
    }
}