package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash2);
        ButterKnife.bind(this);
        initData();
        startMain();



    }

    private void initData() {
        DBHelper dbHelper = DBHelper.getHelper(this);
        dbHelper.getWritableDatabase();
    }


    /**
     * 延时操作 进入Main
     */
    private void startMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2000);

    }


}
