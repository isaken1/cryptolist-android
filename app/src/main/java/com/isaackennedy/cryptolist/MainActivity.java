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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        getMenuInflater().inflate(R.menu.action_bar_menu, menu);
//
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//
//        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);
//

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    class ListaAsyncTask extends AsyncTask<String, Void, String> {

        private Context context;

        public ListaAsyncTask(Context context){
            this.context = context;
        }


        @Override
        protected void onPreExecute(){
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings){

            String stringUrl = strings[0];

            InputStream inputStream = null;
            InputStreamReader inputStreamReader = null;

            StringBuffer buffer = null;

            int code;

            try{
                URL url = new URL(stringUrl);

                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestProperty("X-CMC_PRO_API_KEY", "187de20b-d1c9-45da-8af0-d7db39c64b79");
                connection.setRequestProperty("Accepts", "application/json");

                inputStream = connection.getInputStream();

                code = connection.getResponseCode();

                Toast.makeText(context, "Code: "+ code, Toast.LENGTH_SHORT).show();

                inputStreamReader = new InputStreamReader(inputStream);

                BufferedReader reader = new BufferedReader(inputStreamReader);

                buffer = new StringBuffer();

                String linha = "";

                while((linha = reader.readLine()) != null){
                    buffer.append(linha);
                }

            }catch(MalformedURLException e){
                e.printStackTrace();
            }catch(IOException e){
                e.printStackTrace();
            }

            return buffer.toString();
        }

        @Override
        protected void onProgressUpdate(Void... values){
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String resultado){

            super.onPostExecute(resultado);

            try {
                JSONObject jsonElement = new JSONObject(resultado);



            } catch (JSONException e) {
                e.printStackTrace();
            }


                //pra onde deve retornar??
        }



    public void clicouNaMoedaMod(Moeda moeda) {
        Intent it = new Intent(this, MoedaDetalheActivity.class);
        


        it.putExtra("moeda", moeda);
        startActivity(it);
    }
}