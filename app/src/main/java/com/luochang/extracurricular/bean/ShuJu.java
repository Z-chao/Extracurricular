package com.luochang.extracurricular.bean;

/**
 * Created by D on 2017/4/19.
 */

public class ShuJu {

    private String activ_name;
    private String activ_dizhi;
    private int image;
    private String peoplenum;


    public ShuJu(String activ_name, String activ_dizhi, int image, String peoplenum) {
        this.activ_name = activ_name;
        this.activ_dizhi = activ_dizhi;
        this.image = image;
        this.peoplenum = peoplenum;
    }

    public String getActiv_name() {
        return activ_name;
    }

    public void setActiv_name(String activ_name) {
        this.activ_name = activ_name;
    }

    public String getActiv_dizhi() {
        return activ_dizhi;
    }

    public void setActiv_dizhi(String activ_dizhi) {
        this.activ_dizhi = activ_dizhi;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getPeoplenum() {
        return peoplenum;
    }

    public void setPeoplenum(String peoplenum) {
        this.peoplenum = peoplenum;
    }
}
