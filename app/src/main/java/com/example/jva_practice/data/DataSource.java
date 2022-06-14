package com.example.jva_practice.data;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;

public interface DataSource<T> {
    Observable<List<T>> getAll();
    Completable removeAll();
    Observable<List<T>> saveAll(List<T> list);
    Completable removeAll(List<T> list);
}
