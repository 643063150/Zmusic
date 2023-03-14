package com.zpp.mobile.zmusic.utils;

import android.content.Context;
import android.util.Log;
import com.zpp.mobile.zmusic.app.MyMusicService;

import snow.player.PlayerClient;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: MusicPlayerUtils
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/13 15:58
 * @UpdateUser:
 * @UpdateDate: 2023/3/13 15:58
 * @UpdateRemark:
 */
public class MusicPlayerUtils {
    private static volatile MusicPlayerUtils musicPlayerUtils;
    public static PlayerClient playerClient;
    Context context;

    public static MusicPlayerUtils getInstance() {
        if (musicPlayerUtils == null) {
            synchronized (MusicPlayerUtils.class) {
                if (musicPlayerUtils == null) {
                    musicPlayerUtils = new MusicPlayerUtils();
                }

            }
        }
        return musicPlayerUtils;
    }

    /**
     * 传入上下文
     *
     * @param context
     * @return
     */
    public MusicPlayerUtils setContext(Context context) {
        this.context = context;
        return musicPlayerUtils;
    }

    /**
     * 创建媒体服务
     */
    public void setMusicPlayerUtils() {
        playerClient = PlayerClient.newInstance(context, MyMusicService.class);
        playerClient.connect(success -> {
            // DEBUG
            Log.d("App", "connect: " + success);
            if (!success) {
                setMusicPlayerUtils();
            }
        });
    }

}
