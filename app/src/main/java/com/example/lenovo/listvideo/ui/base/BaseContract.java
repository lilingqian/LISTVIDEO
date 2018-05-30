package com.example.lenovo.listvideo.ui.base;

public interface  BaseContract {


    interface  BasePresenter<T extends  BaseView>{

        void  attachView(T view);

        void  detachView();


    }
    interface BaseView{

        void showLoading();

    }


}
