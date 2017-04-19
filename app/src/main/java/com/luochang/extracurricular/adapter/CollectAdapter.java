package com.luochang.extracurricular.adapter;


import android.graphics.Color;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luochang.extracurricular.CustomProgressBar;
import com.luochang.extracurricular.R;
import com.luochang.extracurricular.bean.Collect;

import java.util.List;

/**
 * Created by D on 2017/4/19.
 */

public class CollectAdapter extends BaseQuickAdapter<Collect,BaseViewHolder> {
    public CollectAdapter(int layoutResId, List<Collect> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Collect item) {

        helper.setText(R.id.tv_name, item.getName());
        CustomProgressBar progress = helper.getView(R.id.cp_progress);
        progress.setCurProgress(item.getProgress(),0);
        progress.setProgressColor(Color.YELLOW);

        ImageView view = helper.getView(R.id.iv_im);

        Glide.with(mContext)
                .load(item.getImag())
                .asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(view);

    }


}
