package com.example.jva_practice.ui.home;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainViewModelFactory implements ViewModelProvider.Factory {
    private MainRepository repository;

    public MainViewModelFactory(MainRepository mainRepository) {
        this.repository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainViewModel.class)) {
            return (T) new MainViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
