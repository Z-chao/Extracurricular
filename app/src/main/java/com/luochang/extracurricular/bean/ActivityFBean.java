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

    public ActivityFBean(String yiji, String erji1, String erji2, String erji3, String erji4) {
        this.yiji = yiji;
        this.erji1 = erji1;
        this.erji2 = erji2;
        this.erji3 = erji3;
        this.erji4 = erji4;
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
    }

    protected ActivityFBean(Parcel in) {
        this.yiji = in.readString();
        this.erji1 = in.readString();
        this.erji2 = in.readString();
        this.erji3 = in.readString();
        this.erji4 = in.readString();
    }

    public static final Parcelable.Creator<ActivityFBean> CREATOR = new Parcelable.Creator<ActivityFBean>() {
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
