package com.emansj.learnandtest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class RvMainActivity extends AppCompatActivity {

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rv_main);

        // Initializing list view with the custom adapter
        ArrayList <Item> itemList = new ArrayList<Item>();

        ItemArrayAdapter itemArrayAdapter = new ItemArrayAdapter(R.layout.rv_list_item, itemList);
        recyclerView = (RecyclerView) findViewById(R.id.item_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(itemArrayAdapter);

        // Populating list items
        for(int i=0; i<100; i++) {
            itemList.add(new Item("Item " + i));
        }

    }

}