package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bingoogolapple.bgabanner.BGABanner;

public class DetailedActivity extends AppCompatActivity {

    @BindView(R.id.banner_content)
    BGABanner bannerContent;
    @BindView(R.id.activity_detailed)
    RelativeLayout activityDetailed;
    @BindView(R.id.tv_join)
    TextView tvJoin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {


    }


    @OnClick(R.id.tv_join)
    public void onClick() {
        startActivity(new Intent(DetailedActivity.this,HuoDongActivity.class));

    }


}
