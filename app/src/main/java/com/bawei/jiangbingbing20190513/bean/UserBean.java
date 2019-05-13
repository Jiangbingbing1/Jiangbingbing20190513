package com.bawei.jiangbingbing20190513.bean;

import java.util.List;
//解析json
public class UserBean {

    private List<Mydata> items;

    public List<Mydata> getItems() {
        return items;
    }

    public void setItems(List<Mydata> items) {
        this.items = items;
    }

    public class Mydata{

        private String desc;
        private String image;

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}
