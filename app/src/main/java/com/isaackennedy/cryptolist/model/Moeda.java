package com.isaackennedy.cryptolist.model;

import java.io.Serializable;
import java.time.ZonedDateTime;

/**
 * Classe que encapsula o modelo de uma criptomoeda
 */
public class Moeda implements Serializable {

    private String id;
    private String url;
    private String urlImagem;
    private String nome;
    private String caminhoImagem;
    private String simbolo;
    private Integer rank;
    private boolean favoritada;
    private float preco;
    private ZonedDateTime ultimaAtualizacao;

    public Moeda() {}

    public Moeda(String id, String nome, String simbolo) {
        this.id = id;
        this.nome = nome;
        this.simbolo = simbolo;
    }

    public Moeda(String id, String nome, Integer rank, String simbolo, boolean favoritada) {
        this.id = id;
        this.url = " ";
        this.urlImagem = " ";
        this.nome = nome;
        this.caminhoImagem = " ";
        this.rank = rank;
        this.simbolo = simbolo;
        this.favoritada = favoritada;
    }

    public Moeda(String id, String url, String urlImagem, String nome, String caminhoImagem, Integer rank, String simbolo, boolean favoritada) {
        this.id = id;
        this.url = url;
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.caminhoImagem = caminhoImagem;
        this.rank = rank;
        this.simbolo = simbolo;
        this.favoritada = favoritada;
    }

    public Moeda(String id, String url, String urlImagem, String nome, String simbolo, Integer rank, float preco, ZonedDateTime ultimaAtualizacao) {
        this.id = id;
        this.url = url;
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.simbolo = simbolo;
        this.rank = rank;
        this.preco = preco;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public Moeda(String id, String url, String urlImagem, String nome, String caminhoImagem, String simbolo, Integer rank, boolean favoritada, float preco, ZonedDateTime ultimaAtualizacao) {
        this.id = id;
        this.url = url;
        this.urlImagem = urlImagem;
        this.nome = nome;
        this.caminhoImagem = caminhoImagem;
        this.simbolo = simbolo;
        this.rank = rank;
        this.favoritada = favoritada;
        this.preco = preco;
        this.ultimaAtualizacao = ultimaAtualizacao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
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

    public Integer getRank() {
        return rank;
    }

    public void setRank(Integer rank) {
        this.rank = rank;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public ZonedDateTime getUltimaAtualizacao() {
        return ultimaAtualizacao;
    }

    public void setUltimaAtualizacao(ZonedDateTime ultimaAtualizacao) {
        this.ultimaAtualizacao = ultimaAtualizacao;
    }
}
