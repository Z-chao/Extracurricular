package com.luochang.extracurricular.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luochang.extracurricular.R;
import com.luochang.extracurricular.bean.ActivityFBean;

import java.util.List;

/**
 * Created by D on 2017/3/15.
 */

public class AcFragmentAdapter extends BaseQuickAdapter<ActivityFBean,BaseViewHolder> {

    private final List<ActivityFBean> data;

    public AcFragmentAdapter(int layoutResId, List<ActivityFBean> data) {
        super(layoutResId, data);
        this.data = data;
    }


    @Override
    protected void convert(BaseViewHolder helper, ActivityFBean item) {
        helper.setText(R.id.tv_yiji, item.getYiji())
                .setText(R.id.tv_erji1, item.getErji1())
                .setText(R.id.tv_erji2, item.getErji2())
                .setText(R.id.tv_erji3, item.getErji3())
                .setText(R.id.tv_erji4, item.getErji4());

    }
}
