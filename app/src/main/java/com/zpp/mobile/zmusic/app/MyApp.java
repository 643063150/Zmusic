package com.zpp.mobile.zmusic.app;

import android.app.Application;


import com.tencent.mmkv.MMKV;
import com.zpp.mobile.zmusic.BuildConfig;
import com.zpp.mobile.zmusic.db.ObjectBox;
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
//        ObjectBox.init(this);
    }

    /**
     * 初始化
     */
    private void setOkhttp() {
//        RxHttp.get("http://music.zppnet.cn/cookie.json").toObservable(Coookie.class).observeOn(AndroidSchedulers.mainThread()).subscribe(coookie -> {
//            if (coookie.getCode() == 200) {
//                if (!TextUtils.isEmpty(coookie.getCookie())) {
//                    RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG).setOnParamAssembly(param -> param.add("cookie", coookie.getCookie()));
//                    Log.e("刷新:",coookie.getCookie());
//                } else {
//                    RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG);
//                }
//            } else {
//                RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG);
//            }
//        }, throwable -> {
//            RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG);
//            throwable.printStackTrace();
//        });
        RxHttpPlugins.init(null).setDebug(BuildConfig.DEBUG);
    }

}
