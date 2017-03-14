package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.ed_userName)
    EditText edUserName;
    @BindView(R.id.ed_passWord)
    EditText edPassWord;
    @BindView(R.id.tv_losword)
    TextView tvLosword;
    @BindView(R.id.bt_login)
    Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.tv_losword, R.id.bt_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_losword:
                //忘记密码的操作
                break;
            case R.id.bt_login:
                // 登录的操作
                break;
        }
    }
}
