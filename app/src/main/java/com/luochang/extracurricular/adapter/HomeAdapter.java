package com.luochang.extracurricular.adapter;

import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luochang.extracurricular.R;
import com.luochang.extracurricular.bean.HomeBean;

import java.util.HashMap;
import java.util.List;

/**
 * Created by D on 2017/3/15.
 */

public class HomeAdapter extends BaseQuickAdapter<HomeBean,BaseViewHolder> {


    private  List<HomeBean> data;

    public HomeAdapter(int layoutResId, List<HomeBean> data) {
        super(layoutResId, data);
    }


    @Override
    protected void convert(BaseViewHolder helper, HomeBean item) {
        helper.setText(R.id.tv_name, item.getHomeName());
        ImageView view = helper.getView(R.id.iv_im);
        Glide.with(mContext)
                .load(item.getIma())
                .asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(view);

    }

    




}
