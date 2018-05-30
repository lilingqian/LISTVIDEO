package com.example.lenovo.listvideo.component;

import com.example.lenovo.listvideo.module.HttpModule;
import com.example.lenovo.listvideo.ui.fragment.ImgFragment;
import com.example.lenovo.listvideo.ui.fragment.VideoFragment;

import dagger.Component;

@Component(modules = HttpModule.class)
public interface HttpComponent {

    void inject(ImgFragment  imgFragment);
    void  inject(VideoFragment videoFragment);


}
