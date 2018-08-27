package com.emansj.learnandtest;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.emansj.learnandtest.adapter.AdapterListProgress;
import com.emansj.learnandtest.model.Progress;

import java.util.List;
//Test ubah komen disini untuk lihat github
public class ListProgress extends AppCompatActivity {

    private View parent_view;
    private RecyclerView recyclerView;
    private AdapterListProgress mAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_progress);
        parent_view = findViewById(android.R.id.content);

        initComponent();
    }

    private void initComponent() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        List<Progress> items = Progress.getProgress(this);

        mAdapter = new AdapterListProgress(this, items);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new AdapterListProgress.OnItemClickListener() {
            @Override
            public void onItemClick(View view, Progress obj, int position) {
                Snackbar.make(parent_view, "Item " + obj.categoryName + " clicked", Snackbar.LENGTH_SHORT).show();
            }
        });
    }

}
