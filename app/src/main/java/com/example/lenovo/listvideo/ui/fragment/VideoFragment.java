package com.example.lenovo.listvideo.ui.fragment;

import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.example.lenovo.listvideo.R;
import com.example.lenovo.listvideo.bean.ImgBean;
import com.example.lenovo.listvideo.bean.VideoBean;
import com.example.lenovo.listvideo.component.DaggerHttpComponent;
import com.example.lenovo.listvideo.ui.adapter.ImgAdapter;
import com.example.lenovo.listvideo.ui.adapter.VideoAdapter;
import com.example.lenovo.listvideo.ui.base.BaseFragment;
import com.example.lenovo.listvideo.ui.tupain.contract.WeekContract;
import com.example.lenovo.listvideo.ui.tupain.contract.presenter.WeekPresenter;

import java.util.ArrayList;
import java.util.List;

public class VideoFragment extends BaseFragment<WeekPresenter> implements WeekContract.View{

    private List<VideoBean.DataBean> data=new ArrayList<>();
    private VideoAdapter videoAdapter;
    @Override
    public int getContentLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void inject() {
        DaggerHttpComponent.builder()
                .build().inject(this);
    }

    @Override
    public void initView(View view) {
        RecyclerView  rv = view.findViewById(R.id.rv);

        rv.setLayoutManager(new LinearLayoutManager(getContext()));
        rv.addItemDecoration(new DividerItemDecoration(getContext(),RecyclerView.VERTICAL));

        videoAdapter = new VideoAdapter(getContext(), data);
        rv.setAdapter(videoAdapter);
        //先求请求数据

        mPresenter.getVideo();
    }

    @Override
    public void imgSuccess(List<ImgBean.DataBean> data) {

    }

    @Override
    public void videoSuccess(List<VideoBean.DataBean> data) {

        if (videoAdapter!=null){

            videoAdapter.setData(data);
        }

    }
}
