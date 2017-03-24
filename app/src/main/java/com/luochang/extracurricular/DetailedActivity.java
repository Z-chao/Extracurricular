package com.luochang.extracurricular;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.luochang.extracurricular.bean.ActivityFBean;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailedActivity extends AppCompatActivity {


    @BindView(R.id.iv_detail)
    ImageView ivDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        ActivityFBean yiji = getIntent().getParcelableExtra("yiji");
        int position = getIntent().getIntExtra("position", -1);

        switch (position) {
            case 0:
                ivDetail.setImageResource(yiji.getSanji1());
                break;
            case 1:
                ivDetail.setImageResource(yiji.getSanji2());
                break;
            case 2:
                ivDetail.setImageResource(yiji.getSanji3());
                break;
            case 3:
                ivDetail.setImageResource(yiji.getSanji4());
                break;
        }


    }


}
