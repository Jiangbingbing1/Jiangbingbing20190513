package com.bawei.jiangbingbing20190513.model;

import com.bawei.jiangbingbing20190513.utils.HttpUrl;
//接口
public interface ModelI {
    void Fromdata(String s,Callback callback);
    interface Callback{
        void setData(String data);
    }
}
