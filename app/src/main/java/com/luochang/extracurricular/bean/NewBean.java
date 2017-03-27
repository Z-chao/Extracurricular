package com.luochang.extracurricular.bean;

/**
 * Created by D on 2017/3/27.
 */

public class NewBean {
    private Integer image;
    private String name;
    private String mesg;


    public NewBean(Integer image, String name, String mesg) {
        this.image = image;
        this.name = name;
        this.mesg = mesg;
    }

    public NewBean() {
    }

    public Integer getImage() {
        return image;
    }

    public void setImage(Integer image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMesg() {
        return mesg;
    }

    public void setMesg(String mesg) {
        this.mesg = mesg;
    }
}
