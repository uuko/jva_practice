package com.example.jva_practice;

import androidx.annotation.Nullable;

import android.os.Bundle;

import com.example.jva_practice.base.BaseActivity;
import com.example.jva_practice.databinding.ActivityMainBinding;
import com.example.jva_practice.ui.home.MainRepository;
import com.example.jva_practice.ui.home.MainViewModel;
import com.example.jva_practice.ui.home.MainViewModelFactory;

public class MainActivity extends BaseActivity<ActivityMainBinding, MainActViewModel, MainActViewModelFactory> {

    @Override
    public Integer getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public Class<MainActViewModel> getViewModel() {
        return MainActViewModel.class;
    }

    @Override
    public MainActViewModelFactory getViewModelFactory() {
        return new MainActViewModelFactory(new MainActRepository());
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding.setViewModel(mViewModel);

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