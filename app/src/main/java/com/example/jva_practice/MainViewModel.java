package com.example.jva_practice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;

import java.util.List;

public class MainViewModel extends ViewModel {
    private MainRepository repository;

    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<String> imgUrl = new MutableLiveData<>("https://i.imgur.com/XeDINZZ.jpeg");

    public MutableLiveData<String> reallyName = new MutableLiveData<>();

    public MutableLiveData<Status<List<Users>>> statusMutableLiveData
            = new MutableLiveData<>();
    public MutableLiveData<List<Users>> ttt
            = new MutableLiveData<>();
    public void sayHello(String name) {
//        _name.postValue(name);
        repository.setTextStr(name);
        reallyName.setValue(repository.getTextStr().getValue());
    }


    public void getUsers() {
        repository.getUsers();
        statusMutableLiveData.postValue(repository.getUserLiveData().getValue());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
