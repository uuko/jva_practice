package com.example.jva_practice.data.posts;

import android.util.Log;

import com.example.jva_practice.data.DataSource;
import com.example.jva_practice.data.DbData;
import com.example.jva_practice.db.post.PostDao;
import com.example.jva_practice.db.post.PostTable;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.Observer;

public class PostDbData implements DataSource<PostTable> {
    private final String TABLE_NAME = "posts";
    private PostDao dao;

    public PostDbData(PostDao dao) {
        this.dao = dao;
    }

    @Override
    public Observable<List<PostTable>> getAll() {
        return null;
    }

    @Override
    public Completable removeAll() {
        return null;
    }

    @Override
    public Observable<List<PostTable>> saveAll(List<PostTable> list) {
        Log.e("entities", "postTest:  Observable<List<PostTable>> saveAll" + list.size());
        return dao.insertAll(list)
                .andThen(Observable.just(list));
    }

    @Override
    public Completable removeAll(List<PostTable> list) {
        List<Integer> postList=new ArrayList<>();
        Log.e("onNext", "postTest ============ removeAll removeAll: ========"+list.size() );

        for (PostTable table:list){
//            Log.e("onNext", "postTest removeAll: "+table.getPkId() );
            postList.add(table.getPkId());
        }
//
        return dao.deleteAllById(postList);
    }

    @Override
    public Observable<PostTable> save(PostTable data) {
        List<PostTable> list = new ArrayList<>();
        list.add(data);
        return dao.insertAll(list)
                .andThen(Observable.just(data));
    }

    @Override
    public Observable<List<PostTable>> getAll(Query<PostTable> query) {
        return dao.rawQuery(
                DbData
                        .sqlWhere(TABLE_NAME, query.getParams()))
                .toObservable();
    }
}
