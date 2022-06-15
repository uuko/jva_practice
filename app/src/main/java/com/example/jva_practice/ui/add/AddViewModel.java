package com.example.jva_practice.ui.add;

import android.util.Log;

import androidx.lifecycle.ViewModel;

import com.example.jva_practice.data.Repository;
import com.example.jva_practice.data.posts.Posts;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.db.post.PostTable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class AddViewModel extends ViewModel {
    private AddRepository repository;
    public AddViewModel(AddRepository repository) {
        this.repository=repository;
    }

    public void addPost(){
        Repository.of(PostTable.class)
                .save(new Posts(1,1,"A","aaaa"))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(new DisposableObserver() {
                    @Override
                    public void onNext(Object o) {
                        Log.e("addPost", "onNext: " );
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("addPost", "onError: "+e);
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
