package com.example.uploadapirest.remote;

public class APIUtil {

    private static final String API_URL = "http://10.107.144.34/";

    public static ImageInterface getUsuarioInterface(){

        return RetrofitClient.getClient(API_URL)
                .create(ImageInterface.class);

    }


}
