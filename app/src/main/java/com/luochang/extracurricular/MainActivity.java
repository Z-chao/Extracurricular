package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.luochang.extracurricular.fragment.CollectionFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.content)
    FrameLayout content;
    @BindView(R.id.ib_home)
    ImageButton ibHome;
    @BindView(R.id.ll_home)
    LinearLayout llHome;
    @BindView(R.id.ib_huodong)
    ImageButton ibHuodong;
    @BindView(R.id.ll_huodong)
    LinearLayout llHuodong;
    @BindView(R.id.ib_shoucang)
    ImageButton ibShoucang;
    @BindView(R.id.ll_shoucang)
    LinearLayout llShoucang;
    @BindView(R.id.ib_user)
    ImageButton ibUser;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.activity_main)
    RelativeLayout activityMain;
    @BindView(R.id.ib_news)
    ImageButton ibNews;
    @BindView(R.id.ll_news)
    LinearLayout llNews;

    private HomeFragment fg_home;
    private ActivityFragment fg_activity;
    private CollectionFragment fg_collection;
    private MyFragment fg_my;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private NewFragment fg_new;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        manager = getSupportFragmentManager();  //拿到Fragment的管理者
        setTabSelection(0);
    }

    /**
     * 设置选中哪个fragment的方法
     *
     * @param index
     */
    private void setTabSelection(int index) {
        transaction = manager.beginTransaction();  //开启Fragment的事务
        //重置所有的图片为未选中
        resetImageRous();
        //清除所有的选中状态
        hideAllFragment();


        switch (index) {
            case 0:
                //切换到首页
                if (fg_home == null) {
                    fg_home = new HomeFragment();
                    transaction.add(R.id.content, fg_home);
                } else {

                    transaction.show(fg_home);
                }
                ((ImageButton) llHome.findViewById(R.id.ib_home)).setImageResource(R.mipmap.shouye1);

                break;
            case 1:
                //切换到所有活动
                if (fg_activity == null) {
                    fg_activity = new ActivityFragment();
                    transaction.add(R.id.content, fg_activity);
                } else {
                    transaction.show(fg_activity);
                }

                ((ImageButton) llHuodong.findViewById(R.id.ib_huodong)).setImageResource(R.mipmap.huodong1);

                break;

            case 2:
                //切换到我的消息
                if (fg_new == null) {
                    fg_new = new NewFragment();
                    transaction.add(R.id.content, fg_new);
                } else {
                    transaction.show(fg_new);
                }

                ((ImageButton) llNews.findViewById(R.id.ib_news)).setImageResource(R.mipmap.news);

                break;


            case 3:
                //切换到我的活动
                if (fg_collection == null) {
                    fg_collection = new CollectionFragment();
                    transaction.add(R.id.content, fg_collection);
                } else {
                    transaction.show(fg_collection);
                }
                ((ImageButton) llShoucang.findViewById(R.id.ib_shoucang)).setImageResource(R.mipmap.shoucang1);

                break;
            case 4:
                //切换到我的账户
                if (fg_my == null) {
                    fg_my = new MyFragment();
                    transaction.add(R.id.content, fg_my);
                } else {
                    transaction.show(fg_my);
                }

                ((ImageButton) llUser.findViewById(R.id.ib_user)).setImageResource(R.mipmap.user1);

                break;
        }

        transaction.commit();


    }

    private void hideAllFragment() {
        if (fg_home != null) {
            transaction.hide(fg_home);
        }

        if (fg_activity != null) {
            transaction.hide(fg_activity);
        }

        if (fg_collection != null) {
            transaction.hide(fg_collection);
        }
        if (fg_my != null) {
            transaction.hide(fg_my);
        }
        if (fg_new != null) {
            transaction.hide(fg_new);
        }


    }

    /**
     * 重置图片
     */
    private void resetImageRous() {
        ((ImageButton) llHome.findViewById(R.id.ib_home)).setImageResource(R.mipmap.shouye0);
        ((ImageButton) llHuodong.findViewById(R.id.ib_huodong)).setImageResource(R.mipmap.huodong0);
        ((ImageButton) llShoucang.findViewById(R.id.ib_shoucang)).setImageResource(R.mipmap.shoucang0);
        ((ImageButton) llUser.findViewById(R.id.ib_user)).setImageResource(R.mipmap.user0);
        ((ImageButton) llNews.findViewById(R.id.ib_news)).setImageResource(R.mipmap.new1);


    }


    @OnClick({R.id.ll_home, R.id.ll_huodong, R.id.ll_shoucang, R.id.ll_user,R.id.ib_news, R.id.ll_news})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_home:
                //点击首页的操作
                setTabSelection(0);
                break;
            case R.id.ll_huodong:
                //点击所有活动的操作
                setTabSelection(1);
                break;
            case R.id.ll_shoucang:
                //点击我的活动的操作
                setTabSelection(3);
                break;
            case R.id.ll_user:
                //点击了账号的操作
                setTabSelection(4);
                break;
            case R.id.ll_news:
                //点击了我的消息的操作
                setTabSelection(2);
                break;
        }
    }



}
