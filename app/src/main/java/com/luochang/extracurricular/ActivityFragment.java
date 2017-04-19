package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luochang.extracurricular.adapter.ActivityAdapter;
import com.luochang.extracurricular.bean.ActivityFBean;
import com.luochang.extracurricular.bean.ShuJu;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by D on 2017/3/14.
 */

public class ActivityFragment extends Fragment {


    @BindView(R.id.rv_activity)
    RecyclerView rvActivity;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_activity, container, false);
        }
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        final List<ShuJu> first = new ArrayList<>();
        first.add(new ShuJu("篮球俱乐部","活动地址",R.drawable.lanqiu,"20"));
        first.add(new ShuJu("足球俱乐部","活动地址",R.drawable.zuqiu,"20"));
        first.add(new ShuJu("乒乓球俱乐部","活动地址",R.drawable.pinpangqiu,"20"));
        first.add(new ShuJu("游泳俱乐部","活动地址",R.drawable.youyong,"20"));
        first.add(new ShuJu("摄影社团","活动地址",R.drawable.sheying,"20"));
        first.add(new ShuJu("器乐社团","活动地址",R.drawable.qiyue,"20"));
        first.add(new ShuJu("书画社团","活动地址",R.drawable.shuhua,"20"));
        first.add(new ShuJu("表演社团","活动地址",R.drawable.biaoyan,"20"));
        first.add(new ShuJu("演讲与口才社","活动地址",R.drawable.yanjiang,"20"));
        first.add(new ShuJu("写作社","活动地址",R.drawable.xiezuo,"20"));
        first.add(new ShuJu("极限英语社","活动地址",R.drawable.yingyu,"20"));
        first.add(new ShuJu("电影鉴赏社","活动地址",R.drawable.dianying,"20"));
        first.add(new ShuJu("计算机创新部","活动地址",R.drawable.jisuanji,"20"));
        first.add(new ShuJu("电子设计部","活动地址",R.drawable.sheji,"20"));
        first.add(new ShuJu("航模部","活动地址",R.drawable.hangmo,"20"));
        first.add(new ShuJu("智能车部","活动地址",R.drawable.zhineng,"20"));
        first.add(new ShuJu("数学建模研究","活动地址",R.drawable.jianmo,"20"));
        first.add(new ShuJu("中国历史研究","活动地址",R.drawable.lishi,"20"));
        first.add(new ShuJu("经济论坛","活动地址",R.drawable.jingji,"20"));
        first.add(new ShuJu("国内外军史研究","活动地址",R.drawable.junshi,"20"));
        first.add(new ShuJu("定向越野","活动地址",R.drawable.yueye,"20"));
        first.add(new ShuJu("格斗","活动地址",R.drawable.gedou,"20"));
        first.add(new ShuJu("射击","活动地址",R.drawable.shej,"20"));
        first.add(new ShuJu("国内外军事分析","活动地址",R.drawable.fenxi,"20"));
        rvActivity.setLayoutManager(new LinearLayoutManager(getContext()));
        rvActivity.setAdapter(new ActivityAdapter(R.layout.item_collection,first));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }





}
