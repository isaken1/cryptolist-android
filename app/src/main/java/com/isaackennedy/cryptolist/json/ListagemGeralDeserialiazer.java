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
            JsonArray jsonArr = json.getAsJsonArray();

            for (JsonElement el : jsonArr) {
                JsonObject obj = el.getAsJsonObject();
                String id = obj.getAsJsonPrimitive("id").getAsString();
                String nome = obj.getAsJsonPrimitive("name").getAsString();

                String simbolo = obj.getAsJsonPrimitive("symbol").getAsString();
                moedasDesserializadas.add(new Moeda(id, nome, simbolo));
            }

        } catch (JsonParseException ex) {
            Log.e(LOG_TAG, ex.getMessage());
            throw ex;
        }

        return moedasDesserializadas;
    }
}