package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.luochang.extracurricular.adapter.HomeAdapter;
import com.luochang.extracurricular.bean.ActivityFBean;
import com.luochang.extracurricular.bean.HomeBean;

import java.util.ArrayList;
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
    @BindView(R.id.rv_jingcai)
    RecyclerView rvJingcai;
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
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.homev1));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.homev2));
        banner.setData(views);

        rvHome.setLayoutManager(new GridLayoutManager(getContext(), 3));
        final List<HomeBean> data = new ArrayList<>();
        data.add(new HomeBean("体育类", R.drawable.tiyu));
        data.add(new HomeBean("艺术类", R.drawable.yishu));
        data.add(new HomeBean("文学类", R.drawable.wenxue));
        data.add(new HomeBean("创新类", R.drawable.chuangxin));
        data.add(new HomeBean("学术类", R.drawable.xueshu));
        data.add(new HomeBean("军事类", R.drawable.junshi));

        final List<ActivityFBean> first = new ArrayList<>();
        ActivityFBean tiyu = new ActivityFBean("体育类", "篮球", "足球", "乒乓球", "游泳",R.drawable.lanqiu,R.drawable.zuqiu,
                R.drawable.pinpangqiu,R.drawable.youyong,R.drawable.tiyulei,R.drawable.lanqiu1,R.drawable.zuqiu1,R.drawable.pingpangqiu1,R.drawable.youyong1);
        first.add(tiyu);
        ActivityFBean yishu =new  ActivityFBean("艺术类", "摄影", "器乐", "书画", "表演",R.drawable.sheying,R.drawable.qiyue,
                R.drawable.shuhua,R.drawable.biaoyan,R.drawable.yishulei,R.drawable.sheying1,R.drawable.qiyue1,R.drawable.shuhua1,R.drawable.biaoyan1);
        first.add(yishu);
        ActivityFBean wenxue = new ActivityFBean("文学类", "演讲与口才", "写作", "极限英语", "电影鉴赏",R.drawable.yanjiang,R.drawable.xiezuo,
                R.drawable.yingyu,R.drawable.dianying,R.drawable.wenxuelei,R.drawable.yanjiang1,R.drawable.xiezuo1,R.drawable.yingyu1,R.drawable.dianying1);
        first.add(wenxue);
        ActivityFBean chuangxin = new ActivityFBean("创新类", "计算机创新", "电子设计", "航模", "智能车",R.drawable.jisuanji,R.drawable.sheji,
                R.drawable.hangmo,R.drawable.zhineng,R.drawable.chuangxinlei,R.drawable.jisuanji1,R.drawable.sheji1,R.drawable.hangmo1,R.drawable.zhineng1);
        first.add(chuangxin);
        ActivityFBean xueshu = new ActivityFBean("学术类", "数学建模", "中国历史", "经济论坛", "国内外军史",R.drawable.jianmo,R.drawable.lishi,
                R.drawable.jingji,R.drawable.junshi,R.drawable.xueshulei,R.drawable.jianmo1,R.drawable.lishi1,R.drawable.jingji1,R.drawable.junshi1);
        first.add(xueshu);

        //ActivityFBean junshi = new ActivityFBean("军事类", "定向越野", "军事沙龙", "射击", "国内外军事分析");
        ActivityFBean junshi = new ActivityFBean("军事类", "定向越野", "格斗", "射击", "国内外军事分析",R.drawable.yueye,R.drawable.gedou,
                R.drawable.shej,R.drawable.fenxi,R.drawable.junshilei,R.drawable.yueye1,R.drawable.gedou1,R.drawable.shej1,R.drawable.fenxi1);
        first.add(junshi);


        HomeAdapter adapter = new HomeAdapter(R.layout.item_home, data);
        rvHome.setAdapter(adapter);
        rvHome.addOnItemTouchListener(new OnItemClickListener() {
            @Override
            public void onSimpleItemClick(BaseQuickAdapter adapter, View view, int position) {
                //Toast.makeText(getContext(), "点击了" + first.get(position).getYiji(), Toast.LENGTH_SHORT).show();

                Intent contentIntent = new Intent(getContext(), ContentActivity.class);
                contentIntent.putExtra("yiji", first.get(position));
                startActivity(contentIntent);
            }
        });



        final List<HomeBean> data2 = new ArrayList<>();
        data2.add(new HomeBean("校园微课制作大赛", R.drawable.diann));
        data2.add(new HomeBean("野狼杯 篮球赛", R.drawable.lanqiubei));
        data2.add(new HomeBean("备战军事运筹杯", R.drawable.jianmobei));
        data2.add(new HomeBean("砺剑杯书法大赛", R.drawable.homev2));
        rvJingcai.setLayoutManager(new GridLayoutManager(getContext(),2));

        HomeAdapter adapter1 = new HomeAdapter(R.layout.item_home_jc, data2);
        rvJingcai.setAdapter(adapter1);




    }


}
