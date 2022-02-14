package com.isaackennedy.cryptolist;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.gson.JsonElement;
import com.isaackennedy.cryptolist.databinding.ActivityMainBinding;
import com.isaackennedy.cryptolist.model.Moeda;
import com.isaackennedy.cryptolist.json.ListagemGeralDeserialiazer;
import com.isaackennedy.cryptolist.model.Moeda;
import com.isaackennedy.cryptolist.service.retrofit.CoinDetailInitializer;
import com.isaackennedy.cryptolist.service.retrofit.CoinListInitializer;
import com.isaackennedy.cryptolist.service.retrofit.MoedaDetalheService;
import com.isaackennedy.cryptolist.service.retrofit.MoedaService;
import com.isaackennedy.cryptolist.ui.listagem.ListagemFragment;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity implements ListagemFragment.AoClicarNaMoedaMod {

    private ActivityMainBinding binding;

    public List<Moeda> moedas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_perfil, R.id.navigation_listagem, R.id.navigation_favoritas)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.action_bar_menu, menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);

        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);


        return true;
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }


    public void clicouNaMoedaMod(Moeda moeda) {
        Intent it = new Intent(this, MoedaDetalheActivity.class);

//        Moeda[] m = new Moeda[1];

//        MoedaDetalheService service = new CoinDetailInitializer().coinDetailService() ;
//
//        Call<Moeda> chamada = service.getDetalhesMoeda(moeda.getId());
//
//        chamada.enqueue(new Callback<Moeda>(){
//
//            @Override
//            public void onResponse(Call<Moeda> call, Response<Moeda> response){
//
//                m[0] = response.body();
//
////                rvMoedas.notify();
//
//
//            }
//
//            @Override
//            public void onFailure(Call<Moeda> call, Throwable t){
//
//            }
//        });

        it.putExtra("moeda", moeda);
        startActivity(it);

    }
}
