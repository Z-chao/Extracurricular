package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.bt_registered)
    Button btRegistered;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash2);
        ButterKnife.bind(this);
        DBHelper dbHelper = DBHelper.getHelper(this);
        dbHelper.getWritableDatabase();
    }

    @OnClick({R.id.bt_login, R.id.bt_registered})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                //登录的操作,点击跳转到 登录界面
                Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(loginIntent);
                break;
            case R.id.bt_registered:
                //注册的操作, 点击跳转到注册界面
                Intent registeredIntent = new Intent(SplashActivity.this, RegisteredActivity.class);
                startActivity(registeredIntent);
                break;
        }
    }


}
