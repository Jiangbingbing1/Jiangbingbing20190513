package com.bawei.jiangbingbing20190513.utils;

import android.os.AsyncTask;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class HttpUrl {
    private static final HttpUrl ourInstance = new HttpUrl();
    private Callback callback;

    public static HttpUrl getInstance() {
        return ourInstance;
    }

    private HttpUrl() {
    }
    //异步请求
    public void getAsyncTask(String path){
        AsyncTask<String,Void,String> asyncTask=new AsyncTask<String, Void, String>() {
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
                super.onPostExecute(s);
                callback.getData(s);
            }
        }.execute(path);
    }

    public interface Callback{
        void getData(String json);
    }
    public void getCallback(Callback callback){
          this.callback=callback;
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
