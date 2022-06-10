package com.example.cadastro_symbian.remote;

import com.example.cadastro_symbian.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    @POST("/usuario/cadastrarUsuario")
    Call<Usuario> addUsuario(@Body Usuario usuario);

}
