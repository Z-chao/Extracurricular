package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luochang.extracurricular.adapter.ContentAdapter;
import com.luochang.extracurricular.bean.ActivityFBean;
import com.luochang.extracurricular.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

import static android.R.attr.y;

public class ContentActivity extends AppCompatActivity {


    @BindView(R.id.rv_content)
    RecyclerView rvContent;
    @BindView(R.id.banner_content)
    ImageView bannerContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {



        rvContent.setLayoutManager(new GridLayoutManager(this, 2));


        final ActivityFBean yiji = getIntent().getParcelableExtra("yiji");
        List<HomeBean> data = new ArrayList<>();
        data.add(new HomeBean(yiji.getErji1(), yiji.getErjiImg1()));
        data.add(new HomeBean(yiji.getErji2(), yiji.getErjiImg2()));
        data.add(new HomeBean(yiji.getErji3(), yiji.getErjiImg3()));
        data.add(new HomeBean(yiji.getErji4(), yiji.getErjiImg4()));
       bannerContent.setImageResource(yiji.getErjiImg());


        rvContent.setAdapter(new ContentAdapter(R.layout.item_content, data));

        rvContent.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

                Intent intent = new Intent(ContentActivity.this, DetailedActivity.class);
                intent.putExtra("yiji",yiji );
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });

    }


}
