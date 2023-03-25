package com.zpp.mobile.zmusic.app;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.zpp.mobile.zmusic.db.ObjectBox;
import com.zpp.mobile.zmusic.db.entity.Song;

import io.objectbox.Box;
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

    Box<Song> songBox;

    @Override
    public void onCreate() {
        super.onCreate();
        songBox = ObjectBox.get().boxFor(Song.class);
    }
    @Nullable
    @Override
    protected HistoryRecorder onCreateHistoryRecorder() {
        return musicItem -> {
            Song song=new Song();
            Bundle bundle=musicItem.getExtra();
            String songId=bundle.getString("id");
            song.setAlbum(musicItem.getAlbum());
            song.setArtist(musicItem.getArtist());
            song.setDuration(musicItem.getDuration());
            song.setUri(musicItem.getUri());
            song.setSongId(songId);
            song.setIconUri(musicItem.getIconUri());
            song.setTitle(musicItem.getTitle());
            songBox.put(song);
        };
    }
}
