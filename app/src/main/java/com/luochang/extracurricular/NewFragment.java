package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.luochang.extracurricular.adapter.NewFragmentAdapter;
import com.luochang.extracurricular.bean.NewBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by D on 2017/3/27.
 */

public class NewFragment extends Fragment {
    @BindView(R.id.rv_new)
    RecyclerView rvNew;
    @BindView(R.id.iv_friden)
    ImageView ivFriden;
    private View view;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_new, container, false);
        }
        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {
        rvNew.setLayoutManager(new LinearLayoutManager(getContext()));
        List<NewBean> data = new ArrayList<>();
        data.add(new NewBean(R.drawable.hangmo, "zzzz", "测试数据测试数据测试数据测试数据测试数据测试数据"));
        rvNew.setAdapter(new NewFragmentAdapter(R.layout.item_new, data));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @OnClick(R.id.iv_friden)
    public void onViewClicked() {
        //点击跳转到通讯录的界面





    }
}
