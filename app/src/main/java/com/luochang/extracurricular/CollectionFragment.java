package com.luochang.extracurricular;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.luochang.extracurricular.adapter.CollectAdapter;
import com.luochang.extracurricular.bean.Collect;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by D on 2017/3/14.
 */

public class CollectionFragment extends Fragment {


    @BindView(R.id.rv_collect)
    RecyclerView rvCollect;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (view == null) {
            view = inflater.inflate(R.layout.fragment_collection, container, false);
        }
      ButterKnife.bind(this, view);
        initView();
        return view;
    }

    /**
     *
     */
    private void initView() {
        rvCollect.setLayoutManager(new LinearLayoutManager(getContext()));
        List<Collect> dad = new ArrayList<>();
        dad.add(new Collect("篮球俱乐部",R.drawable.lanqiu,18));
        dad.add(new Collect("篮球俱乐部",R.drawable.lanqiu,10));

        rvCollect.setAdapter(new CollectAdapter(R.layout.item_tex,dad));

    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();


    }
}
