package com.zpp.mobile.zmusic.utils;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.NonNull;

import com.tencent.mmkv.MMKV;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

import rxhttp.wrapper.param.RxHttp;
import snow.player.audio.MusicItem;
import snow.player.lifecycle.PlayerViewModel;
import snow.player.playlist.Playlist;
import snow.player.playlist.PlaylistManager;

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
     *
     * @param songEnertyArrayList
     * @return
     */
    public static String getHomeSongId(ArrayList<HomeSongEnerty.ResultBean> songEnertyArrayList) {
        String mids = "";
        for (int i = 0; i < songEnertyArrayList.size(); i++) {
            mids = mids + "," + songEnertyArrayList.get(i).getId();
        }
        if (mids.startsWith(",")) {
            mids = mids.substring(1);
        }
        return mids;
    }

    /**
     * 毫秒换算
     *
     * @param duration
     * @return
     */
    public String convertMillis(@NotNull long duration) {
        long hour = duration / 3600;
        long minute = (duration % 3600) / 60;
        long second = (duration % 3600) % 60;
        String hourStr = hour == 0 ? "00" : hour > 10 ? hour + "" : "0" + hour;
        String minuteStr = minute == 0 ? "00" : minute > 10 ? minute + "" : "0" + minute;
        String secondStr = second == 0 ? "00" : second > 10 ? second + "" : "0" + second;
        return hourStr + ":" + minuteStr + ":" + secondStr;

    }

    public static String convertToTenThousandFormat(long number) {
        String FORMAT = "%.0f万";
        if (number < 10000) {
            return String.valueOf(number);
        } else {
            double result = (double) number / 10000;
            return String.format(FORMAT, result);
        }
    }


    /**
     * 播放链接过期时重新获取播放链接
     * @param context
     * @param playerViewModel
     */
    public static void handleError(Context context, PlayerViewModel playerViewModel) {

        playerViewModel.getPlayerClient().getPlaylist(playlist -> {
            String mids = "";
            for (int i = 0; i < playlist.size(); i++) {
                Bundle bundle = playlist.get(i).getExtra();
                mids = mids + "," + bundle.getString("id");
            }
            if (mids.startsWith(",")) {
                mids = mids.substring(1);
            }
            RxHttp.get(Url.songPlyer).add("id", mids).add("level", "exhigh").add("timestamp", System.currentTimeMillis()).toObservable(PlayUrlsEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
                ArrayList<MusicItem> arrayList = new ArrayList<>();
                for (int i = 0; i < playlist.size(); i++) {
                    MusicItem musicItem = playlist.get(i);
                    Bundle bundle = musicItem.getExtra();
                    String id = bundle.getString("id");
                    for (int j = 0; j < s.getData().size(); j++) {
                        PlayUrlsEnerty.DataBean dataBean = s.getData().get(j);
                        if (id.equals(s.getData().get(j).getId())) {
                            MusicItem song = new MusicItem.Builder()
                                    .setTitle(musicItem.getTitle())
                                    .setArtist(musicItem.getArtist())
                                    .setAlbum(musicItem.getAlbum())
                                    .setDuration(musicItem.getDuration())
                                    .setUri(dataBean.getUrl() == null ? "" : dataBean.getUrl())
                                    .setIconUri(musicItem.getIconUri())
                                    .setExtra(bundle)
                                    .build();
                            arrayList.add(song);
                        }
                    }
                }
                if (arrayList.size() != 0) {
                    int integer = playerViewModel.getPlayPosition().getValue();
                    Playlist playlists = new Playlist("", arrayList, true, null);
                    playerViewModel.getPlayerClient().setPlaylist(playlists, integer, true);
                }
            }, throwable -> {
                throwable.printStackTrace();
            });
        });
    }

}
