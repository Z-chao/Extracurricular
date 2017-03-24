package com.luochang.extracurricular.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by D on 2017/3/15.
 */


@DatabaseTable(tableName = "t_user")
public class UserBean {


    public static final String USERNAME = "userName";
    public static final String PASSWORD = "password";

    @DatabaseField(columnName = USERNAME,canBeNull = false)
    private  String _userName;



    @DatabaseField(columnName = PASSWORD,canBeNull = false)
    private String _passWord;


    public UserBean(String _userName,  String _passWord) {
        this._userName = _userName;

        this._passWord = _passWord;
    }

    public UserBean() {


    }



    public String get_userName() {
        return _userName;
    }

    public void set_userName(String _userName) {
        this._userName = _userName;
    }


    public String get_passWord() {
        return _passWord;
    }

    public void set_passWord(String _passWord) {
        this._passWord = _passWord;
    }
}
