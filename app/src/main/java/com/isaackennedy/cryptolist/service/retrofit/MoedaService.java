package com.isaackennedy.cryptolist.service.retrofit;

import com.isaackennedy.cryptolist.model.Moeda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoedaService {

    @GET("list")
    Call<List<Moeda>> getMoedas();

}
