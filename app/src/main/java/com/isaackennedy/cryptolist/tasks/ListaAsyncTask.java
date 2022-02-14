package com.isaackennedy.cryptolist.tasks;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.JsonElement;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ListaAsyncTask extends AsyncTask<String, Void, String> {

//     private Context context;
// 
//     public ListaAsyncTask(Context context){
//         this.context = context;
//     }
//
//
//     @Override
//     protected void onPreExecute(){
//         super.onPreExecute();
//     }
//
//     @Override
//     protected String doInBackground(String... strings){
//
//         String stringUrl = strings[0];
//
//         InputStream inputStream = null;
//         InputStreamReader inputStreamReader = null;
//
//         StringBuffer buffer = null;
//
//         int code;
//
//         try{
//             URL url = new URL(stringUrl);
//
//             HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//             connection.setRequestProperty("X-CMC_PRO_API_KEY", "187de20b-d1c9-45da-8af0-d7db39c64b79");
//             connection.setRequestProperty("Accepts", "application/json");
//
//             inputStream = connection.getInputStream();
//
//             code = connection.getResponseCode();
//
//             Toast.makeText(context, "Code: "+ code, Toast.LENGTH_SHORT).show();
//
//             inputStreamReader = new InputStreamReader(inputStream);
//
//             BufferedReader reader = new BufferedReader(inputStreamReader);
//
//             buffer = new StringBuffer();
//
//             String linha = "";
//
//             while((linha = reader.readLine()) != null){
//                 buffer.append(linha);
//             }
//
//         }catch(MalformedURLException e){
//             e.printStackTrace();
//         }catch(IOException e){
//             e.printStackTrace();
//         }
//
//         return buffer.toString();
//     }
//
//     @Override
//     protected void onProgressUpdate(Void... values){
//         super.onProgressUpdate(values);
//     }
//
//     @Override
//     protected void onPostExecute(String resultado){
//
//         super.onPostExecute(resultado);
//
//         try {
//             JSONObject jsonElement = new JSONObject(resultado);
//
//
//
//         } catch (JSONException e) {
//             e.printStackTrace();
//         }
//
//
//             //pra onde deve retornar??
//     }



}
