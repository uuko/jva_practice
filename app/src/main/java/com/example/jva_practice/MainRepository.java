package com.example.jva_practice;

import androidx.lifecycle.MutableLiveData;

public class MainRepository {

    private MutableLiveData<String> textStr=new MutableLiveData<>("hello");
//    MutableLiveData<String>
    public void setTextStr(String name){
        textStr.postValue(name);
    }

    public MutableLiveData<String> getTextStr(){
        return textStr;
    }
}
