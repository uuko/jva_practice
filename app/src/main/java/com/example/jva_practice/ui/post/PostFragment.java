package com.example.jva_practice.ui.post;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jva_practice.R;
import com.example.jva_practice.base.BaseFragment;
import com.example.jva_practice.data.navigation.NavigationDestination;
import com.example.jva_practice.databinding.FragmentPostBinding;


public class PostFragment extends BaseFragment<FragmentPostBinding, PostViewModel, PostViewModelFactory> {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public Integer getLayoutId() {
        return R.layout.fragment_post;
    }

    @Override
    public Class<PostViewModel> getViewModel() {
        return PostViewModel.class;
    }

    @Override
    public PostViewModelFactory getViewModelFactory() {
        return new PostViewModelFactory(new PostRepository());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        mViewBinding.setLifecycleOwner(this);
        mViewBinding.setViewModel(mViewModel);
        int queryData = getArguments().getInt("mUserId");
        mViewModel.setQueryData(String.valueOf(queryData));

        Log.e("onViewCreated", "onViewCreated: " + getArguments().getInt("mUserId"));

        mViewModel.destination.observe(getViewLifecycleOwner(), new Observer<NavigationDestination>() {
            @Override
            public void onChanged(NavigationDestination navigationDestination) {
                if (navigationDestination != null) {
                    if (navigationDestination.equals(NavigationDestination.NAVIGATION_DESTINATION_ADD_POSTING)) {
                        Navigation.findNavController(mViewBinding.getRoot()).navigate(R.id.action_postFragment_to_addFragment);
                    }
                }

            }
        });
        super.onViewCreated(view, savedInstanceState);
    }


}