package com.luochang.extracurricular.bean;

import android.content.Context;

import com.j256.ormlite.dao.Dao;
import com.luochang.extracurricular.DBHelper;

import java.sql.SQLException;

/**
 * Created by D on 2017/3/15.
 */

public class UserDao {

    private Context context;
    private  DBHelper helper;
    private  Dao dao;


    public UserDao(Context context) {
        this.context = context;

        try {
         helper = DBHelper.getHelper(context);
            dao = helper.getDao(UserBean.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void add(UserBean userBean) {
        try {
            dao.create(userBean);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
