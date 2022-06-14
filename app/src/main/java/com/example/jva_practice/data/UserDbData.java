package com.example.jva_practice.data;

import android.util.Log;

import com.example.jva_practice.db.UserDbDao;
import com.example.jva_practice.db.UserTable;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.Observable;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class UserDbData implements DataSource<UserTable> {
    private UserDbDao userDbDao;

    public UserDbData(UserDbDao userDbDao) {
        this.userDbDao = userDbDao;
    }

    @Override
    public Observable<List<UserTable>> getAll() {
//          .toObservable()
//        return

//         userDbDao.getAll()
//
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new SingleObserver<List<UserTable>>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onSuccess(List<UserTable> userTables) {
//                        Log.e("onNext", "onSubscribe: "+userTables.size() );
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        Log.e("onNext", "onError: "+e );
//
//                    }
//                })
//                ;
        return userDbDao.getAll().toObservable();
    }

    @Override
    public Completable removeAll() {
        return Completable
                .fromAction(() -> userDbDao.deleteAll());
    }

    @Override
    public Observable<List<UserTable>> saveAll(List<UserTable> list) {
        return userDbDao.insertAll(list)
                .andThen(Observable.just(list));
    }

    @Override
    public Completable removeAll(List<UserTable> list) {
        return userDbDao.deleteAll();
    }


}
