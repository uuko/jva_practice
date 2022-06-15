package com.example.jva_practice.data.posts;

import static com.example.jva_practice.util.Util.USER_ID;

import android.util.Log;

import com.example.jva_practice.api.APIService;
import com.example.jva_practice.data.DataSource;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.util.RetrofitManager;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class PostApiData implements DataSource<Posts> {
    private APIService apiService = RetrofitManager.getInstance().getAPI();

    @Override
    public Observable<List<Posts>> getAll() {
        return null;
    }

    @Override
    public Completable removeAll() {
        return null;
    }

    @Override
    public Observable<List<Posts>> saveAll(List<Posts> list) {
        return null;
    }

    @Override
    public Completable removeAll(List<Posts> list) {
        return null;
    }

    @Override
    public Observable<Posts> save(Posts data) {
        return apiService.addPosts(data);
    }

    @Override
    public Observable<List<Posts>> getAll(Query<Posts> query) {
        if (query!=null){
            if (query.has(USER_ID)){
               if (!query.get(USER_ID).isEmpty()){

                   apiService.getPostByUser(query.get(USER_ID))
                           .observeOn(Schedulers.io())
                           .subscribe(new Consumer<List<Posts>>() {
                               @Override
                               public void accept(List<Posts> posts) throws Exception {
                                   Log.e("entities", "getAll: "+posts.size());
                               }
                           }, new Consumer<Throwable>() {
                               @Override
                               public void accept(Throwable throwable) throws Exception {

                               }
                           });
                   return apiService.getPostByUser(query.get(USER_ID));
               }
            }
        }
        else throw  new IllegalArgumentException(
                "Unsupported query is Null for PostEntity"
        );

         throw  new IllegalArgumentException(
                "Unsupported query is "+query+" for PostEntity"
        );
    }
}
