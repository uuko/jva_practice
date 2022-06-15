package com.example.jva_practice.ui.post;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jva_practice.ui.home.MainRepository;
import com.example.jva_practice.ui.home.MainViewModel;

public class PostViewModelFactory implements ViewModelProvider.Factory {
    private PostRepository repository;

    public PostViewModelFactory(PostRepository mainRepository) {
        this.repository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(PostViewModel.class)) {
            return (T) new PostViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}