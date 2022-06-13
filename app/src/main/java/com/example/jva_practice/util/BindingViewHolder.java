package com.example.jva_practice.util;

import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;

public abstract class BindingViewHolder<T extends ViewDataBinding>
        extends RecyclerView.ViewHolder {
    public T binding;

    public BindingViewHolder(View view) {
        super(view);
        binding = DataBindingUtil.bind(view);
    }
}
