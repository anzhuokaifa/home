package app.android.com.recyclerveiw;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import app.android.com.recyclerveiw.adapter.MyAdapter;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private MyAdapter myAdapter;
    private GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //现在的列表模式
        linearLayoutManager = new LinearLayoutManager(this);
         recyclerView.setLayoutManager(linearLayoutManager);
        //先把ridLayoutManager创建出来
        gridLayoutManager = new GridLayoutManager(this,3);


        myAdapter = new MyAdapter();
        recyclerView.setAdapter(myAdapter);
    }


    public void onClick(View v) {
        //切换布局
        RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        //if和elseif是有先后顺序的,先判断范围小的,然后再判断范围大的,
        //因为GridLayoutManager 是继承 LinearLayoutManager ,所以他本质上也是LinearLayoutManager,
        //所以不能先判断是否是LinearLayoutManager (LinearLayoutManager范围大)
        if (layoutManager instanceof GridLayoutManager) {
            //listView的形式展示
            recyclerView.setLayoutManager(linearLayoutManager);
        } else if (layoutManager instanceof LinearLayoutManager) {
            // //gridview的形式展示
            recyclerView.setLayoutManager(gridLayoutManager);
        }
        //刷新，有没有刷新在格式转换里都一样
        // myAdapter.notifyDataSetChanged();
    }

}

