package com.example.jva_practice.util;

import android.util.Size;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jva_practice.MainAdapter;
import com.example.jva_practice.MainViewModel;
import com.example.jva_practice.data.Status;
import com.example.jva_practice.data.Users;

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

        MainAdapter adapter = new MainAdapter(items, viewModel);
        view.setAdapter(
            adapter
        );
        adapter.notifyDataSetChanged();
    }
//    fun setBookmarks(view: RecyclerView, datas: List<Users>, vm: HomeViewModel) {
////    val llm = LinearLayoutManager(this)
////    llm.orientation = LinearLayoutManager.VERTICAL
//        val items = datas?: arrayListOf()
//        view.adapter?.run {
//            Log.e("setBookmarks", "setBookmarks: aaaaaaaaa")
//            if (this is HomeAdapter) this.submitList(items)
//        } ?: run {
//            Log.e("setBookmarks", "setBookmarks: bbbbbbbbbb")
//            HomeAdapter(vm).apply {
//                view.adapter = this
//                this.submitList(items)
//            }
//        }
//    }
}
