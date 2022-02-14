package com.isaackennedy.cryptolist.model;

import java.io.Serializable;

public class Usuario implements Serializable {

    private Long id;
    private String nome;
    private String email;
    private Integer numeroMoedasFavoritas=0;

    public Usuario(){
        super();
    }

    public Usuario(Long id, String nome, String email, Integer numMoedas){
        super();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.numeroMoedasFavoritas = numMoedas;
    }

    public String getNome(){
        return this.nome;
    }

    public Long getId(){
        return this.id;
    }


    public String getEmail(){
        return this.email;
    }

    public Integer getNumeroMoedasFavoritas(){
        return this.numeroMoedasFavoritas;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setNumeroMoedasFavoritas(Integer n){
        numeroMoedasFavoritas = n;
    }

    public void setId(Long n){
        id = n;
    }

}
