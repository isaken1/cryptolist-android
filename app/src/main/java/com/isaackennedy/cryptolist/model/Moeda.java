package com.isaackennedy.cryptolist.model;

/**
 * Classe que encapsula o modelo de uma criptomoeda
 */
public class Moeda {
    private long id;
    private String url;
    private String urlImagem;
    private String nome;
    private String caminhoImagem;
    private String simbolo;
    private boolean favoritada;

    public Moeda(long id, String url, String urlImagem, String nome, String simbolo) {
        this.id = id;
        this.url = url;
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.simbolo = simbolo;
        this.favoritada = false;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCaminhoImagem() {
        return caminhoImagem;
    }

    public void setCaminhoImagem(String caminhoImagem) {
        this.caminhoImagem = caminhoImagem;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }

    public boolean isFavoritada() {
        return favoritada;
    }

    public void setFavoritada(boolean favoritada) {
        this.favoritada = favoritada;
    }
}
