package com.example.jva_practice.ui.post;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.jva_practice.data.Repository;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.db.post.PostTable;
import com.example.jva_practice.util.Util;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PostRepository {


    private MutableLiveData<Status<List<PostTable>>> mutablePostLiveData = new MutableLiveData<>();

    public MutableLiveData<Status<List<PostTable>>> getMutablePostLiveData(){
        return mutablePostLiveData;
    }

    private CompositeDisposable disposable=new CompositeDisposable();
    public void disComposite(){
        disposable.dispose();
    }
    public MutableLiveData<Status<List<PostTable>>> getPostsByUserId(String userId) {
        Repository.of(PostTable.class).query()
                .where(Util.USER_ID, userId)
                .findAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<PostTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        disposable.add(d);
                    }

                    @Override
                    public void onNext(List<PostTable> users) {
                        Log.e("onNext", "postTest: " + users.size());
                        mutablePostLiveData.postValue(new Status<List<PostTable>>().success(users));
//
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.e("onNext", " postTest Throwable: " + e);
                        mutablePostLiveData.postValue(new Status<List<PostTable>>().error(e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });

        return mutablePostLiveData;
    }
}
