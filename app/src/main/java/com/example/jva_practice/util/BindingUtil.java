package com.example.jva_practice.util;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

public class BindingUtil {
    @BindingAdapter(("imageUrl"))
    public static void loadImageUrl(ImageView view ,  String url) {
       if (!url.isEmpty()){
           ViewUtil.loadEclipseImage(view,url);
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
//    @BindingAdapter(value = ["bookmarks", "viewModel"])
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
