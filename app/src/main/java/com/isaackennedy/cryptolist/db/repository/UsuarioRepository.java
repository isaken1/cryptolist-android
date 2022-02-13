package com.isaackennedy.cryptolist.db.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.isaackennedy.cryptolist.db.CryptoListRepository;
import com.isaackennedy.cryptolist.db.CryptoListSQLHelper;
import com.isaackennedy.cryptolist.model.Usuario;

import static com.isaackennedy.cryptolist.db.DBContract.TabelaUsuario.*;

import java.util.ArrayList;
import java.util.List;


public class UsuarioRepository implements CryptoListRepository<Usuario> {
     private final CryptoListSQLHelper dbHelper;

    public UsuarioRepository(Context context) { this.dbHelper = new CryptoListSQLHelper(context); }

    @Override
    public void inserir(Usuario entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();
        cv.put(NOME, entidade.getNome());
        cv.put(EMAIL, entidade.getEmail());
        cv.put(NUMERO_MOEDAS_FAVORITADAS, entidade.getNumeroMoedasFavoritas());

        db.insert(TABLE_NAME, null, cv);
    }

    @Override
    public void atualizar(Usuario entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(_ID, entidade.getId());
        cv.put(NOME, entidade.getNome());
        cv.put(NOME, entidade.getNome());

        String selection = _ID + " = ?";
        String[] selectionArgs = { String.valueOf(entidade.getId()) };

        db.update(TABLE_NAME, cv, selection, selectionArgs);
    }

    @Override
    public void remover(Usuario entidade) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        String selection = _ID + " = ?";
        String[] selectionArgs = { String.valueOf(entidade.getId()) };

        db.delete(TABLE_NAME, selection, selectionArgs);
    }

    @Override
    public List<Usuario> listar() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String sql = "SELECT * FROM " + TABLE_NAME + " ORDER BY " + _ID;
        Cursor cursor = db.rawQuery(sql, null);

        List<Usuario> usuarios = new ArrayList<>();

        while(cursor.moveToNext()) {
            Usuario m = entityFromCursor(cursor);
            usuarios.add(m);
        }

        return usuarios;
    }

    @Override
    public Usuario buscarPorId(long id) {
        return null;
    }

    public CryptoListSQLHelper getHelper() {
        return dbHelper;
    }

    @Override
    public Usuario entityFromCursor(Cursor cursor) {

        long id = cursor.getLong(cursor.getColumnIndexOrThrow(_ID));
        String nome = cursor.getString(cursor.getColumnIndexOrThrow(NOME));
        String email = cursor.getString(cursor.getColumnIndexOrThrow(EMAIL));
        Integer numMoedas = cursor.getInt(cursor.getColumnIndexOrThrow(NUMERO_MOEDAS_FAVORITADAS));

        return new Usuario(id, nome, email, numMoedas);
    }
}
