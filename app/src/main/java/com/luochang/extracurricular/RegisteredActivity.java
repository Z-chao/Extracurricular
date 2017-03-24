package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.luochang.extracurricular.bean.UserBean;
import com.zhy.android.percent.support.PercentLinearLayout;

import java.sql.SQLException;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisteredActivity extends AppCompatActivity {


    @BindView(R.id.ed_passWord)
    EditText edPassWord;
    @BindView(R.id.ed_sure)
    EditText edSure;
    @BindView(R.id.bt_registered)
    Button btRegistered;
    @BindView(R.id.ed_account)
    EditText edAccount;
    @BindView(R.id.activity_login)
    PercentLinearLayout activityLogin;

    private DBHelper helper;
    private UserBean userBean;
    private UserBean ifNotExists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registered);
        ButterKnife.bind(this);
        helper = DBHelper.getHelper(this);

    }


    @OnClick(R.id.bt_registered)
    public void onClick() {

        try {
            ifNotExists = null;
            Dao<UserBean, ?> dao = helper.getDao(UserBean.class);
            Log.i("zc", "onClick:      点击了注册");
            userBean = new UserBean();
            String userName = edAccount.getText().toString();
            String passWord = edPassWord.getText().toString();
            String sure = edSure.getText().toString();
            if (TextUtils.isEmpty(passWord) && TextUtils.isEmpty(sure)) {
                Toast.makeText(this, "密码或确认密码不能为空", Toast.LENGTH_SHORT).show();
            }

            if (TextUtils.equals(passWord, sure)) {

                Log.i("zc", "onClick:        进入创建用户的方法");
                UserBean userBean = new UserBean(userName, passWord);

                if (  !getDataByOrmlite(userName)) {
                    dao.create(userBean);
                    Toast.makeText(this, "注册成功", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(this, "改账号 已被使用", Toast.LENGTH_SHORT).show();
                }


            } else {
                Toast.makeText(this, "两次输入的密码不正确", Toast.LENGTH_SHORT).show();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /**
     * 去数据库查询 主键
     *
     * @param account
     */
    private boolean getDataByOrmlite(String account) throws SQLException {

        Dao<UserBean, String> dao = helper.getDao(UserBean.class);
        QueryBuilder<UserBean, String> userBeanQueryBuilder = dao.queryBuilder();

        userBeanQueryBuilder.where().eq(UserBean.USERNAME, account);
        PreparedQuery<UserBean> prepare = userBeanQueryBuilder.prepare();

        List<UserBean> query = dao.query(prepare);
        Log.i("zc", "getDataByOrmlite:       数量" + query.size());
        if (query.size() == 1) {
            for (UserBean bean : query) {
                Log.i("zc", "getDataByOrmlite:     有没有 这个用户" + bean.get_userName());
            }
            return true;
        } else {
            return false;
        }


    }


}
