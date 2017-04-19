package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.luochang.extracurricular.bean.UserBean;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.ed_userName)
    EditText edUserName;
    @BindView(R.id.ed_passWord)
    EditText edPassWord;

    @BindView(R.id.bt_login)
    Button btLogin;
    @BindView(R.id.tv_reg)
    TextView tvReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
    }

    @OnClick({ R.id.bt_login})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.bt_login:
                // 登录的操作
                String userNamer = edUserName.getText().toString();
                String passWord = edPassWord.getText().toString();

                DBHelper helper = DBHelper.getHelper(this);
                try {
                    Dao dao = helper.getDao(UserBean.class);
                    QueryBuilder queryBuilder = dao.queryBuilder();
                    queryBuilder.where().eq(UserBean.USERNAME, userNamer);
                    PreparedQuery prepare = queryBuilder.prepare();
                    List<UserBean> account = dao.query(prepare);
                    if (account.size() == 0) {
                        Toast.makeText(this, "该用户不存在", Toast.LENGTH_SHORT).show();
                    } else {
                        UserBean userBean = account.get(0);
                        String passWord1 = userBean.get_passWord();
                        Log.i("zc", "onClick:      密码-------" + passWord1);
                        if (TextUtils.isEmpty(userNamer) && TextUtils.isEmpty(passWord)) {
                            Toast.makeText(this, "用户名或密码不能为空", Toast.LENGTH_SHORT).show();
                        } else {
                            if (TextUtils.equals(passWord, passWord1)) {
                                //登陆成功的逻辑
                                Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
                                //这个时候 记录下来 登陆成功的用户名
                                SPUtils.putAndApply(LoginActivity.this,"userNamer",userNamer);
                                startActivity(mainIntent);
                                finish();
                            } else {
                                Toast.makeText(this, "用户名或密码错误", Toast.LENGTH_SHORT).show();
                            }
                        }
                        Log.i("zc", "onClick:                 查询" + account.toString());
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                break;
        }
    }

    @OnClick(R.id.tv_reg)
    public void onClick() {
        startActivity(new Intent(LoginActivity.this,RegisteredActivity.class));
    }


}
