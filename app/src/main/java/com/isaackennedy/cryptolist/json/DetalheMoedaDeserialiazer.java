package com.isaackennedy.cryptolist.json;

import android.util.Log;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.isaackennedy.cryptolist.model.Moeda;

import java.lang.reflect.Type;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class DetalheMoedaDeserialiazer implements JsonDeserializer<Moeda> {
   private static final String LOG_TAG = "DESERIALIAZER";

   @Override
   public Moeda deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
      if (json.isJsonNull() || !json.isJsonObject()) {
         String errorMessage = "Json nulo ou inválido.";
         Log.e(LOG_TAG, errorMessage);
         throw new JsonParseException(errorMessage);
      }

      Moeda moeda = null;

      try {
         JsonArray jsonArr = json.getAsJsonArray();

         for (JsonElement el : jsonArr) {
            JsonObject obj = el.getAsJsonObject();
            String id = obj.getAsJsonPrimitive("id").getAsString();
            String nome = obj.getAsJsonPrimitive("name").getAsString();
            String simbolo = obj.getAsJsonPrimitive("symbol").getAsString();
            String url = obj.getAsJsonObject("links")
                    .getAsJsonArray("homepage").get(0).getAsString();

            String urlImagem = obj.getAsJsonObject("image")
                    .getAsJsonPrimitive("large").getAsString();

            int rank = obj.getAsJsonPrimitive("coingecko_rank").getAsInt();
            float preco = obj.getAsJsonObject("market_data").getAsJsonObject("current_price")
                    .getAsJsonPrimitive("brl").getAsFloat();

            ZonedDateTime ultimaAtualizacao = ZonedDateTime.now();

            moeda = new Moeda(id, url, urlImagem, nome, simbolo, rank, preco, ultimaAtualizacao);
         }

      } catch (JsonParseException ex) {
         Log.e(LOG_TAG, ex.getMessage());
         throw ex;
      }

      return moeda;
   }
}
