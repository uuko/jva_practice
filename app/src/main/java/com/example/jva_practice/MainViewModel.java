package com.example.jva_practice;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.util.RetrofitManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainViewModel extends ViewModel {
    private MainRepository repository;

    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<String> imgUrl = new MutableLiveData<>("https://i.imgur.com/XeDINZZ.jpeg");

    public MutableLiveData<String> reallyName = new MutableLiveData<>();
    public MutableLiveData<String> aaa = new MutableLiveData<String>();

    public LiveData<Status<List<Users>>> statusMutableLiveData
            = Transformations.switchMap(
            aaa, new Function<String, LiveData<Status<List<Users>>>>() {
                @Override
                public LiveData<Status<List<Users>>> apply(String input) {
                    Log.e("setDataList", "getUsers: 1111111");
                    return repository.getUsers();
                }
            }
    );
    public MutableLiveData<List<Users>> ttt
            = new MutableLiveData<>();

    public void sayHello(String name) {
//        _name.postValue(name);
        repository.setTextStr(name);
        reallyName.setValue(repository.getTextStr().getValue());
    }


    private RetrofitManager manager = RetrofitManager.getInstance();


    public void getUsers(String name) {
        Log.e("setDataList", "getUsers: 0000000");
        aaa.setValue(name);


    }

    @Override
    protected void onCleared() {
        repository.disposeComposite();
        super.onCleared();
    }
}
