package com.isaackennedy.cryptolist.service.retrofit;

import com.isaackennedy.cryptolist.model.Moeda;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

interface MoedaDetalheService {

  @GET("{id}?localization=false&tickers=false&market_data=true&community_data=false&developer_data=false")
  Call<Moeda> getDetalhesMoeda(@Path("id")String id);
}
