package com.luochang.extracurricular.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

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
        TextView tv = (TextView) view.findViewById(R.id.text);
        tv.setText("测试：" +position);
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
