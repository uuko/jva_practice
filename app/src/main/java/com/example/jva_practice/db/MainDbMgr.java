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

public class MainDbMgr {
    private static MainDbMgr instance;
    private final String TAG = "[AlertDBMgr]";
    CompositeDisposable mDisposable = new CompositeDisposable();
    private MainDBDataBase database = App.getMainDatabase();

    public static MainDbMgr getInstance() {
        if (instance == null) {
            instance = new MainDbMgr();
        }
        return instance;
    }


    public CompositeDisposable getmDisposable() {
        return mDisposable;
    }

    public void updateSharesItem(MainTable entity) {

        mDisposable.add(database.mainDbDao().updateUsers(entity)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action() {
                    @Override
                    public void run() throws Exception {

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {

                    }
                }));
    }


    public void insertSharesItemList(List<MainTable> entity) {

        Log.e("MainRepository", "insertSharesItem: ");
        mDisposable.add(database.mainDbDao().insertAllPrivateData(entity)
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

        database.mainDbDao().loadAllSharedDataByQbeeID(QbeeID)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<MainTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable.add(d);
                    }

                    @Override
                    public void onSuccess(List<MainTable> sharedEntityList) {
                        Log.e("MainDbMgr loadAll", "onSuccess: ");

                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e("MainDbMgr loadAll", "onError: ");

                    }
                });


    }

    public void deleteSharedData(MainTable entity) {

        mDisposable.add(database.mainDbDao().deleteUsers(entity)
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