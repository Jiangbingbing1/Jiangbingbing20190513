package com.bawei.jiangbingbing20190513.presenter;

import com.bawei.jiangbingbing20190513.model.ModelI;
import com.bawei.jiangbingbing20190513.model.RegisModelI;
import com.bawei.jiangbingbing20190513.view.ViewI;

public class RegisPresenter implements PresenterI{
    private ViewI viewI;
    private ModelI modelI;
    public RegisPresenter(ViewI viewI){
        modelI=new RegisModelI();
          this.viewI=viewI;
    }
    @Override
    public void onAttach(ViewI viewI) {
        this.viewI=viewI;
    }

    @Override
    public void startFromData(String s) {
          modelI.Fromdata(s, new ModelI.Callback() {
              @Override
              public void setData(String data) {
                  viewI.getData(data);
              }
          });
    }

    @Override
    public void ondeAttach() {
          if (modelI!=null){
               modelI=null;
          }
          if (viewI!=null){
               viewI=null;
          }
    }
}
