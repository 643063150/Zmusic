package com.zpp.mobile.zmusic.utils;

import android.app.job.JobInfo;
import android.app.job.JobParameters;
import android.app.job.JobScheduler;
import android.app.job.JobService;
import android.content.ComponentName;
import android.content.Context;
import android.util.Log;


import org.apache.commons.lang3.concurrent.BasicThreadFactory;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import snow.player.lifecycle.PlayerViewModel;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.utils
 * @ClassName: ServiceUtils
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/16 10:35
 * @UpdateUser:
 * @UpdateDate: 2023/3/16 10:35
 * @UpdateRemark:
 */
public class ServiceUtils {
    public static void getMusicStatus(PlayerViewModel playerViewModel){
        ScheduledExecutorService scheduledExecutorService = new ScheduledThreadPoolExecutor(1, new BasicThreadFactory.
                Builder().namingPattern("example-schedule-pool-%d").daemon(true).build());
        scheduledExecutorService.scheduleAtFixedRate(() -> {
            Log.e("连接状态:",playerViewModel.getConnected().getValue()+"");
            Log.e("播放器状态:",playerViewModel.getPlaybackState().getValue()+"");
        }, 0, 1, TimeUnit.SECONDS);
    }
}
