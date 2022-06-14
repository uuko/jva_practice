package com.example.jva_practice.db;

import android.util.Log;

import com.example.jva_practice.App;

import java.util.List;

import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class UserDbMgr {
    private static UserDbMgr instance;
    private final String TAG = "[AlertDBMgr]";
    CompositeDisposable mDisposable = new CompositeDisposable();
    private MainDBDataBase database = App.getMainDatabase();

    public static UserDbMgr getInstance() {
        if (instance == null) {
            instance = new UserDbMgr();
        }
        return instance;
    }


    public CompositeDisposable getmDisposable() {
        return mDisposable;
    }

    public void updateSharesItem(UserTable entity) {

//        mDisposable.add(database.userDbDao().updateUsers(entity)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new Action() {
//                    @Override
//                    public void run() throws Exception {
//
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                }));
    }


    public void insertSharesItemList(List<UserTable> entity) {

        Log.e("MainRepository", "insertSharesItem: ");
        mDisposable.add(database.userDbDao().insertAllPrivateData(entity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("MainRepository Action", "insertSharesItem: ");

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("MainRepository dbbbb", "insertSharesItem: " + throwable);

                    }
                }));
    }

    public void loadAllSharedDataByQbeeID(int QbeeID) {

        database.userDbDao().loadAllSharedDataByQbeeID(QbeeID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<UserTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<UserTable> sharedEntityList) {
                        Log.e("MainDbMgr loadAll", "onSuccess: ");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MainDbMgr loadAll", "onError: ");

                    }
                });


    }

    public void deleteSharedData(UserTable entity) {

        mDisposable.add(database.userDbDao().deleteUsers(entity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("MainDbMgr dbbbb", "onDeleteComplete: ");

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Log.d("MainDbMgr dbbbb", "onDeleteaccept: ");

                    }
                }));
    }

}