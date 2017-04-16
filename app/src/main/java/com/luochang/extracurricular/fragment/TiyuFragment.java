package com.luochang.extracurricular.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luochang.extracurricular.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Z-chao on 2017/4/11 23:11
 */

public class TiyuFragment extends Fragment {

    @BindView(R.id.banner_content)
    ImageView mBannerContent;
    @BindView(R.id.rv_content)
    RecyclerView mRvContent;
    private View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.tiyu_fragment, container, false);
        ButterKnife.bind(this, mView);
        initView();
        return mView;
    }

    private void initView() {
        mRvContent.setLayoutManager(new GridLayoutManager(getContext(), 2));
    }

}
