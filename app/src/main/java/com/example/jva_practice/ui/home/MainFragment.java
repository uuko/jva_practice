package com.example.jva_practice.ui.home;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import com.example.jva_practice.R;
import com.example.jva_practice.base.BaseFragment;
import com.example.jva_practice.data.navigation.NavigationDestination;
import com.example.jva_practice.databinding.FragmentMainBinding;


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

        mViewModel.destination.observe(getViewLifecycleOwner(), new Observer<NavigationDestination>() {
            @Override
            public void onChanged(NavigationDestination navigationDestination) {
                Log.e("MainFragment", "mViewModel.destination onChanged: "+navigationDestination );
                if (navigationDestination != null) {
                    if (navigationDestination.equals(NavigationDestination.NAVIGATION_DESTINATION_POST)) {
                        Bundle bundle = new Bundle();
                        bundle.putInt("mUserId", mViewModel.mUserId.getValue());
                        Navigation.findNavController(mViewBinding.getRoot()).navigate(R.id.action_mainFragment_to_postFragment, bundle);
                        mViewModel.navigationComplete();
                    }
                }

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }
}