package com.isaackennedy.cryptolist.model;

import java.util.List;

public class RespostaAPI {
    private final String resposta;
    private final String mensagem;
    private final List<Moeda> dados;
    private final int type;

    public RespostaAPI(String resposta, String mensagem, List<Moeda> data, int type) {
        this.resposta = resposta;
        this.mensagem = mensagem;
        this.dados = data;
        this.type = type;
    }

    public String getResposta() {
        return resposta;
    }

    public String getMensagem() {
        return mensagem;
    }

    public List<Moeda> getData() {
        return dados;
    }

    public int getType() {
        return type;
    }
}
