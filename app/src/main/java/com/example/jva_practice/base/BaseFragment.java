package com.example.jva_practice.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public abstract class BaseFragment
        <T extends ViewDataBinding, VM extends ViewModel,VF extends ViewModelProvider.Factory>
        extends Fragment
{
    public VM mViewModel;
    public T mViewBinding;
    public abstract Integer getLayoutId();
    public abstract Class<VM> getViewModel();
    public abstract VF getViewModelFactory();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(),container,false);
        mViewModel = new ViewModelProvider(this, getViewModelFactory()).get(getViewModel());
        mViewBinding.setLifecycleOwner(getViewLifecycleOwner());
        return mViewBinding.getRoot();
    }

//        override fun onAttach(context: Context) {
//        AndroidSupportInjection.inject(this)
//        super.onAttach(context)
//    }
}
