package com.example.jva_practice;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.jva_practice.base.BaseActivity;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.databinding.ActivityMainBinding;

import java.util.List;

import io.reactivex.functions.Action;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainViewModel, MainViewModelFactory> {

    @Override
    public Integer getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainViewModel> getViewModel() {
        return MainViewModel.class;
    }

    @Override
    public MainViewModelFactory getViewModelFactory() {
        return new MainViewModelFactory(new MainRepository());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding.setViewModel(mViewModel);
//        mViewModel.mLoading.observe(this, new Observer<Boolean>() {
//            @Override
//            public void onChanged(Boolean aBoolean) {
//                Log.e("onChanged", "onChanged: "+aBoolean );
//            }
//        });
    }

//    private void handleAction(@NonNull final Action action) {
//        switch (action.getValue()){
//            case Action.SHOW_WELCOME:
//                //show Activity.
//                break;
//            case Action.SHOW_INVALID_PASSWARD_OR_LOGIN:
//                //show Toast
//                break;
//        }
//    }
}