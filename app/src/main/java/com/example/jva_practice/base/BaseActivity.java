package com.example.jva_practice.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseActivity
        <T extends ViewDataBinding, VM extends ViewModel,VF extends ViewModelProvider.Factory>
        extends AppCompatActivity {

    public VM mViewModel;
    public T mViewBinding;
     public abstract Integer getLayoutId();
    public abstract Class<VM> getViewModel();
    public abstract VF getViewModelFactory();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mViewBinding = DataBindingUtil.setContentView(this, getLayoutId());
        mViewModel = new ViewModelProvider(this, getViewModelFactory()).get(getViewModel());
        mViewBinding.setLifecycleOwner(this);
        setContentView(mViewBinding.getRoot());
    }
}
