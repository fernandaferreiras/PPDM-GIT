package com.example.cadastro_symbian.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.16:3000/";

    public  static RouterInterface getUsuarioInterface(){

        return RetrofitClient.getClient(API_URL)
                .create(RouterInterface.class);

    }

}
