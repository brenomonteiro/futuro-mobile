package com.example.futuro.model;

public class Aluno {
    private String nome;
    private String cpf;
    private String Sala;

    public Aluno() {
    }

    public Aluno(String nome, String cpf, String sala) {
        this.nome = nome;
        this.cpf = cpf;
        Sala = sala;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSala() {
        return Sala;
    }

    public void setSala(String sala) {
        Sala = sala;
    }
}
