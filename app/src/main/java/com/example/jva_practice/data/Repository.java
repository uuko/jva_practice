package com.example.jva_practice.data;

import com.example.jva_practice.App;



import java.util.List;
import java.util.concurrent.Callable;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class Repository<Entity> {


    public static Repo of(Class<?> c) {
        return new Repo
                (ApiData.of(c), DbData.of(c));
    }

    public static Completable clearDatabase() {
        return Completable.fromAction(
                DbData::clearDb
        ).subscribeOn(Schedulers.io());
    }
}

