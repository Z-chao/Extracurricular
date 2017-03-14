package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;

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
                String userNamer = edUserName.getText().toString();
                String passWord = edPassWord.getText().toString();
                if (TextUtils.isEmpty(userNamer) && TextUtils.isEmpty(passWord)) {
                    Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    if (TextUtils.equals(userNamer, "zhangsan") && TextUtils.equals(passWord, "123456")) {
                        Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(mainIntent);
                    } else {
                        Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
                }
                break;
        }
    }
}
