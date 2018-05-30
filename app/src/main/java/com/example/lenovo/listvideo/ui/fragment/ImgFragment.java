package com.example.lenovo.listvideo.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.lenovo.listvideo.MainActivity;
import com.example.lenovo.listvideo.R;
import com.example.lenovo.listvideo.bean.ImgBean;
import com.example.lenovo.listvideo.bean.VideoBean;
import com.example.lenovo.listvideo.component.DaggerHttpComponent;
import com.example.lenovo.listvideo.ui.adapter.ImgAdapter;
import com.example.lenovo.listvideo.ui.base.BaseFragment;
import com.example.lenovo.listvideo.ui.tupain.contract.WeekContract;
import com.example.lenovo.listvideo.ui.tupain.contract.presenter.WeekPresenter;

import java.util.ArrayList;
import java.util.List;

import static android.widget.Toast.LENGTH_SHORT;

public class ImgFragment extends BaseFragment <WeekPresenter> implements WeekContract.View{

    private List<ImgBean.DataBean> data=new ArrayList<>();
    private ImgAdapter imgAdapter;

    @Override
    public int getContentLayout() {
        return  R.layout.fragment_img;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build()
                .inject(this);

    }

    @Override
    public void initView(View view) {


        RecyclerView  rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));

  imgAdapter = new ImgAdapter(getContext(), data);
        rv.setAdapter(imgAdapter);
        //先求请求数据

        mPresenter.getImage();
    }

    @Override
    public void imgSuccess(List<ImgBean.DataBean> data) {

        if (imgAdapter!=null){


            imgAdapter.setData(data);
        }

    }

    @Override
    public void videoSuccess(List<VideoBean.DataBean> data) {

    }
}
