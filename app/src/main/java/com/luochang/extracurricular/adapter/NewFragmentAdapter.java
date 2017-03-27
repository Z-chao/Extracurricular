package com.luochang.extracurricular.adapter;


import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.luochang.extracurricular.R;
import com.luochang.extracurricular.bean.NewBean;

import java.util.List;

/**
 * Created by D on 2017/3/27.
 */

public class NewFragmentAdapter extends BaseQuickAdapter<NewBean,BaseViewHolder> {


    private final List<NewBean> data;

    public NewFragmentAdapter(int layoutResId, List data) {
        super(layoutResId, data);
        this.data = data;
    }



    @Override
    protected void convert(BaseViewHolder helper, NewBean item) {
        helper.setText(R.id.tv_newname, item.getName());
        helper.setText(R.id.tv_newtime, "下午 12 : 00");
        helper.setText(R.id.tv_mesg, item.getMesg());

        ImageView view = helper.getView(R.id.iv_new);
        view.setImageResource(item.getImage());
    }


}
