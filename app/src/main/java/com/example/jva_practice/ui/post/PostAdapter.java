package com.example.jva_practice.ui.post;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.jva_practice.R;
import com.example.jva_practice.data.posts.Posts;
import com.example.jva_practice.databinding.ItemPostBinding;
import com.example.jva_practice.db.post.PostTable;
import com.example.jva_practice.util.BindingViewHolder;
import com.example.jva_practice.util.DBUtils;

//
public class PostAdapter extends ListAdapter<PostTable, PostAdapter.PostViewHolder> {
    private PostViewModel viewModel;


    public PostAdapter(PostViewModel viewModel) {
        super(new DiffUtil.ItemCallback<PostTable>() {
            @Override
            public boolean areItemsTheSame(@NonNull PostTable oldItem, @NonNull PostTable newItem) {
                return oldItem.getId() == newItem.getId();
            }

            @Override
            public boolean areContentsTheSame(@NonNull PostTable oldItem, @NonNull PostTable newItem) {
                return oldItem.getId() == newItem.getId();
            }
        });
        this.viewModel = viewModel;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new PostViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_post,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        holder.binding.setPosts(DBUtils.toPosts(getItem(position)));
        holder.binding.setViewModel(viewModel);
    }

    public class PostViewHolder extends BindingViewHolder<ItemPostBinding> {
        public PostViewHolder(View view) {
            super(view);
        }
    }
}
