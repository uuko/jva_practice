package com.example.jva_practice.ui.add;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jva_practice.R;
import com.example.jva_practice.base.BaseFragment;
import com.example.jva_practice.databinding.FragmentAddBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link AddFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AddFragment extends BaseFragment<FragmentAddBinding, AddViewModel, AddViewModelFactory> {


    @Override
    public Integer getLayoutId() {
        return R.layout.fragment_add;
    }

    @Override
    public Class<AddViewModel> getViewModel() {
        return AddViewModel.class;
    }

    @Override
    public AddViewModelFactory getViewModelFactory() {
        return new AddViewModelFactory(new AddRepository());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.setLifecycleOwner(getViewLifecycleOwner());
        mViewBinding.setViewModel(mViewModel);
        super.onViewCreated(view, savedInstanceState);
    }
}