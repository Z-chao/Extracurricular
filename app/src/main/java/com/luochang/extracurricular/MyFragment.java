package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by D on 2017/3/14.
 */

public class MyFragment extends Fragment {

    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.ll_myjianli)
    LinearLayout llMyjianli;
    @BindView(R.id.ll_myhuodong)
    LinearLayout llMyhuodong;
    @BindView(R.id.ll_myshoucang)
    LinearLayout llMyshoucang;
    @BindView(R.id.ll_myyijian)
    LinearLayout llMyyijian;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.fragment_my, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }


    @OnClick({R.id.tv_login, R.id.ll_myjianli, R.id.ll_myhuodong, R.id.ll_myshoucang, R.id.ll_myyijian})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tv_login:
                //登录的逻辑
                startActivity(new Intent(getContext(),LoginActivity.class));
                break;
            case R.id.ll_myjianli:
                break;
            case R.id.ll_myhuodong:
                break;
            case R.id.ll_myshoucang:
                break;
            case R.id.ll_myyijian:
                break;
        }
    }
}
