package com.zpp.mobile.zmusic.ui;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.palette.graphics.Palette;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.chad.library.adapter.base.QuickAdapterHelper;
import com.chad.library.adapter.base.loadState.LoadState;
import com.chad.library.adapter.base.loadState.trailing.TrailingLoadStateAdapter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.gson.Gson;
import com.leaf.library.StatusBarUtil;
import com.tencent.mmkv.MMKV;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HeadAdapter;
import com.zpp.mobile.zmusic.Adapter.SongAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.SongsheetInfoLayoutBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import com.zpp.mobile.zmusic.utils.SongUtils;
import com.zpp.mobile.zmusic.utils.Url;
import com.zpp.mobile.zmusic.view.SongSheetBg;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;

import rxhttp.wrapper.param.RxHttp;
import snow.player.Player;
import snow.player.audio.MusicItem;
import snow.player.lifecycle.PlayerViewModel;
import snow.player.playlist.Playlist;
import snow.player.playlist.PlaylistManager;

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
public class SongSheetInfo extends BaseActivity {
    SongsheetInfoLayoutBinding binding;
    String id;
    SongAdapter setAdapter;
    private PlayerViewModel mPlayerViewModel;
    QuickAdapterHelper helper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = SongsheetInfoLayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.toolbar);
        initAllViewModel();
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        id = getIntent().getStringExtra("id");
        StatusBarUtil.setTransparentForWindow(this);
        StatusBarUtil.setGradientColor(this, binding.toolbar);
        setClick();
        setSongList();
        getList();
        setRefresh();
    }

    /**
     * 绑定播放器
     */
    private void initAllViewModel() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        PlayerUtil.initPlayerViewModel(this, mPlayerViewModel, MyMusicService.class);
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        binding.refresh.setOnRefreshListener(() -> getList());
        setTitle("");
        binding.toolbar.setNavigationIcon(R.drawable.ic_back_nor_w);
        binding.toolbar.setNavigationOnClickListener(v -> finish());
        binding.appBar.addOnOffsetChangedListener((AppBarLayout.BaseOnOffsetChangedListener) (appBarLayout, verticalOffset) -> {
            if (verticalOffset == 0) {
                binding.toolbar.setVisibility(View.INVISIBLE);
            } else if (verticalOffset == -appBarLayout.getTotalScrollRange()) {
                binding.toolbar.setVisibility(View.VISIBLE);
            } else {
                float alpha = verticalOffset / -appBarLayout.getTotalScrollRange();
                binding.toolbar.setVisibility(View.INVISIBLE);
            }
        });
    }

    /**
     * 详情
     */
    private void setBinding(SongSheetInfoEnerty.PlaylistBean playlistBean){
        binding.sheetname.setText(playlistBean.getName());
        binding.introduce.setText(playlistBean.getDescription());
        binding.playCount.setText("播放:"+ SongUtils.convertToTenThousandFormat(playlistBean.getPlayCount()));
        binding.name.setText(playlistBean.getCreator().getNickname());
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

        setAdapter.setOnItemClickListener((songlistBeanBaseQuickAdapter, view, integer) -> {
            getMusicPlayerUrl(integer);
            return null;
        });
        helper = new QuickAdapterHelper.Builder(setAdapter).build();
        binding.songList.setAdapter(helper.getAdapter());
        mPlayerViewModel.getPlayerClient().addOnPlaylistChangeListener(new Player.OnPlaylistChangeListener() {
            @Override
            public void onPlaylistChanged(PlaylistManager playlistManager, int position) {
                playlistManager.getPlaylist(new PlaylistManager.Callback() {
                    @Override
                    public void onFinished(Playlist playlist) {
                        Log.e("播放列表", playlist.size() + "");
                    }
                });
            }
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
                } catch (Exception e) {
                    e.printStackTrace();
                    try {
                        hexColor = String.format("#%06X", (0xFFFFFF & palette.getDarkVibrantSwatch().getRgb()));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                        hexColor = "#FFBB86FC";
                    }
                }
                binding.imageView2.setBackground(SongSheetBg.getDrawable(Color.parseColor(hexColor)));
                binding.toolbar.setBackground(SongSheetBg.getDrawable(Color.parseColor(hexColor)));
                return false;
            }
        }).load(cover).into(binding.ivIcon);

    }

    /**
     * 获取歌曲mid组
     *
     * @return
     */
    private String setSongMid() {
        String mids = "";
        for (int i = 0; i < setAdapter.getItems().size(); i++) {
            mids = mids + "," + setAdapter.getItems().get(i).getId();
        }
        if (mids.startsWith(",")) {
            mids = mids.substring(1);
        }
        return mids;
    }

    private void setClick() {

    }

    /**
     * 缓存当前歌单
     */
    private void playSongSheet(int integer, PlayUrlsEnerty playUrlsEnerty) {
        MMKV.defaultMMKV().putString("playlistInfo", setSongMid());
        ArrayList<MusicItem> arrayList = new ArrayList<>();
        for (int i = 0; i < setAdapter.getItems().size(); i++) {
            SongSheetInfoEnerty.PlaylistBean.TracksBean songlistBean = setAdapter.getItems().get(i);
            for (int j = 0; j < playUrlsEnerty.getData().size(); j++) {
                PlayUrlsEnerty.DataBean dataBean = playUrlsEnerty.getData().get(j);
                if (dataBean.getId().equals(songlistBean.getId())) {
                    Bundle bundle = new Bundle();
                    bundle.putString("id", songlistBean.getId());
                    MusicItem song = new MusicItem.Builder()
                            .setTitle(songlistBean.getName())
                            .setArtist(songlistBean.getAr().get(0).getName())
                            .setAlbum(songlistBean.getAl().getName())
                            .setDuration(dataBean.getTime())
                            .setUri(dataBean.getUrl() == null ? "" : dataBean.getUrl())
                            .setIconUri(songlistBean.getAl().getPicUrl())
                            .setExtra(bundle)
                            .build();
                    arrayList.add(song);
                }
            }
        }
        if (arrayList.size() != 0) {
            Playlist playlist = new Playlist("", arrayList, true, null);
            mPlayerViewModel.getPlayerClient().setPlaylist(playlist, integer, true);
        }
    }

    /**
     * 获取歌单歌曲
     */
    private void getList() {
        RxHttp.get(Url.songsheetinfo).add("id", id).toObservable(SongSheetInfoEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(songSheetInfoEnerty -> {
            binding.refresh.setRefreshing(false);
            setBg(songSheetInfoEnerty.getPlaylist().getCoverImgUrl());
            setBinding(songSheetInfoEnerty.getPlaylist());
            setAdapter.submitList(songSheetInfoEnerty.getPlaylist().getTracks());
        }, throwable -> {
            throwable.printStackTrace();
            binding.refresh.setRefreshing(false);
        });
    }

    /**
     * 获取播放链接
     */
    private void getMusicPlayerUrl(int integer) {
        RxHttp.get(Url.songPlyer).add("id", setSongMid()).add("level", "exhigh").add("timestamp", System.currentTimeMillis()).toObservable(PlayUrlsEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            playSongSheet(integer, s);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }
}
