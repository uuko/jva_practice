package com.example.jva_practice.data;

import com.example.jva_practice.api.APIService;

import com.example.jva_practice.util.RetrofitManager;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public class UserApiData implements DataSource<Users> {

    private APIService apiService = RetrofitManager.getInstance().getAPI();

    @Override
    public Observable<List<Users>> getAll() {
        return apiService.getUsers();
    }

    @Override
    public Completable removeAll() {
        return null;
    }

    @Override
    public Observable<List<Users>> saveAll(List<Users> list) {
        return null;
    }

    @Override
    public Completable removeAll(List<Users> list) {
        return null;
    }

    @Override
    public Observable<Users> save(Users data) {
        return null;
    }

    @Override
    public Observable<List<Users>> getAll(Query<Users> query) {
        return null;
    }


}
