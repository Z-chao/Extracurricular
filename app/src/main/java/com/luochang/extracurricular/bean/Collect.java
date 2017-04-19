package com.luochang.extracurricular.bean;

/**
 * Created by D on 2017/4/19.
 */

public class Collect {

    private  String name;
    private  int imag;
    private  int progress;

    public Collect(String name, int imag, int progress) {
        this.name = name;
        this.imag = imag;
        this.progress = progress;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImag() {
        return imag;
    }

    public void setImag(int imag) {
        this.imag = imag;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
