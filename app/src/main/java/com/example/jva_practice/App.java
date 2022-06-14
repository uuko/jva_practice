package com.example.jva_practice;

import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.jva_practice.db.MainDBDataBase;

public class App extends Application {
    private static Context applicationContext;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = this;
    }

    public static Boolean isNetworkAvailable() {
        ConnectivityManager cm = (ConnectivityManager) applicationContext
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) {
            return false;
        } else {
            NetworkInfo[] info = cm.getAllNetworkInfo();
            for (NetworkInfo networkInfo : info) {
                if (networkInfo.getState() == NetworkInfo.State.CONNECTED) {
                    return true;
                }
            }
        }
        return false;
    }

    public static MainDBDataBase getMainDatabase() {
        return MainDBDataBase.getInstance(applicationContext);
    }
}
