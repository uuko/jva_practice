package com.example.jva_practice.util;

import android.widget.ImageView;

import androidx.constraintlayout.widget.Placeholder;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

public class ViewUtil {


    public static void loadEclipseImage(ImageView view, String url) {

        CircularProgressDrawable loader = new
                CircularProgressDrawable(view.getContext());
        loader.setStrokeWidth(5);
        loader.setCenterRadius(30);
        loader.start();


        RequestOptions option = new RequestOptions()
                .placeholder(loader)
                .error(android.R.drawable.ic_delete)
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)
                .circleCrop();

        try {
            Glide.with(view.getContext())
                    .setDefaultRequestOptions(option)
                    .load(url)
                    .into(view);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
