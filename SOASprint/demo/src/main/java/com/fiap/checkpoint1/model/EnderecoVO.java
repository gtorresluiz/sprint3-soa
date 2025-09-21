package com.fiap.checkpoint1.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class EnderecoVO {
    private String rua;
    private String cidade;
    private String cep;

    public EnderecoVO() {}

    public EnderecoVO(String rua, String cidade, String cep) {
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }
}
