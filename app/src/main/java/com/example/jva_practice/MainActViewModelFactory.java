package com.example.jva_practice;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.jva_practice.ui.home.MainRepository;
import com.example.jva_practice.ui.home.MainViewModel;

public class MainActViewModelFactory implements ViewModelProvider.Factory {
    private MainActRepository repository;

    public MainActViewModelFactory(MainActRepository mainRepository) {
        this.repository = mainRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(MainActViewModel.class)) {
            return (T) new MainActViewModel(repository);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
