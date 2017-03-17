package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.luochang.extracurricular.adapter.MyPagerAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class HuoDongActivity extends AppCompatActivity {

    @BindView(R.id.tay_home_tab_view)
    TabLayout tb_data;
    @BindView(R.id.vp_deta)
    ViewPager vp_data;
    private ArrayList<String> mTitleList;
    private ArrayList<View> mViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_huo_dong);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        tb_data.setTabMode(TabLayout.MODE_FIXED);
        tb_data.setTabGravity(TabLayout.GRAVITY_FILL);
        setViewPagerData();
        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList,mTitleList);
        vp_data.setAdapter(mAdapter);
        tb_data.setupWithViewPager(vp_data);

        boolean finish = getIntent().getBooleanExtra("finish", false);

        if (finish) {
            tb_data.getTabAt(1).select();
        }

    }

    private void setViewPagerData() {
        if (mTitleList == null) {
            mTitleList = new ArrayList<>();
            mTitleList.add("未完成");
            mTitleList.add("已完成");

        }
        if (mViewList == null) {
            mViewList = new ArrayList<>();
        }
        for (int i = 0; i < 2; i++) {
            mViewList.add(View.inflate(this,R.layout.item_tex,null));
        }
    }
}
