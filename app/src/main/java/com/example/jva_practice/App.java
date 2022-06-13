package com.example.jva_practice;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;

import com.example.jva_practice.db.MainDBDataBase;

public class App extends Application {
    private static Context applicationContext;
    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext=this;
    }

    public static MainDBDataBase getMainDatabase(){
        return MainDBDataBase.getInstance(applicationContext);
    }
}
