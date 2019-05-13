package com.bawei.jiangbingbing20190513.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.jiangbingbing20190513.R;
import com.bawei.jiangbingbing20190513.bean.UserBean;
import com.bumptech.glide.Glide;

import java.util.List;

public class ListViewAdapter extends BaseAdapter {
    private List<UserBean.Mydata> list;
    private Context context;

    public ListViewAdapter(List<UserBean.Mydata> list, Context context) {
        this.list = list;
        this.context = context;
    }
    //数量
    @Override
    public int getCount() {
        return list.size();
    }
    //位置
    @Override
    public Object getItem(int position) {
        return list.get(position);
    }
    //下标
    @Override
    public long getItemId(int position) {
        return position;
    }
    //视图类型数量
    @Override
    public int getViewTypeCount() {
        return 2;
    }
    //视图类型
    @Override
    public int getItemViewType(int position) {
        return position%2;
    }
    //优化listview
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
     //判断多条目
        int itemViewType = getItemViewType(position);
        switch (itemViewType){
            case 0:
                ViewHolder viewHolder;
                if (convertView==null){
                    viewHolder=new ViewHolder();
                    convertView=View.inflate(context, R.layout.list_item,null);
                    viewHolder.name=convertView.findViewById(R.id.name);
                    viewHolder.img=convertView.findViewById(R.id.img);
                    convertView.setTag(viewHolder);
                }else {
                    viewHolder= (ViewHolder) convertView.getTag();
                }
                viewHolder.name.setText(list.get(position).getDesc());
                Glide.with(context).load(list.get(position).getImage()).into(viewHolder.img);
                break;
            case 1:
                ViewHolder1 viewHolder1;
                if (convertView==null){
                    viewHolder1=new ViewHolder1();
                    convertView=View.inflate(context, R.layout.listview_item,null);
                    viewHolder1.name1=convertView.findViewById(R.id.name1);
                    viewHolder1.img1=convertView.findViewById(R.id.img1);
                    convertView.setTag(viewHolder1);
                }else {
                    viewHolder1= (ViewHolder1) convertView.getTag();
                }
                viewHolder1.name1.setText(list.get(position).getDesc());
                Glide.with(context).load(list.get(position).getImage()).into(viewHolder1.img1);
                break;

        }


        return convertView;
    }
    class ViewHolder{
             TextView name;
             ImageView img;
    }
    class ViewHolder1{
        TextView name1;
        ImageView img1;
    }
}
