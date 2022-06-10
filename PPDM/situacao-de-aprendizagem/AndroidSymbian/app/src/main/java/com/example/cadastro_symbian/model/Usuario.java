package com.example.cadastro_symbian.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Usuario {

    @SerializedName("cod_usuario")
    @Expose
    private int cod_usuario;

    @SerializedName("nome")
    @Expose
    private String nome;

    @SerializedName("sobrenome")
    @Expose
    private String sobrenome;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("celular")
    @Expose
    private String celular;


    public Usuario(int cod_usuario, String nome, String sobrenome, String email, String celular) {
        this.cod_usuario = cod_usuario;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.email = email;
        this.email = celular;

    }

    public Usuario() {

    }

    public int getCod_usuario() {
        return cod_usuario;
    }

    public void setCod_usuario(int cod_usuario) {
        this.cod_usuario = cod_usuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
