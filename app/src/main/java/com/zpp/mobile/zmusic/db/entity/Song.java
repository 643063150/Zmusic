package com.zpp.mobile.zmusic.db.entity;


import io.objectbox.annotation.Entity;
import io.objectbox.annotation.Id;

/**
 * @ProjectName: ObjectBoxTest
 * @Package: com.zpp.mobile.objectboxtest.db.entity
 * @ClassName: Song
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/24 9:59
 * @UpdateUser:
 * @UpdateDate: 2023/3/24 9:59
 * @UpdateRemark:
 */
@Entity
public class Song {
    @Id
    public long id;

    public String songId;

    public String songName;

    public String title;

    public String artist;

    public long getListenTime() {
        return listenTime;
    }

    public void setListenTime(long listenTime) {
        this.listenTime = listenTime;
    }

    public String album;

    public long listenTime;

    public String getSongId() {
        return songId;
    }

    public void setSongId(String songId) {
        this.songId = songId;
    }

    private String uri;

    private String iconUri;

    private int duration;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSongName() {
        return songName;
    }

    public void setSongName(String songName) {
        this.songName = songName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getIconUri() {
        return iconUri;
    }

    public void setIconUri(String iconUri) {
        this.iconUri = iconUri;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
