package com.example.lenovo.listvideo.ui.tupain.contract.presenter;

import com.example.lenovo.listvideo.bean.ImgBean;
import com.example.lenovo.listvideo.bean.VideoBean;
import com.example.lenovo.listvideo.net.WeekApi;
import com.example.lenovo.listvideo.ui.base.BasePresenter;
import com.example.lenovo.listvideo.ui.fragment.ImgFragment;
import com.example.lenovo.listvideo.ui.tupain.contract.WeekContract;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

public class WeekPresenter extends BasePresenter<WeekContract.View> implements WeekContract.Presenter{

    private WeekApi weekApi;

    @Inject
    public  WeekPresenter(WeekApi weekApi){
        this.weekApi=weekApi;
    }


    @Override
    public void getImage() {

        weekApi.getImage()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<ImgBean, List<ImgBean.DataBean>>() {
                    @Override
                    public List<ImgBean.DataBean> apply(ImgBean imgBean) throws Exception {
                        return imgBean.getData();
                    }
                }).subscribe(new Consumer<List<ImgBean.DataBean>>() {
            @Override
            public void accept(List<ImgBean.DataBean> dataBeans) throws Exception {


                if (mView!=null){

                     mView.imgSuccess(dataBeans);
                }
            }
        });
    }


    @Override
    public void getVideo() {

        weekApi.getVideo()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Function<VideoBean, List<VideoBean.DataBean>>() {
                    @Override
                    public List<VideoBean.DataBean> apply(VideoBean videoBean) throws Exception {
                        return videoBean.getData();
                    }
                }).subscribe(new Consumer<List<VideoBean.DataBean>>() {
            @Override
            public void accept(List<VideoBean.DataBean> dataBeans) throws Exception {

                if (mView!=null){
                    mView.videoSuccess(dataBeans);
                }
            }
        });
    }


}
