package com.isaackennedy.cryptolist.service;

import com.isaackennedy.cryptolist.model.Moeda;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface MoedaService {

    @Headers(
            { "X-CMC_PRO_API_KEY: 187de20b-d1c9-45da-8af0-d7db39c64b79",
                    "Accepts: 'application/json"
            }
    )
    @GET("/map")
    Call<List<Moeda>> getMoedas();

    @GET("/info?id={id}")
    Call<Moeda> getMoedaInfo(@Path("id") int id);
}
