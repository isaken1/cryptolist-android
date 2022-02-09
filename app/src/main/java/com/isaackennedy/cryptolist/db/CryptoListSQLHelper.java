package com.isaackennedy.cryptolist.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CryptoListSQLHelper extends SQLiteOpenHelper {

    public CryptoListSQLHelper(Context context) {
        super(context, DBContract.DATABASE_NAME, null, DBContract.DATABASE_VERSION);
    }

    // Ao criar o banco, gerar tabelas.
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBContract.SQL_CRIAR_TABELAS);
    }

    /* Por simplicidade, ao fazer atualização ou reverter uma versão do banco, simplesmente
    * o mesmo será dropado e refeito, o que causará perda dos dados das moedas. */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DBContract.SQL_DROPAR_TABELAS);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }


}
