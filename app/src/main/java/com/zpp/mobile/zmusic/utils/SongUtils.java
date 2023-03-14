package com.zpp.mobile.zmusic.utils;

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
     * 获取歌曲封面
     * @param mid
     * @return
     */
    public static String getSongCover(String mid){
        String url="https://y.qq.com/music/photo_new/T002R300x300M000"+ mid +".jpg";
        return  url;
    }
}
