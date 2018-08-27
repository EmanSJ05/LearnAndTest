package com.emansj.learnandtest.model;

import android.content.Context;
import android.content.res.TypedArray;

import com.emansj.learnandtest.R;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Progress {

    public String categoryName;
    public String realPercent;

    public Progress() {

    }

    //Dummy data
    public static List<Progress> getProgress(Context ctx) {
        List<Progress> items = new ArrayList<>();

        //Map<String, Double> dataSet = new HashMap<>();
        //dataSet.put("Jaringan Irigasi Tertier", 99.95);
        String categoryName_arr[] = ctx.getResources().getStringArray(R.array.progress_data);
        String realPercent_arr[] = ctx.getResources().getStringArray(R.array.progress_realisasi);

        for (int i = 0; i < categoryName_arr.length; i++) {
            Progress obj = new Progress();
            obj.categoryName = categoryName_arr[i];
            obj.realPercent = realPercent_arr[i];
            items.add(obj);
        }
        Collections.shuffle(items);
        return items;
    }
}
