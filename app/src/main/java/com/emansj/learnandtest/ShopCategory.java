package com.emansj.learnandtest;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;

import java.util.ArrayList;
import java.util.List;

public class ShopCategory {

    public int image;
    public Drawable imageDrw;
    public String title;
    public String brief;
    public int image_bg;

    public ShopCategory() {
    }

    public static List<ShopCategory> getShoppingCategory(Context ctx) {
        List<ShopCategory> items = new ArrayList<>();
        TypedArray drw_arr = ctx.getResources().obtainTypedArray(R.array.shop_category_icon);
        TypedArray drw_arr_bg = ctx.getResources().obtainTypedArray(R.array.shop_category_bg);
        String title_arr[] = ctx.getResources().getStringArray(R.array.shop_category_title);
        String brief_arr[] = ctx.getResources().getStringArray(R.array.shop_category_brief);
        for (int i = 0; i < drw_arr.length(); i++) {
            ShopCategory obj = new ShopCategory();
            obj.image = drw_arr.getResourceId(i, -1);
            obj.image_bg = drw_arr_bg.getResourceId(i, -1);
            obj.title = title_arr[i];
            obj.brief = brief_arr[i];
            obj.imageDrw = ctx.getResources().getDrawable(obj.image);
            items.add(obj);
        }
        return items;
    }

}
