package com.luochang.extracurricular.bean;

/**
 * Created by D on 2017/3/15.
 */

public class ActivityFBean {

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
}
