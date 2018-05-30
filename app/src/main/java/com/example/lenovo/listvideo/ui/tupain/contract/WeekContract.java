package com.example.lenovo.listvideo.ui.tupain.contract;

import com.example.lenovo.listvideo.bean.ImgBean;
import com.example.lenovo.listvideo.bean.VideoBean;
import com.example.lenovo.listvideo.ui.base.BaseContract;

import java.util.List;

public interface WeekContract {

    interface  View extends BaseContract.BaseView{

        void imgSuccess(List<ImgBean.DataBean> data);

        void videoSuccess(List<VideoBean.DataBean> data);

    }

    interface  Presenter extends BaseContract.BasePresenter<View>{

        void getImage();
        void getVideo();

    }
}
