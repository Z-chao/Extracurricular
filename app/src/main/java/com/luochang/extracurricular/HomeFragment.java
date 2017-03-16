package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luochang.extracurricular.adapter.HomeAdapter;
import com.luochang.extracurricular.bean.ActivityFBean;
import com.luochang.extracurricular.bean.HomeBean;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.bingoogolapple.bgabanner.BGABanner;
import cn.bingoogolapple.bgabanner.BGABannerUtil;

/**
 * Created by D on 2017/3/14.
 */

public class HomeFragment extends Fragment {
    @BindView(R.id.banner)
    BGABanner banner;
    @BindView(R.id.rv_home)
    RecyclerView rvHome;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_home, container, false);

        }
        ButterKnife.bind(this, view);
        return view;   //对界面进行 布局的填充
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    private void initView() {
        //对轮播图进行 数据的填充 和显示

        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.images));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.debcfa5fbc02ae098fce38de1550769a));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.ic_launcher));
        banner.setData(views);

        rvHome.setLayoutManager(new GridLayoutManager(getContext(),3));
        final List<HomeBean> data = new ArrayList<>();
        data.add(new HomeBean("体育类",R.drawable.ic_launcher));
        data.add(new HomeBean("艺术类",R.drawable.ic_launcher));
        data.add(new HomeBean("文学类",R.drawable.ic_launcher));
        data.add(new HomeBean("创新类",R.drawable.ic_launcher));
        data.add(new HomeBean("学术类",R.drawable.ic_launcher));
        data.add(new HomeBean("军事类",R.drawable.ic_launcher));

        final List<ActivityFBean> first = new ArrayList<>();
        ActivityFBean tiyu = new ActivityFBean("体育类", "篮球", "足球", "乒乓球", "游泳");
        first.add(tiyu);
        ActivityFBean yishu = new ActivityFBean("艺术类", "摄影", "器乐", "书画", "表演");
        first.add(yishu);
        ActivityFBean wenxue = new ActivityFBean("文学类", "演讲与口才", "写作", "极限英语", "电影鉴赏");
        first.add(wenxue);
        ActivityFBean chuangxin = new ActivityFBean("创新类", "计算机创新", "电子设计", "航模", "智能车");
        first.add(chuangxin);
        ActivityFBean xueshu = new ActivityFBean("学术类", "数学建模", "中国历史", "经济论坛", "国内外军史");
        first.add(xueshu);
        ActivityFBean junshi = new ActivityFBean("军事类", "定向越野", "军事沙龙", "射击", "国内外军事分析");
        first.add(junshi);



        rvHome.setAdapter(new HomeAdapter(R.layout.item_home,data));
        rvHome.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Toast.makeText(getContext(), "点击了" + first.get(position).getYiji(), Toast.LENGTH_SHORT).show();

                Intent contentIntent = new Intent(getContext(), ContentActivity.class);
                contentIntent.putExtra("yiji", first.get(position));
                startActivity(contentIntent);
            }
        });

    }


}
