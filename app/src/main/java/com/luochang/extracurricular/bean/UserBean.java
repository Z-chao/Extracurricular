package com.luochang.extracurricular.bean;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by D on 2017/3/15.
 */


@DatabaseTable(tableName = "t_user")
public class UserBean {



    @DatabaseField(columnName = "_userName",canBeNull = false)
    private  String _userName;

    @DatabaseField(canBeNull = false,id = true)
    private String _account;

    @DatabaseField(canBeNull = false)
    private String _passWord;


    public UserBean(String _userName, String _account, String _passWord) {
        this._userName = _userName;
        this._account = _account;
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

    public String get_account() {
        return _account;
    }

    public void set_account(String _account) {
        this._account = _account;
    }

    public String get_passWord() {
        return _passWord;
    }

    public void set_passWord(String _passWord) {
        this._passWord = _passWord;
    }
}
