package com.example.jva_practice.api;

import com.example.jva_practice.data.Users;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface APIService {
    @GET("/users")
    Observable<List<Users>> getUsers();


}
