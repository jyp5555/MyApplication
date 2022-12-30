package com.example.myapplication;

import android.widget.ImageView;

import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;

public class MyBindingAdapter {
    @BindingAdapter("imageUrl")
    public static void loadImageUrl(ImageView view,String url){
        Glide.with(view.getContext()).load(url).into(view);
    }
}
