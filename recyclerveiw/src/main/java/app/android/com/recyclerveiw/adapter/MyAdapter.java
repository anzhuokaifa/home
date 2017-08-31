package app.android.com.recyclerveiw.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import app.android.com.recyclerveiw.R;

/**
 * Created by Administrator on 2017/8/31 0031.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>{

    private List<String> list;

    public MyAdapter(){
        list = new ArrayList<>();
        for (int i = 0 ; i<30 ;i++){
             list.add("条目"+i);
        }

     }

    //创建布局和viewHolder
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View recyclerView = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_layout, null);
        return new MyViewHolder(recyclerView);
    }
    //绑定数据
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.title.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

      ImageView icon;
      TextView title;

        //findviewById 给控件绑定id
        public MyViewHolder(View itemView) {
            super(itemView);
            icon = (ImageView) itemView.findViewById(R.id.icon);
            title= (TextView) itemView.findViewById(R.id.title);
        }
    }

}
