package com.luochang.extracurricular.adapter;

import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luochang.extracurricular.R;
import com.luochang.extracurricular.bean.ShuJu;

import java.util.List;

/**
 * Created by D on 2017/4/19.
 */

public class ActivityAdapter extends BaseQuickAdapter<ShuJu,BaseViewHolder> {
    public ActivityAdapter(int layoutResId, List<ShuJu> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ShuJu item) {
        helper.setText(R.id.tv_coll, item.getActiv_name());
        helper.setText(R.id.tv_didian, item.getActiv_dizhi());
        helper.setText(R.id.tv_renshu, item.getPeoplenum());

        ImageView view = helper.getView(R.id.iv_collimg);

        Glide.with(mContext)
                .load(item.getImage())
                .asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(view);

    }
}
