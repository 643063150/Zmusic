package com.zpp.mobile.zmusic.app;

import android.app.Application;


import com.tencent.mmkv.MMKV;
import com.zpp.mobile.zmusic.BuildConfig;
import com.zpp.mobile.zmusic.utils.MusicPlayerUtils;

import rxhttp.RxHttpPlugins;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.app
 * @ClassName: MyApp
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/6 13:53
 * @UpdateUser:
 * @UpdateDate: 2023/3/6 13:53
 * @UpdateRemark:
 */
public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        setOkhttp();
//        setMusicService();
        MMKV.initialize(this);
    }

    /**
     * 初始化
     */
    private void setOkhttp(){
        RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG);
    }

    /**
     * 初始化音乐服务
     */
    private void setMusicService(){
        MusicPlayerUtils.getInstance().setContext(getApplicationContext()).setMusicPlayerUtils();
    }
}
