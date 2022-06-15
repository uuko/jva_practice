package com.example.jva_practice.api;

import com.example.jva_practice.data.Users;
import com.example.jva_practice.data.posts.Posts;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface APIService {
    @GET("/users")
    Observable<List<Users>> getUsers();

// posts
    @GET("/posts")
    Observable<List<Posts>> getPostByUser(@Query("userId") String  userId);

    @POST("/posts")
    Observable<Posts> addPosts(@Body Posts posts);
}
