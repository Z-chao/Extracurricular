package com.luochang.extracurricular;

import android.app.Application;

/**
 * Created by D on 2017/3/24.
 */

public class MyApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();
        DBHelper helper = DBHelper.getHelper(this);
        helper.getWritableDatabase();
    }
}
