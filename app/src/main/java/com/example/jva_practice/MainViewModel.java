package com.example.jva_practice;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MainRepository repository;

    public MainViewModel(MainRepository repository) {
        this.repository = repository;
    }

    public MutableLiveData<String> imgUrl = new MutableLiveData<>("https://i.imgur.com/XeDINZZ.jpeg");

    public MutableLiveData<String> reallyName = new MutableLiveData<>();

    public void sayHello(String name) {
//        _name.postValue(name);
        repository.setTextStr(name);
        reallyName.setValue(repository.getTextStr().getValue());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
    }
}
