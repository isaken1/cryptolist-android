package com.isaackennedy.cryptolist.db;

import android.database.Cursor;

import java.util.List;

public interface CryptoListRepository<T> {
    /**
     * Insere uma entidade no banco.
     * @param entidade entidade a ser inserida.
     */
    void inserir(T entidade);

    /**
     * Atualiza uma entidade já existente no banco.
     * @param entidade entidade que será atualizada.
     */
    void atualizar(T entidade);

    /**
     * Remove uma entidade do banco.
     * @param entidade entidade que será removida.
     */
    void remover(T entidade);

    /**
     * Lista todas as entidades do tipo T do banco.
     * @return uma lista com todas as entidades deste tipo
     */
    List<T> listar();

    /**
     * Busca uma única entidade no banco, usando como filtro o ID da entidade.
     * @param id ID da entidade que será utilizada como parâmetro para a busca.
     * @return uma entidade cujo ID é o mesmo do parâmetro.
     */
    T buscarPorId(long id);

    /**
     * Retorna o helper, para que possa ser fechado ou feita alguma outra execução.
     * @return um objeto do tipo CryptoListSQLHelper
     */
    public CryptoListSQLHelper getHelper();

    /**
     * Extrai uma entidade de um cursor do banco.
     * @param cursor cursor do banco com resultados de consultas
     * @return Uma entidade extraída do cursor.
     */
    T entityFromCursor(Cursor cursor);
}
