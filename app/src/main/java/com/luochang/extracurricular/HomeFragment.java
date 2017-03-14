package com.luochang.extracurricular;

import android.os.Bundle;
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

import com.bumptech.glide.Glide;

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
        /*banner.setAdapter(new BGABanner.Adapter<ImageView,Integer>() {
            @Override
            public void fillBannerItem(BGABanner banner, ImageView itemView, Integer model, int position) {
                Glide.with(HomeFragment.this)
                        .load(model)
                        .centerCrop()
                        .dontAnimate()
                        .into(itemView);
            }
        });*/


        List<View> views = new ArrayList<>();
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.images));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.debcfa5fbc02ae098fce38de1550769a));
        views.add(BGABannerUtil.getItemImageView(getContext(), R.drawable.ic_launcher));
        banner.setData(views);

        rvHome.setLayoutManager(new GridLayoutManager(getContext(),3));




    }


}
