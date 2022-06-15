package com.example.jva_practice.data;

import android.util.Log;

import com.example.jva_practice.App;
import com.example.jva_practice.util.DBUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.CompletableSource;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;


public class Repo<Entity> implements DataSource<Entity> {
    DataSource<Entity> api;
    DataSource<Entity> db;

    public Repo(DataSource<Entity> api, DataSource<Entity> db) {
        this.api = api;
        this.db = db;
    }


    @Override
    public Observable<List<Entity>> getAll() {
        return Observable.concatArrayEager(
                db.getAll().subscribeOn(Schedulers.io()),
                Observable.defer(() -> {
                    if (App.isNetworkAvailable()) {
                        Log.e("onNext", "getAll:isNetworkAvailable ");
                        return api.getAll()
                                .flatMap(entities -> db.removeAll((List<Entity>) DBUtils.entityToList(entities))
                                        .andThen(db.saveAll((List<Entity>) DBUtils.entityToList(entities))))
                                .subscribeOn(Schedulers.io());
                    } else return Observable.empty();

                })

        );
    }

    @Override
    public Completable removeAll() {
        return Completable.defer(() -> {
            if (App.isNetworkAvailable()) {
                return api.removeAll()
                        .subscribeOn(Schedulers.io())
                        .andThen(db.removeAll());
            } else
                return Completable.error(
                        new IllegalAccessError("You are offline"));
        });
    }

    @Override
    public Observable<List<Entity>> saveAll(List<Entity> list) {

        return Observable.defer(() -> {

            if (App.isNetworkAvailable()) {
                return api
                        .saveAll(list)
                        .subscribeOn(Schedulers.io())
                        .flatMap(new Function<List<Entity>, ObservableSource<? extends List<Entity>>>() {
                            @Override
                            public ObservableSource<? extends List<Entity>> apply(List<Entity> entities) throws Exception {
                                return db.saveAll(list);
                            }
                        });

            } else
                return Observable.error(new IllegalAccessError("You are offline"));

        });
    }

    @Override
    public Completable removeAll(List<Entity> list) {
        return Completable.defer(() -> {
            if (App.isNetworkAvailable()) {
                return api.removeAll(list)
                        .subscribeOn(Schedulers.io())
                        .andThen(db.removeAll(list));
            } else
                return Completable.error(
                        new IllegalAccessError("You are offline"));
        });
    }

    @Override
    public Observable<Entity> save(Entity data) {
        if (App.isNetworkAvailable()) {

            return api
                    .save(data)
                    .subscribeOn(Schedulers.io())
                    .flatMap(new Function<Entity, ObservableSource<? extends Entity>>() {
                        @Override
                        public ObservableSource<? extends Entity> apply(Entity entity) throws Exception {
                            return db.save((Entity) DBUtils.entityToTable(entity));
                        }
                    });

        } else
            return Observable.error(new IllegalAccessError("You are offline"));

    }

    @Override
    public Observable<List<Entity>> getAll(Query<Entity> query) {
        return Observable.concatArrayEager(
                db.getAll(query).subscribeOn(Schedulers.io()),
                Observable.defer(() -> {
                    if (App.isNetworkAvailable()) {
                        return api.getAll(query)
                                .flatMap(
                                        entities ->
                                                db.getAll(query)
                                                        .flatMapCompletable(old -> {
                                                            Log.e("postTest", "db.getAll(query): "+old.size() );
                                                           return db.removeAll((List<Entity>) DBUtils.entityToList(old));
                                                        })
                                                        .andThen(db.saveAll((List<Entity>) DBUtils.entityToList(entities))))
                                .subscribeOn(Schedulers.io());

//
                    } else return Observable.empty();

                })
        );
    }
}


