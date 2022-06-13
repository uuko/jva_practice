package com.example.jva_practice;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.db.MainDbMgr;
import com.example.jva_practice.util.DBUtils;
import com.example.jva_practice.util.RetrofitManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
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

    public MutableLiveData<Status<List<Users>>> getUserLiveData() {
        return userLiveData;
    }

    public void saveUsers(List<Users> usersList) {
        Log.e("MainRepository", "saveUsers: "+usersList.size() );
        MainDbMgr.getInstance()
                .insertSharesItemList(DBUtils.toMainTableList(usersList));
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
