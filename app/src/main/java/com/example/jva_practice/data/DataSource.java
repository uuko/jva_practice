package com.example.jva_practice.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;

public interface DataSource<T> {
    Observable<List<T>> getAll();

    Completable removeAll();

    Observable<List<T>> saveAll(List<T> list);

    Completable removeAll(List<T> list);

    Observable<T> save(T data);

    Observable<List<T>> getAll(Query<T> query);

    default Query<T> query(){
        return new Query<>(this);
    }
    class Query<T> {
        DataSource<T> t;

        public Query(DataSource<T> t) {
            this.t = t;
        }

        private  Map<String, String> params = new HashMap<>();

        public  Map<String, String> getParams() {
            return params;
        }

        public  Boolean has(String property) {
            return params.containsKey(property);
        }

        public  String get(String property) {
            return params.get(property);
        }

        public Query<?> where(String property, String value) {
            params.put(property, value);
            return this;
        }


        public Observable<List<T>> findAll() {
            return t.getAll(this);
        }

        public Observable<T> findFirst() {
            return t.getAll(this)
                    .filter(list -> !list.isEmpty())
                    .map(list -> list.get(0));
        }
    }
}
