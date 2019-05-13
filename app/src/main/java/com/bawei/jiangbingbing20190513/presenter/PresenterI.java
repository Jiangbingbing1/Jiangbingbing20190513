package com.bawei.jiangbingbing20190513.presenter;

import com.bawei.jiangbingbing20190513.view.ViewI;
//接口
public interface PresenterI {

    void onAttach(ViewI viewI);
    void startFromData(String s);
    void ondeAttach();

}
