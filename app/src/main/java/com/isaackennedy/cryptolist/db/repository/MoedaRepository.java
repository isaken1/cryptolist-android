package com.isaackennedy.cryptolist.db.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.isaackennedy.cryptolist.db.CryptoListRepository;
import com.isaackennedy.cryptolist.db.CryptoListSQLHelper;
import com.isaackennedy.cryptolist.model.Moeda;

import static com.isaackennedy.cryptolist.db.DBContract.TabelaMoeda.*;

import java.util.ArrayList;
import java.util.List;

public class MoedaRepository implements CryptoListRepository<Moeda> {

    private final CryptoListSQLHelper dbHelper;

    public MoedaRepository(Context context) { this.dbHelper = new CryptoListSQLHelper(context); }

    @Override
    public void inserir(Moeda entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(_ID, entidade.getId());
        cv.put(NOME, entidade.getNome());
        cv.put(URL_IMG, entidade.getUrlImagem());
        cv.put(URL, entidade.getUrl());
        cv.put(RANK, entidade.getRank());
        cv.put(SIMBOLO, entidade.getSimbolo());
        cv.put(CAMINHO_IMAGEM, entidade.getCaminhoImagem());

        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void atualizar(Moeda entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(NOME, entidade.getNome());
        cv.put(URL_IMG, entidade.getUrlImagem());
        cv.put(URL, entidade.getUrl());
        cv.put(RANK, entidade.getRank());
        cv.put(SIMBOLO, entidade.getSimbolo());
        cv.put(CAMINHO_IMAGEM, entidade.getCaminhoImagem());

        String selection = _ID + " = ?";
        String[] selectionArgs = { String.valueOf(entidade.getId()) };

        db.update(TABLE_NAME, cv, selection, selectionArgs);
    }

    @Override
    public void remover(Moeda entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = _ID + " = ?";
        String[] selectionArgs = { String.valueOf(entidade.getId()) };

        db.delete(TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public List<Moeda> listar() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + _ID;
        Cursor cursor = db.rawQuery(sql, null);

        List<Moeda> moedas = new ArrayList<>();

        while(cursor.moveToNext()) {
            Moeda m = entityFromCursor(cursor);
            moedas.add(m);
        }

        return moedas;
    }

    @Override
    public Moeda buscarPorId(long id) {
        return null;
    }

    public CryptoListSQLHelper getHelper() {
        return dbHelper;
    }

    @Override
    public Moeda entityFromCursor(Cursor cursor) {

        long id = cursor.getLong(cursor.getColumnIndexOrThrow(_ID));
        String url = cursor.getString(cursor.getColumnIndexOrThrow(URL));
        String urlImagem = cursor.getString(cursor.getColumnIndexOrThrow(URL_IMG));
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(NOME));
        Integer rank = cursor.getInt(cursor.getColumnIndexOrThrow(RANK));
        String simbolo = cursor.getString(cursor.getColumnIndexOrThrow(SIMBOLO));
        String caminhoImagem = cursor.getString(cursor.getColumnIndexOrThrow(CAMINHO_IMAGEM));
        boolean favoritada = cursor.getInt(cursor.getColumnIndexOrThrow(FAVORITADA)) > 0;

        return new Moeda(id, url, urlImagem, nome, caminhoImagem, rank, simbolo, favoritada);
    }
}
