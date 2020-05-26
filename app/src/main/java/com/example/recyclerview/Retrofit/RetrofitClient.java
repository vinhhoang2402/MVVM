package com.example.recyclerview.Retrofit;

import com.example.recyclerview.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    public static final String baseUrl="http://192.168.43.122/comitApp/";
    private API postInterface;
    private static RetrofitClient instance;
    public RetrofitClient(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        postInterface=retrofit.create(API.class);

    }

    public static RetrofitClient getInstance() {
        if(null==instance)
            instance=new RetrofitClient();
        return instance;
    }

    public Call<List<Posts>> getPost(){
        return postInterface.getPost();
    }

}