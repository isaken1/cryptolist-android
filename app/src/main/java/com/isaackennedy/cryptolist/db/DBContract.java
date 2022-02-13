package com.isaackennedy.cryptolist.db;

import android.provider.BaseColumns;

public final class DBContract {
    private DBContract() {};

    //Infos do BD
    public static final String DATABASE_NAME = "dbcryptolist";
    public static final int DATABASE_VERSION = 1;

    /* Classe interna para definir o conteúdo da tabela Moeda */
    public static class TabelaMoeda implements BaseColumns {

        private TabelaMoeda() {}
        public static final String TABLE_NAME = "moeda";
        public static final String NOME = "nomeMoeda";
        public static final String URL_IMG = "urlImg";
        public static final String URL = "urlMoeda";
        public static final String SIMBOLO = "simbolo";
        public static final String FAVORITADA = "favoritada";
        public static final String CAMINHO_IMAGEM = "caminhoImagem";
        public static final String RANK = "rank";
    }

    public static class TabelaUsuario implements BaseColumns {
        private TabelaUsuario() {}
        public static final String TABLE_NAME = "usuario";
        public static final String NOME = "nomeUsuario";
        public static final String EMAIL = "emailUsuario";
        public static final String NUMERO_MOEDAS_FAVORITADAS = "moedasFavoritadasUsuario";
    }

    //Criação de tabelas
    public static final String SQL_CRIAR_TABELAS =
            "CREATE TABLE " + TabelaMoeda.TABLE_NAME + " (" +
            BaseColumns._ID + " INTEGER PRIMARY KEY, " +
            TabelaMoeda.NOME + " TEXT, " +
            TabelaMoeda.URL_IMG + " TEXT, " +
            TabelaMoeda.URL + " TEXT, " +
            TabelaMoeda.SIMBOLO + " TEXT, " +
            TabelaMoeda.RANK + " INTEGER, " +
            TabelaMoeda.FAVORITADA + " BOOLEAN DEFAULT FALSE, " +
            TabelaMoeda.CAMINHO_IMAGEM + " TEXT);";


    public static final String SQL_TABELA_USUARIO =
            "CREATE TABLE " + TabelaUsuario.TABLE_NAME + " (" +
                    BaseColumns._ID + " INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
                    TabelaUsuario.NOME + " TEXT, " +
                    TabelaUsuario.EMAIL + " TEXT, " +
                    TabelaUsuario.NUMERO_MOEDAS_FAVORITADAS + " INTEGER);";

    //Deleção de tabelas
    public static final String SQL_DROPAR_TABELAS =
            "DROP TABLE IF EXISTS " + TabelaMoeda.TABLE_NAME +
            "DROP TABLE IF EXISTS " + TabelaUsuario.TABLE_NAME;

}
