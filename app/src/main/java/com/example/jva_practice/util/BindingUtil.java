package com.example.jva_practice.util;

import android.util.Log;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.example.jva_practice.data.posts.Posts;
import com.example.jva_practice.db.post.PostTable;
import com.example.jva_practice.ui.home.MainAdapter;
import com.example.jva_practice.ui.home.MainViewModel;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;
import com.example.jva_practice.ui.post.PostAdapter;
import com.example.jva_practice.ui.post.PostViewModel;

import java.util.ArrayList;
import java.util.List;

public class BindingUtil {
    @BindingAdapter(("imageUrl"))
    public static void loadImageUrl(ImageView view, String url) {
        if (!url.isEmpty()) {
            ViewUtil.loadEclipseImage(view, url);
        }
    }

    //    // Function : for load image from id into ImageView
//    @BindingAdapter(("drawableId"))
//    fun loadImageId(view: ImageView, id: Int?) {
//        id?.let { view.loadImage(id) }
//    }
//    @BindingAdapter("refreshing")
//    fun SwipeRefreshLayout.refreshing(visible: Boolean) {
//        isRefreshing = visible
//    }
//
    @BindingAdapter("refreshing")
    public static void refreshing(SwipeRefreshLayout view,
                                  Boolean visible) {
        view.setRefreshing(visible);
    }

    @BindingAdapter({"bookmarks", "viewModel"})
    public static void setBookmarks(RecyclerView view, Status<List<Users>> status, MainViewModel viewModel) {

        List<Users> items = new ArrayList<>();
        if (status != null) {
            if (status.status == Status.StatusType.SUCCESS) {
                for (Object u : status.data) {
                    items.add((Users) u);
                }
            }
        }

        MainAdapter adapter = new MainAdapter( viewModel);
        view.setAdapter(
            adapter
        );
        adapter.setDataList(items);
    }
    @BindingAdapter({"posts", "viewModel"})
    public static void setPosts(RecyclerView view, Status<List<PostTable>> status, PostViewModel viewModel) {

        List<PostTable> items = new ArrayList<>();
        if (status != null) {
            if (status.status == Status.StatusType.SUCCESS) {
                for (Object u : status.data) {
                    items.add((PostTable) u);
                }
            }
        }

        Log.e("postTest", "setPosts: "+items.size() );
        PostAdapter adapter = new PostAdapter( viewModel);
        view.setAdapter(
                adapter
        );
        adapter.submitList(items);
    }
}
