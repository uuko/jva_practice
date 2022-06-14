package com.example.jva_practice;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.jva_practice.data.Repository;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.db.UserDbMgr;
import com.example.jva_practice.db.UserTable;
import com.example.jva_practice.util.DBUtils;
import com.example.jva_practice.util.RetrofitManager;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainRepository {

    private CompositeDisposable compositeDisposable = new CompositeDisposable();
    private MutableLiveData<String> textStr = new MutableLiveData<>("hello");
    //    MutableLiveData<String>
    private RetrofitManager manager = RetrofitManager.getInstance();

    public void setTextStr(String name) {
        textStr.postValue(name);
    }

    public MutableLiveData<String> getTextStr() {
        return textStr;
    }

    private final MutableLiveData<Status<List<Users>>>
            userLiveData = new MutableLiveData<Status<List<Users>>>
            ();
    private MutableLiveData<Boolean> mLoading=new MutableLiveData<Boolean>(false);


    public MutableLiveData<Status<List<Users>>> getUserLiveData() {
        return userLiveData;
    }
    public MutableLiveData<Boolean> getLoading() {
        return mLoading;
    }

    public void saveUsers(List<Users> usersList) {
        Log.e("MainRepository", "saveUsers: " + usersList.size());
        UserDbMgr.getInstance()
                .insertSharesItemList(DBUtils.toUserTableList(usersList));
    }

    public MutableLiveData<Status<List<Users>>> getAllUsers() {

//        mLoading.setValue(true);
        Repository.of(UserTable.class).getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UserTable>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        compositeDisposable.add(d);
                    }

                    @Override
                    public void onNext(List<UserTable> users) {
                        Log.e("onNext", "onNext: " + users.size());
//                        mLoading.setValue(false);
                        userLiveData.postValue(new Status<List<Users>>().success(DBUtils.toUsersList(users)));
                    }


                    @Override
                    public void onError(Throwable e) {
                        Log.e("onNext", "Throwable: " + e);
//                        mLoading.setValue(false);
                        userLiveData.postValue(new Status<List<Users>>().error(e.getMessage()));
                    }

                    @Override
                    public void onComplete() {

                    }
                });
      return userLiveData;


    }

    public MutableLiveData<Status<List<Users>>> getUsers() {
        compositeDisposable
                .add(manager.getAPI()
                        .getUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableObserver<List<Users>>() {
                            @Override
                            public void onNext(List<Users> users) {
                                Log.e("setDataList", "onNext userLiveData: ");

                                userLiveData.postValue(new Status<List<Users>>().success(users));
                            }

                            @Override
                            public void onError(Throwable e) {
                                userLiveData.postValue(new Status<List<Users>>().error(e.getMessage()));
                            }

                            @Override
                            public void onComplete() {

                            }
                        }));
        return userLiveData;
    }

    public void disposeComposite() {
        compositeDisposable.dispose();
    }
}
