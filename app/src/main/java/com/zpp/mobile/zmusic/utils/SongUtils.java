package com.zpp.mobile.zmusic.utils;

import com.tencent.mmkv.MMKV;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import snow.player.audio.MusicItem;
import snow.player.playlist.Playlist;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.utils
 * @ClassName: SongUtils
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/13 14:28
 * @UpdateUser:
 * @UpdateDate: 2023/3/13 14:28
 * @UpdateRemark:
 */
public class SongUtils {
    /**
     * 首页歌曲id集合
     * @param songEnertyArrayList
     * @return
     */
     public static String getHomeSongId(ArrayList<HomeSongEnerty.ResultBean> songEnertyArrayList ){
         String mids="";
         for ( int i=0;i<songEnertyArrayList.size();i++){
             mids=mids+","+songEnertyArrayList.get(i).getId();
         }
         if (mids.startsWith(",")){
             mids=mids.substring(1);
         }
         return mids;
     }

    /**
     * 毫秒换算
     * @param duration
     * @return
     */
    public String convertMillis (@NotNull long duration) {
            long hour = duration/ 3600;
            long minute = (duration % 3600) / 60;
            long second = (duration % 3600) % 60;
            String hourStr = hour == 0 ? "00" : hour > 10 ? hour + "" : "0" + hour;
            String minuteStr = minute == 0 ? "00" : minute > 10 ? minute + "" : "0" + minute;
            String secondStr = second == 0 ? "00" : second > 10 ? second + "" : "0" + second;
            return hourStr + ":" + minuteStr + ":" + secondStr;

    }

}
