package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.luochang.extracurricular.bean.UserBean;
import com.luochang.extracurricular.bean.UserDao;

import java.sql.SQLException;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisteredActivity extends AppCompatActivity {


    @BindView(R.id.ed_userName)
    EditText edUserName;
    @BindView(R.id.ed_account)
    EditText edAccount;
    @BindView(R.id.ed_passWord)
    EditText edPassWord;
    @BindView(R.id.ed_sure)
    EditText edSure;
    @BindView(R.id.bt_registered)
    Button btRegistered;

    private DBHelper helper;
    private UserBean userBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        ButterKnife.bind(this);
        helper = DBHelper.getHelper(this);

    }


    @OnClick(R.id.bt_registered)
    public void onClick()  {

        try {
            Dao<UserBean, ?> dao = helper.getDao(UserBean.class);
            Log.i("zc", "onClick:      点击了注册");
            userBean = new UserBean();
            String userName = edUserName.getText().toString();
            if (TextUtils.isEmpty(userName)) {
                Toast.makeText(this, "用户名不能为空", Toast.LENGTH_SHORT).show();
            }
            String account = edAccount.getText().toString();
            if (TextUtils.isEmpty(account)) {
                Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
            }
            String passWord = edPassWord.getText().toString();
            String sure = edSure.getText().toString();
            if (TextUtils.isEmpty(passWord) && TextUtils.isEmpty(sure)) {
                Toast.makeText(this, "密码或确认密码不能为空", Toast.LENGTH_SHORT).show();
            }

            if (TextUtils.equals(passWord, sure)) {
               // UserDao userDao = new UserDao(this);
                Log.i("zc", "onClick:        进入创建用户的方法");
                int i = dao.create(new UserBean(userName, account, passWord));
                Log.i("zc", "onClick:  ----------------" + i);

            } else {
                Toast.makeText(this, "两次输入的密码不正确", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
