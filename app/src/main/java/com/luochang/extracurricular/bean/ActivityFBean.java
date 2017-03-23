package com.luochang.extracurricular.bean;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by D on 2017/3/15.
 */

public class ActivityFBean implements Parcelable {




    private String yiji;

    private String erji1;
    private String erji2;
    private String erji3;
    private String erji4;


    private Integer erjiImg1;
    private Integer erjiImg2;
    private Integer erjiImg3;
    private Integer erjiImg4;

    private Integer erjiImg;

    private Integer sanji1;
    private Integer sanji2;
    private Integer sanji3;
    private Integer sanji4;

    public ActivityFBean(String yiji, String erji1, String erji2, String erji3, String erji4, Integer erjiImg1, Integer erjiImg2, Integer erjiImg3, Integer erjiImg4, Integer erjiImg, Integer sanji1, Integer sanji2, Integer sanji3, Integer sanji4) {
        this.yiji = yiji;
        this.erji1 = erji1;
        this.erji2 = erji2;
        this.erji3 = erji3;
        this.erji4 = erji4;
        this.erjiImg1 = erjiImg1;
        this.erjiImg2 = erjiImg2;
        this.erjiImg3 = erjiImg3;
        this.erjiImg4 = erjiImg4;
        this.erjiImg = erjiImg;
        this.sanji1 = sanji1;
        this.sanji2 = sanji2;
        this.sanji3 = sanji3;
        this.sanji4 = sanji4;
    }

    public Integer getSanji1() {
        return sanji1;
    }

    public void setSanji1(Integer sanji1) {
        this.sanji1 = sanji1;
    }

    public Integer getSanji2() {
        return sanji2;
    }

    public void setSanji2(Integer sanji2) {
        this.sanji2 = sanji2;
    }

    public Integer getSanji3() {
        return sanji3;
    }

    public void setSanji3(Integer sanji3) {
        this.sanji3 = sanji3;
    }

    public Integer getSanji4() {
        return sanji4;
    }

    public void setSanji4(Integer sanji4) {
        this.sanji4 = sanji4;
    }

    public ActivityFBean(String yiji, String erji1, String erji2, String erji3, String erji4) {
        this.yiji = yiji;
        this.erji1 = erji1;
        this.erji2 = erji2;
        this.erji3 = erji3;
        this.erji4 = erji4;
    }

    public ActivityFBean(String yiji, String erji1, String erji2, String erji3, String erji4, Integer erjiImg1, Integer erjiImg2, Integer erjiImg3, Integer erjiImg4, Integer erjiImg) {
        this.yiji = yiji;
        this.erji1 = erji1;
        this.erji2 = erji2;
        this.erji3 = erji3;
        this.erji4 = erji4;
        this.erjiImg1 = erjiImg1;
        this.erjiImg2 = erjiImg2;
        this.erjiImg3 = erjiImg3;
        this.erjiImg4 = erjiImg4;
        this.erjiImg = erjiImg;
    }


    public Integer getErjiImg1() {
        return erjiImg1;
    }

    public void setErjiImg1(Integer erjiImg1) {
        this.erjiImg1 = erjiImg1;
    }

    public Integer getErjiImg2() {
        return erjiImg2;
    }

    public void setErjiImg2(Integer erjiImg2) {
        this.erjiImg2 = erjiImg2;
    }

    public Integer getErjiImg3() {
        return erjiImg3;
    }

    public void setErjiImg3(Integer erjiImg3) {
        this.erjiImg3 = erjiImg3;
    }

    public Integer getErjiImg4() {
        return erjiImg4;
    }

    public void setErjiImg4(Integer erjiImg4) {
        this.erjiImg4 = erjiImg4;
    }

    public Integer getErjiImg() {
        return erjiImg;
    }

    public void setErjiImg(Integer erjiImg) {
        this.erjiImg = erjiImg;
    }

    public String getYiji() {
        return yiji;
    }

    public void setYiji(String yiji) {
        this.yiji = yiji;
    }

    public String getErji1() {
        return erji1;
    }

    public void setErji1(String erji1) {
        this.erji1 = erji1;
    }

    public String getErji2() {
        return erji2;
    }

    public void setErji2(String erji2) {
        this.erji2 = erji2;
    }

    public String getErji3() {
        return erji3;
    }

    public void setErji3(String erji3) {
        this.erji3 = erji3;
    }

    public String getErji4() {
        return erji4;
    }

    public void setErji4(String erji4) {
        this.erji4 = erji4;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.yiji);
        dest.writeString(this.erji1);
        dest.writeString(this.erji2);
        dest.writeString(this.erji3);
        dest.writeString(this.erji4);
        dest.writeValue(this.erjiImg1);
        dest.writeValue(this.erjiImg2);
        dest.writeValue(this.erjiImg3);
        dest.writeValue(this.erjiImg4);
        dest.writeValue(this.erjiImg);
        dest.writeValue(this.sanji1);
        dest.writeValue(this.sanji2);
        dest.writeValue(this.sanji3);
        dest.writeValue(this.sanji4);
    }

    protected ActivityFBean(Parcel in) {
        this.yiji = in.readString();
        this.erji1 = in.readString();
        this.erji2 = in.readString();
        this.erji3 = in.readString();
        this.erji4 = in.readString();
        this.erjiImg1 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.erjiImg2 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.erjiImg3 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.erjiImg4 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.erjiImg = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sanji1 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sanji2 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sanji3 = (Integer) in.readValue(Integer.class.getClassLoader());
        this.sanji4 = (Integer) in.readValue(Integer.class.getClassLoader());
    }

    public static final Creator<ActivityFBean> CREATOR = new Creator<ActivityFBean>() {
        @Override
        public ActivityFBean createFromParcel(Parcel source) {
            return new ActivityFBean(source);
        }

        @Override
        public ActivityFBean[] newArray(int size) {
            return new ActivityFBean[size];
        }
    };
}





