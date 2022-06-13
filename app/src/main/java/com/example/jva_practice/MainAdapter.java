package com.example.jva_practice;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jva_practice.data.Users;
import com.example.jva_practice.databinding.ItemMainBinding;
import com.example.jva_practice.util.BindingViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends
        RecyclerView.Adapter<MainAdapter.BookmarkViewHolder> {

    private MainViewModel viewModel;
    private List<Users> dataList = new ArrayList<>();

    public MainAdapter(List<Users> dataList, MainViewModel viewModel) {
        this.dataList=dataList;
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public BookmarkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new BookmarkViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_main,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull BookmarkViewHolder holder, int position) {

        holder.binding.setUser(dataList.get(position));
        holder.binding.setViewModel(viewModel);
//        getItem(position)
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }


    public static class BookmarkViewHolder extends BindingViewHolder<ItemMainBinding> {
        public BookmarkViewHolder(View view) {
            super(view);
        }

    }

    private DiffUtil.ItemCallback<Users> DIFF_CALLBACK = new DiffUtil.ItemCallback<Users>() {
        @Override
        public boolean areItemsTheSame(@NonNull Users oldItem, @NonNull Users newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Users oldItem, @NonNull Users newItem) {
            return true;
        }
    };

}
