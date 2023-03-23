package com.zpp.mobile.zmusic.app;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import snow.player.HistoryRecorder;
import snow.player.PlayerService;
import snow.player.annotation.PersistenceId;
import snow.player.audio.MusicItem;


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
    @Nullable
    @Override
    protected HistoryRecorder onCreateHistoryRecorder() {
        return musicItem -> {

        };
    }
}
