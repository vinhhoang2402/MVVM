package com.example.recyclerview.Retrofit;

import com.example.recyclerview.Model.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API {
    @GET("posts")
    Call<List<Posts>> getPost();
}
