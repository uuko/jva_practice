package com.example.jva_practice.ui.add;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jva_practice.ui.post.PostRepository;
import com.example.jva_practice.ui.post.PostViewModel;

public class AddViewModelFactory implements ViewModelProvider.Factory {
    private AddRepository repository;

    public AddViewModelFactory(AddRepository mainRepository) {
        this.repository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(AddViewModel.class)) {
            return (T) new AddViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
