package com.example.lenovo.listvideo.net;

import com.example.lenovo.listvideo.bean.ImgBean;
import com.example.lenovo.listvideo.bean.VideoBean;

import io.reactivex.Observable;


public class WeekApi {

    private  static WeekApi weekApi;
    private WeekApiService weekApiService;


     public  WeekApi(WeekApiService weekApiService){
         this.weekApiService =weekApiService;
     }



     public  static  WeekApi getWeekApi(WeekApiService weekApiService){

         if (weekApi==null){

             weekApi=new WeekApi(weekApiService);
         }
         return weekApi;

     }

     public Observable<ImgBean> getImage(){

         return weekApiService.getImage();
     }

     public  Observable<VideoBean> getVideo(){

         return weekApiService.getVideo();
     }
}
