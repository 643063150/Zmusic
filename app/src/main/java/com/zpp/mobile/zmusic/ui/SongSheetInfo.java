package com.zpp.mobile.zmusic.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.leaf.library.StatusBarUtil;
import com.tencent.mmkv.MMKV;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HomeAdapter;
import com.zpp.mobile.zmusic.Adapter.SongAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.SongsheetInfoLayoutBinding;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;
import com.zpp.mobile.zmusic.utils.MusicPlayerUtils;
import com.zpp.mobile.zmusic.utils.SongUtils;
import com.zpp.mobile.zmusic.utils.Url;
import com.zpp.mobile.zmusic.view.SongSheetBg;

import org.json.JSONObject;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import rxhttp.wrapper.param.RxHttp;
import snow.player.audio.MusicItem;
import snow.player.audio.MusicPlayer;
import snow.player.playlist.Playlist;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: SongSheetInfo
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 14:11
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 14:11
 * @UpdateRemark:
 */
public class SongSheetInfo extends AppCompatActivity {
    SongsheetInfoLayoutBinding binding;
    String id;
    SongAdapter setAdapter;
    JsonObject dataJsonObject;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SongsheetInfoLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        id = getIntent().getStringExtra("id");
        StatusBarUtil.setGradientColor(this, binding.toolbar);
        setClick();
        setSongList();
        getList();
        setRefresh();
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        binding.refresh.setOnRefreshListener(() -> getList());
    }


    /**
     * 获取歌曲
     */
    private void setSongList() {
        binding.songList.setLayoutManager(new LinearLayoutManager(this));
        binding.songList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.parseColor("#00000000"))
                        .sizeResId(R.dimen.dividers)
                        .build());
        setAdapter = new SongAdapter();
        binding.songList.setAdapter(setAdapter);
        setAdapter.setOnItemClickListener((songlistBeanBaseQuickAdapter, view, integer) -> {
            getMusicPlayerUrl(integer);
//            MusicItem song = new MusicItem.Builder()
//                    .setTitle("111")
//                    .setArtist("111")
//                    .setAlbum("111")
//                    .autoDuration()
//                    .setUri("http://isure.stream.qqmusic.qq.com/C400002ORbbT3FynhJ.m4a?guid=2796982635&vkey=B30C73AF8CF88AF8964FCCE0D2F39348E0FCF5E4AF9208D36FDFC3634389DFEEC2AE4F48B46124491EA05D73BEA6320B26EE596588D9CBF1&uin=&fromtag=120032")
//                    .setIconUri("")
//                    .build();
//           Playlist playlist= new Playlist.Builder().append(song).build();
//            MusicPlayerUtils.playerClient.setPlaylist(playlist, true);
            return null;
        });
    }

    /**
     * 设置状态栏颜色
     *
     * @param cover
     */
    @SuppressLint("CheckResult")
    private void setBg(String cover) {

        Glide.with(this).asBitmap().addListener(new RequestListener<Bitmap>() {
            @Override
            public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                binding.toolbar.setBackground(SongSheetBg.getDrawable(getColor(R.color.purple_200)));
                return false;
            }

            @Override
            public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                Palette palette = Palette.from(resource).generate();
                String hexColor;
                try {
                    hexColor = String.format("#%06X", (0xFFFFFF & palette.getDarkMutedSwatch().getRgb()));
                }catch (Exception e){
                    e.printStackTrace();
                    hexColor = String.format("#%06X", (0xFFFFFF & palette.getDarkVibrantSwatch().getRgb()));
                }
                binding.toolbar.setBackground(SongSheetBg.getDrawable(Color.parseColor(hexColor)));
                return false;
            }
        }).load(cover).into(binding.bg);

    }

    /**
     * 获取歌曲mid组
     * @return
     */
    private String  setSongMid(){
        String mids="";
        for ( int i=0;i<setAdapter.getItems().size();i++){
             mids=mids+","+setAdapter.getItems().get(i).getSongmid();
        }
        if (mids.startsWith(",")){
            mids=mids.substring(1,mids.length());
        }
        return mids;
    }

    private void setClick() {
        binding.back.setOnClickListener(v -> finish());
    }

    /**
     * 缓存当前歌单
     */
    private void playSongSheet(int integer){
        MMKV.defaultMMKV().putString("playlist",id);
        MMKV.defaultMMKV().putString("playlistInfo",dataJsonObject.toString());
        ArrayList<MusicItem> arrayList=new ArrayList<>();
        for (int i=0;i<setAdapter.getItems().size();i++){
            String mid=setAdapter.getItems().get(i).getSongmid();
            SongSheetInfoEnerty.DataBean.SonglistBean songlistBean=setAdapter.getItems().get(i);
            String playUrl;
            if (dataJsonObject.get(mid)==null){
                playUrl="";
            }else {
                playUrl=dataJsonObject.get(mid).toString();
                if (playUrl.startsWith("\"")){
                    playUrl=playUrl.substring(1,playUrl.length());
                }
                if (playUrl.equals("\"")){
                    playUrl=playUrl.substring(playUrl.length()-1);
                }
            }
            MusicItem song = new MusicItem.Builder()
                    .setTitle(songlistBean.getSongname())
                    .setArtist(songlistBean.getSinger().get(0).getName())
                    .setAlbum(songlistBean.getAlbumname())
                    .autoDuration()
                    .setUri(playUrl)
                    .setIconUri(SongUtils.getSongCover(setAdapter.getItems().get(i).getAlbummid()))
                    .build();
            arrayList.add(song);
        }
        Playlist playlist=new Playlist("",arrayList,true,null);
        MusicPlayerUtils.playerClient.setPlaylist(playlist, integer,true);
    }

    /**
     * 获取歌单歌曲
     */
    private void getList() {
        RxHttp.get(Url.songsheetinfo).add("id", id).toObservable(SongSheetInfoEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(songSheetInfoEnerty -> {
            binding.refresh.setRefreshing(false);
            setBg(songSheetInfoEnerty.getData().getLogo());
            setAdapter.submitList(songSheetInfoEnerty.getData().getSonglist());
        }, throwable -> {
            throwable.printStackTrace();
            binding.refresh.setRefreshing(false);
        });
    }

    /**
     * 获取播放链接
     */
    private void getMusicPlayerUrl(int integer){
        RxHttp.postForm(Url.songPlyer).add("id",setSongMid()).toObservable(String.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            JsonObject jsonObject=new Gson().fromJson(s,JsonObject.class);
            dataJsonObject=jsonObject.getAsJsonObject("data");
            playSongSheet(integer);
        },throwable -> {
            throwable.printStackTrace();
        });
    }
}
