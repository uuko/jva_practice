package com.example.jva_practice.ui.home;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jva_practice.R;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.databinding.ItemMainBinding;
import com.example.jva_practice.util.BindingViewHolder;

import java.util.ArrayList;
import java.util.List;

public class MainAdapter extends
        RecyclerView.Adapter<MainAdapter.BookmarkViewHolder> {

    private MainViewModel viewModel;
    private List<Users> dataList = new ArrayList<>();

    public MainAdapter( MainViewModel viewModel) {

        this.viewModel = viewModel;
    }

    public void setDataList(List<Users> dataList){
        Log.e("setDataList", "setDataList: "+dataList.size() );
        this.dataList=dataList;
        notifyDataSetChanged();
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
//        Log.e("setDataList", "onBindViewHolder: "+dataList.get(position).getEmail() );

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
