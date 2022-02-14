package com.isaackennedy.cryptolist.service.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isaackennedy.cryptolist.json.ListagemGeralDeserialiazer;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinListInitializer {

    public final Gson gson = new GsonBuilder()
            .registerTypeAdapter(List.class, new ListagemGeralDeserialiazer()).create();

    private final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.coingecko.com/api/v3/coins/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    public MoedaService coinListService() {
        return retrofit.create(MoedaService.class);
    }
}
