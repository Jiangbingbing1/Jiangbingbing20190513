package com.bawei.jiangbingbing20190513;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.bawei.jiangbingbing20190513.adapter.ListViewAdapter;
import com.bawei.jiangbingbing20190513.bean.UserBean;
import com.bawei.jiangbingbing20190513.utils.HttpConnection;
import com.bawei.jiangbingbing20190513.utils.HttpUrl;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

/**
 * jbb
 * 2019.05.13
 * */
public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private List<UserBean.Mydata> items=new ArrayList<>();
    private String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       //listview
        listView=findViewById(R.id.listview);
        //判断是否有网
        boolean httpConnection=HttpConnection.getConntction(MainActivity.this);
        if (httpConnection){
            getFromData();
        }else {
            HttpConnection.getHttp(MainActivity.this);
        }


    }
    //请求数据
    public void getFromData(){
        HttpUrl httpUrl=HttpUrl.getInstance();
        httpUrl.getAsyncTask(path);
        httpUrl.getCallback(new HttpUrl.Callback() {
            @Override
            public void getData(String json) {
                Log.i("sss",json);
                Gson gson=new Gson();
                //解析数据
                UserBean userBean = gson.fromJson(json, UserBean.class);
                items = userBean.getItems();
                Log.i("ttt",items.size()+"");
                //适配器
                ListViewAdapter adapter=new ListViewAdapter(items,MainActivity.this);
                listView.setAdapter(adapter);

            }
        });
    }
}
