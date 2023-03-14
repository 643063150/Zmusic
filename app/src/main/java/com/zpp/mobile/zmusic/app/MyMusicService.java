package com.zpp.mobile.zmusic.app;

import android.content.Context;
import android.net.Uri;

import androidx.annotation.NonNull;

import com.zpp.mobile.zmusic.MusicPlayer.ExoMusicPlayer;

import snow.player.PlayerService;
import snow.player.annotation.PersistenceId;
import snow.player.audio.MusicItem;
import snow.player.audio.MusicPlayer;


/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.app
 * @ClassName: MyMusicService
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/9 13:38
 * @UpdateUser:
 * @UpdateDate: 2023/3/9 13:38
 * @UpdateRemark:
 */
@PersistenceId("ZppMusicService")
public class MyMusicService extends PlayerService {
    @NonNull
    @Override
    protected MusicPlayer onCreateMusicPlayer(@NonNull Context context, @NonNull MusicItem musicItem, @NonNull Uri uri) {
        return new ExoMusicPlayer(context, uri);
    }
}