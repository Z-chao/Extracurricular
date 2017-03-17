package com.luochang.extracurricular;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by D on 2017/3/14.
 */

public class CollectionFragment extends Fragment {

    View view;
    @BindView(R.id.radioButton)
    RadioButton radioButton;
    @BindView(R.id.rl_coupons)
    RelativeLayout rlCoupons;
    @BindView(R.id.iv_finish)
    ImageView ivFinish;
    @BindView(R.id.iv_unfinish)
    ImageView ivUnfinish;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_collection, container, false);
        }
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.iv_finish, R.id.iv_unfinish})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iv_finish:
                Intent intent = new Intent(getContext(), HuoDongActivity.class);
                startActivity(intent);
                break;
            case R.id.iv_unfinish:
                Intent unfinish = new Intent(getContext(), HuoDongActivity.class);
                unfinish.putExtra("finish", true);
                startActivity(unfinish);
                break;
        }
    }
}
