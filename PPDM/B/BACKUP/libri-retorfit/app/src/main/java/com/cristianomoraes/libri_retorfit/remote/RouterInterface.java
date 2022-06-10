package com.cristianomoraes.libri_retorfit.remote;

import com.cristianomoraes.libri_retorfit.model.Livro;
import com.cristianomoraes.libri_retorfit.model.Usuario;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RouterInterface {

    /** ROTA DE INSERÇÃO DE USUÁRIO **/
    @POST("/usuario/cadastrarUsuario")
    Call<Usuario> addUsuario(@Body Usuario usuario);

    /** ROTA DE INSERÇÃO DE LIVROS **/
    @POST("/livro/cadasrarLivro")
    Call<Livro> addLivro(@Body Livro livro);


}
