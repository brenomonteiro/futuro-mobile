package com.example.futuro.model;

public class Aluno {
    private String nome;
    private String cpf;
    private String Sala;
    private String Email;
    private String Senha;


    public Aluno() {
    }

    public Aluno(String nome, String cpf, String sala) {
        this.nome = nome;
        this.cpf = cpf;
        Sala = sala;
    }
    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getSenha() {
        return Senha;
    }

    public void setSenha(String senha) {
        Senha = senha;
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
