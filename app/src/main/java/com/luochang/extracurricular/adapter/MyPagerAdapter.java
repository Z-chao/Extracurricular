package com.luochang.extracurricular.adapter;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.luochang.extracurricular.CustomProgressBar;
import com.luochang.extracurricular.R;

import java.util.ArrayList;

/**
 * Created by D on 2017/3/16.
 */

public class MyPagerAdapter extends PagerAdapter {
    private final ArrayList<View> mViewList;
    private final ArrayList<String> mTitleList;

    public MyPagerAdapter(ArrayList<View> mViewList, ArrayList<String> mTitleList) {
        this.mViewList = mViewList;
        this.mTitleList = mTitleList;
    }

    @Override
    public int getCount() {
        return mTitleList == null ? 0 : mTitleList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = mViewList.get(position);
        /*TextView tv = (TextView) view.findViewById(R.id.text);
        tv.setText("测试：" +position);*/
        if (TextUtils.equals(mTitleList.get(position), "未完成")) {
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            CustomProgressBar cp_progress = (CustomProgressBar) view.findViewById(R.id.cp_progress);
            tv_name.setText("篮球");
            cp_progress.setCurProgress(0,0);
            cp_progress.setProgressColor(Color.parseColor("#F6CB82"));

        } else {
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            tv_name.setText("足球");
            CustomProgressBar cp_progress = (CustomProgressBar) view.findViewById(R.id.cp_progress);
            cp_progress.setCurProgress(20);
            cp_progress.setProgressColor(Color.parseColor("#F6CB82"));
        }


        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mViewList.get(position));
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitleList.get(position);
    }
}
