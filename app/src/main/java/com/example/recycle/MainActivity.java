package com.example.recycle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recycler_view;
    private MyAdapter adapter;
    private ArrayList<String> mData=new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //準備資料,塞50個項目到ArrayList裡
        for(int i=0;i<50;i++)
        {
            mData.add("項目"+i);
        }
        //連結元件
        recycler_view=(RecyclerView) findViewById(R.id.recycle_view);
        //設置RecyclerView為列表型態
        recycler_view.setLayoutManager(new LinearLayoutManager(this));
        // Linear型態，第二個參數控制垂直或水平，第三個參數為是否reverse順序
//        recycler_view.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
////         Grid型態，第二個參數控制一列顯示幾項
//        recycler_view.setLayoutManager(new GridLayoutManager(this, 2));
        //設置隔線
        recycler_view.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        //將資料交給adapter
        adapter=new MyAdapter(mData);
        //設置adapter給recycler_view
        recycler_view.setAdapter(adapter);

        findViewById(R.id.btnAdd).setOnClickListener(view->{
            adapter.addItem("New Item");
        });

    }


}