package com.example.jva_practice.ui.home;

import android.util.Log;

import androidx.arch.core.util.Function;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Transformations;
import androidx.lifecycle.ViewModel;

import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MainRepository repository;

    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<String> getUsersChangeRepo = new MutableLiveData<String>();


    public LiveData<Status<List<Users>>> statusMutableLiveData
            = Transformations.switchMap(
            getUsersChangeRepo, new Function<String, LiveData<Status<List<Users>>>>() {
                @Override
                public LiveData<Status<List<Users>>> apply(String input) {
                    Log.e("setDataList", "getUsers: 1111111");
                    return repository.getAllUsers();
                }
            }
    );
    private final MutableLiveData<Boolean> _mLoading
            = new MutableLiveData<>(false);
    public MutableLiveData<Boolean> mLoading
            = _mLoading;

    public void getAllUsers() {
        getUsersChangeRepo.setValue("");

        _mLoading.setValue(repository.getLoading().getValue());
    }


    @Override
    protected void onCleared() {
        repository.disposeComposite();
        super.onCleared();
    }


    //------------------------

//    public MutableLiveData<String> imgUrl = new MutableLiveData<>("https://i.imgur.com/XeDINZZ.jpeg");
//
//    public MutableLiveData<String> reallyName = new MutableLiveData<>();
//    public MutableLiveData<String> getUsersChange = new MutableLiveData<String>();
    //    public LiveData<Status<List<Users>>> statusMutableLiveData
//            = Transformations.switchMap(
//            getUsersChange, new Function<String, LiveData<Status<List<Users>>>>() {
//                @Override
//                public LiveData<Status<List<Users>>> apply(String input) {
//                    Log.e("setDataList", "getUsers: 1111111");
//                    return repository.getUsers();
//                }
//            }
//    );
//    public void sayHello(String name) {
////        _name.postValue(name);
//        repository.setTextStr(name);
//        reallyName.setValue(repository.getTextStr().getValue());
//    }
//
//
//    public void getUsers(String name) {
//        Log.e("setDataList", "getUsers: 0000000");
//        getUsersChange.setValue(name);
//
//
//    }
//
//
//    public void saveUsers(LiveData<Status<List<Users>>> data) {
//        if (data.getValue() != null) {
//            repository.saveUsers(Objects.requireNonNull(data.getValue()).data);
//
//        }
//    }
}
