package com.isaackennedy.cryptolist.service.retrofit;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.isaackennedy.cryptolist.json.DetalheMoedaDeserialiazer;
import com.isaackennedy.cryptolist.model.Moeda;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinDetailInitializer {
   public final Gson gson = new GsonBuilder()
           .registerTypeAdapter(Moeda.class, new DetalheMoedaDeserialiazer()).create();

   private final Retrofit retrofit = new Retrofit.Builder()
           .baseUrl("https://api.coingecko.com/api/v3/coins/")
           .addConverterFactory(GsonConverterFactory.create(gson))
           .build();

   public MoedaDetalheService coinDetailService() {
      return retrofit.create(MoedaDetalheService.class);
   }
}
