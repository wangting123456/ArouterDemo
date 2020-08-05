package com.example.android.databind.databind_advance;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.databinding.BindingAdapter;
import androidx.databinding.BindingConversion;

import com.bumptech.glide.Glide;
import com.example.arouterdemo.R;

public class BindHelper {

    /**
     * 加载图片，无需手动调用次方法
     * 使用@BindingAdapter 注解设置自定义属性的名称，imageUrl就是属性的名称
     * 当ImageView使用属性imageUrl时，会自动调用loadImage方法
     * @param imageView
     * @param url
     */
    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView imageView,String url){
        Glide.with(imageView.getContext()).load(url)
                .error(R.drawable.ic_launcher_background)
                .into(imageView);
    }

    @BindingConversion
    public static Drawable convertStringtoDrawable(String str){
        if(str.equals("蓝色")){
            return new ColorDrawable(Color.parseColor("#3F51B5"));
        }
        return new ColorDrawable(Color.parseColor("#3F51B5"));
    }
}
