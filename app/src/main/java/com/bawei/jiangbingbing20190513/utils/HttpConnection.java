package com.bawei.jiangbingbing20190513.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;

public class HttpConnection {
//判断是否有网
      public static boolean getConntction(Context context){
          ConnectivityManager connectivityManager= (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
          NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
          if (activeNetworkInfo!=null&&activeNetworkInfo.isConnected()){
                return true;
          }
          return false;
      }
      //设置网络
      public static void getHttp(final Context context){
          AlertDialog.Builder builder = new AlertDialog.Builder(context);
          builder.setTitle("设置网络");
          builder.setPositiveButton("网络", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  Intent intent=new Intent(Settings.ACTION_WIFI_SETTINGS);
                  context.startActivity(intent);
              }
          }).show();

      }
}
