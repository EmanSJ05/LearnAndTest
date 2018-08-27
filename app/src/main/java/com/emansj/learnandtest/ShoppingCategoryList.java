package com.emansj.learnandtest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import java.util.List;

public class ShoppingCategoryList extends AppCompatActivity {

    private View parent_view;

    private RecyclerView recyclerView;
    private AdapterListShopCategory mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_category_list);
        parent_view = findViewById(R.id.parent_view);

        initComponent();
    }

    private void initComponent() {
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        recyclerView.setNestedScrollingEnabled(false);

        //List<ShopCategory> items = DataGenerator.getShoppingCategory(this);
        List<ShopCategory> items = ShopCategory.getShoppingCategory(this);

        //set data and list adapter
        mAdapter = new AdapterListShopCategory(this, items);
        recyclerView.setAdapter(mAdapter);

        // on item list clicked
        mAdapter.setOnItemClickListener(new AdapterListShopCategory.OnItemClickListener() {
            @Override
            public void onItemClick(View view, ShopCategory obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.title + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });

    }

    public void onButtonTabClick(View v) {

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        } else {
            Toast.makeText(getApplicationContext(), item.getTitle(), Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
