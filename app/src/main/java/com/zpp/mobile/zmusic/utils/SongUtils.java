package com.zpp.mobile.zmusic.utils;

import com.tencent.mmkv.MMKV;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;

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

}
