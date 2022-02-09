package com.isaackennedy.cryptolist.model;

import java.util.List;

public class Resposta {
    private final String resposta;
    private final String mensagem;
    private List<Moeda> data;
    private final int type;

    public Resposta(String resposta, String mensagem, List<Moeda> data, int type) {
        this.resposta = resposta;
        this.mensagem = mensagem;
        this.data = data;
        this.type = type;
    }

    public String getResposta() {
        return resposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<Moeda> getData() {
        return data;
    }

    public int getType() {
        return type;
    }
}
