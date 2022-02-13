package com.isaackennedy.cryptolist.json;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.isaackennedy.cryptolist.model.Moeda;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ListagemGeralDeserialiazer implements JsonDeserializer<List<Moeda>> {

    private static final String LOG_TAG = "DESERIALIAZER";

    @Override
    public List<Moeda> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        if (json.isJsonNull() || !json.isJsonObject()) {
            String errorMessage = "Json nulo ou inválido.";
            Log.e(LOG_TAG, errorMessage);
            throw new JsonParseException(errorMessage);
        }

        List<Moeda> moedasDesserializadas = new ArrayList<>();

        try {
            JsonObject jsonObj = json.getAsJsonObject();
            JsonObject statusObj = jsonObj.getAsJsonObject("status");

            if (!statusObj.getAsJsonObject("error_code").isJsonNull()) {
                throw new JsonParseException("Requisição retornou o seguinte erro de API: "
                        + statusObj.getAsJsonPrimitive("error_code").getAsInt() + "\n"
                        + statusObj.getAsJsonPrimitive("error_message").getAsInt());
            }

            JsonObject data = jsonObj.getAsJsonObject("data");
            for (String key : data.keySet()) {
                JsonObject obj = data.get(key).getAsJsonObject();
                long id = obj.getAsJsonPrimitive("id").getAsLong();
                String nome = obj.getAsJsonPrimitive("nome").getAsString();
                String url = null;
                if (obj.getAsJsonArray("urls").size() > 0) {
                    url = obj.getAsJsonArray("urls").get(0).getAsString();
                }

                Integer rank = obj.getAsJsonPrimitive("rank").getAsInt();
                
                String urlImagem = obj.getAsJsonPrimitive("logo").getAsString();
                String simbolo = obj.getAsJsonPrimitive("symbol").getAsString();
                moedasDesserializadas.add(new Moeda(id, url, , nome, ));
            }

        } catch (JsonParseException ex) {
            Log.e(LOG_TAG, ex.getMessage());
            throw ex;
        }

        return moedasDesserializadas;
    }
}
