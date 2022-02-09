package com.isaackennedy.cryptolist.db;

public final class DBConstants {
    private DBConstants() {};

    //Infos do BD
    private static final String DATABASE_NAME = "dbcryptolist";
    private static final int DATABASE_VERSION = 1;

    //Tabela Moeda V1
    private static final String MOEDA_TABLE_NAME = "moeda";
    private static final String MOEDA_ID = "_id";
    private static final String MOEDA_NAME = "nomeMoeda";
    private static final String MOEDA_URL_IMG = "caminhoImg";
    private static final String MOEDA_URL = "urlMoeda";
    private static final String MOEDA_SIMBOLO = "simboloMoeda";
    private static final String MOEDA_FAVORITADA = "favoritadaMoeda";


    //SQL de criação da tabela moeda
    private static final String SQL_CRIAR_TABELA_MOEDAS =
            "CREATE TABLE " + MOEDA_TABLE_NAME + " (" +
            MOEDA_ID + "INTEGER PRIMARY KEY, " +
            MOEDA_NAME + " TEXT, " +
            MOEDA_URL_IMG + " TEXT, " +
            MOEDA_URL + " TEXT, " +
            MOEDA_SIMBOLO + " TEXT, " +
            MOEDA_FAVORITADA + " BOOLEAN DEFAULT FALSE)";

}
