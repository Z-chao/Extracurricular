package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luochang.extracurricular.bean.ActivityFBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import q.rorbin.verticaltablayout.VerticalTabLayout;
import q.rorbin.verticaltablayout.adapter.SimpleTabAdapter;
import q.rorbin.verticaltablayout.widget.QTabView;
import q.rorbin.verticaltablayout.widget.TabView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;


/**
 * Created by D on 2017/3/14.
 */

public class ActivityFragment extends Fragment {


    @BindView(R.id.tablayout)
    VerticalTabLayout tablayout;
    @BindView(R.id.vp_vertical_ntb)
    ViewPager vpVerticalNtb;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_activity, container, false);
        }
        initView();
        ButterKnife.bind(this, view);
        return view;
    }

    private void initView() {
        final List<ActivityFBean> first = new ArrayList<>();
        first.add(new ActivityFBean("体育类", "篮球", "足球", "乒乓球", "游泳"));
        first.add(new ActivityFBean("艺术类", "摄影", "器乐", "书画", "表演"));
        first.add(new ActivityFBean("文学类", "演讲与口才", "写作", "极限英语", "电影鉴赏"));
        first.add(new ActivityFBean("创新类", "计算机创新", "电子设计", "航模", "智能车"));
        first.add(new ActivityFBean("学术类", "数学建模", "中国历史", "经济论坛", "国内外军史"));
        first.add(new ActivityFBean("军事类", "定向越野", "军事沙龙", "射击", "国内外军事分析"));

        tablayout = new VerticalTabLayout(getContext());

        tablayout.addTab( new QTabView(getContext()));

    }
}
