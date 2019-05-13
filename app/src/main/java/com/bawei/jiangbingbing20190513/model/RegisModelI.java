package com.bawei.jiangbingbing20190513.model;

import android.os.AsyncTask;

import com.bawei.jiangbingbing20190513.utils.HttpUrl;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
//实现接口
public class RegisModelI implements ModelI{

    //地址
    private String path="https://code.aliyun.com/598254259/FristProject/raw/master/bw_list.txt";
    @Override
    public void Fromdata(String s,Callback callback) {
         new MyTask(s,callback).execute(path);
    }

    class MyTask extends AsyncTask<String,Void,String>{
         private String s;
         private Callback callback;

        public MyTask(String s, Callback callback) {
            this.s = s;
            this.callback = callback;
        }

        @Override
        protected String doInBackground(String... strings) {
            try {
                URL url=new URL(strings[0]);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                if (connection.getResponseCode()==200){
                    InputStream inputStream = connection.getInputStream();
                    String s = SystemFromData(inputStream);
                    return s;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
               callback.setData(s);
        }
    }
    public String SystemFromData(InputStream inputStream) throws IOException {
        int len=-1;
        byte[] bytes=new byte[1024];
        StringBuffer stringBuffer=new StringBuffer();
        while ((len=inputStream.read(bytes))!=-1){
            String s=new String(bytes,0,len);
            stringBuffer.append(s);
        }
        return stringBuffer.toString();
    }
}
