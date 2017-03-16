package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luochang.extracurricular.adapter.ContentAdapter;
import com.luochang.extracurricular.bean.ActivityFBean;
import com.luochang.extracurricular.bean.HomeBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

import static java.security.AccessController.getContext;

public class ContentActivity extends AppCompatActivity {

    @BindView(R.id.banner_content)
    BGABanner bannerContent;
    @BindView(R.id.rv_content)
    RecyclerView rvContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.images));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.debcfa5fbc02ae098fce38de1550769a));
        views.add(BGABannerUtil.getItemImageView(this, R.drawable.ic_launcher));
        bannerContent.setData(views);

        rvContent.setLayoutManager(new GridLayoutManager(this,2));




        ActivityFBean yiji = getIntent().getParcelableExtra("yiji");
        List<HomeBean> data = new ArrayList<>();
        data.add(new HomeBean(yiji.getErji1(),R.mipmap.biz_pc_main_info_profile_avatar_bg_dark));
        data.add(new HomeBean(yiji.getErji2(),R.mipmap.ic_launcher));
        data.add(new HomeBean(yiji.getErji3(),R.mipmap.lock));
        data.add(new HomeBean(yiji.getErji4(),R.mipmap.debcfa5fbc02ae098fce38de1550769a));

        rvContent.setAdapter(new ContentAdapter(R.layout.item_content,data));

        rvContent.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {

              /*  Intent contentIntent = new Intent(getContext(), ContentActivity.class);
                contentIntent.putExtra("yiji", first.get(position));
                startActivity(contentIntent);*/

                Intent intent = new Intent(ContentActivity.this,DetailedActivity.class);
                startActivity(intent);
            }
        });

    }


}
