package com.example.jva_practice.ui.home;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.jva_practice.R;
import com.example.jva_practice.base.BaseFragment;
import com.example.jva_practice.databinding.FragmentMainBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MainFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MainFragment extends BaseFragment<FragmentMainBinding, MainViewModel, MainViewModelFactory> {

    @Override
    public Integer getLayoutId() {
        return R.layout.fragment_main;
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
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.setLifecycleOwner(getViewLifecycleOwner());
        mViewBinding.setViewModel(mViewModel);
        super.onViewCreated(view, savedInstanceState);
    }
}