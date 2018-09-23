package com.example.android.tflitecamerademo;

import android.content.Context;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

public class FlowersActivity extends Activity {


    RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private List<Flower> flowerList;

    class Flower {
        Context context;
        int name;
        int content;
        int photoId;
        int link;

        Flower(Context context, int name, int content, int photoId, int link) {
            this.context = context;
            this.name = name;
            this.content = content;
            this.photoId = photoId;
            this.link = link;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flowers);


        recyclerView = findViewById(R.id.rvAja);
        LinearLayoutManager llm = new LinearLayoutManager(FlowersActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(llm);
        initializeData();

        mAdapter = new RVAdapter(FlowersActivity.this, flowerList);
        recyclerView.setAdapter(mAdapter);
    }

    private void initializeData(){
        flowerList = new ArrayList<>();
        flowerList.add(new Flower(FlowersActivity.this,
                R.string.j_daisy,
                R.string.k_daisy,
                R.drawable.daisy,
                R.string.w_daisy));
        flowerList.add(new Flower(FlowersActivity.this,
                R.string.j_dandelion,
                R.string.k_dandelion,
                R.drawable.dandelion,
                R.string.w_dandelion));
        flowerList.add(new Flower(FlowersActivity.this,
                R.string.j_roses,
                R.string.k_roses,
                R.drawable.roses,
                R.string.w_roses));
        flowerList.add(new Flower(FlowersActivity.this,
                R.string.j_sunflowers,
                R.string.k_sunflowers,
                R.drawable.sunflowers,
                R.string.w_roses));
        flowerList.add(new Flower(FlowersActivity.this,
                R.string.j_tulips,
                R.string.k_tulips,
                R.drawable.tulips,
                R.string.w_tulips));
    }

}
