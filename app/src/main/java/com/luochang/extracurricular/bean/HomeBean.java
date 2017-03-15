package com.luochang.extracurricular.bean;

/**
 * Created by D on 2017/3/15.
 */

public class HomeBean {

    private String homeName;
    private  Integer ima;

    public HomeBean(String homeName, Integer ima) {
        this.homeName = homeName;
        this.ima = ima;
    }

    public String getHomeName() {
        return homeName;
    }

    public void setHomeName(String homeName) {
        this.homeName = homeName;
    }

    public Integer getIma() {
        return ima;
    }

    public void setIma(Integer ima) {
        this.ima = ima;
    }
}

