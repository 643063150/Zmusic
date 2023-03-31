package com.zpp.mobile.zmusic;

import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.blankj.utilcode.util.ConvertUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.leaf.library.StatusBarUtil;
import com.lzf.easyfloat.EasyFloat;
import com.lzf.easyfloat.enums.ShowPattern;
import com.lzf.easyfloat.enums.SidePattern;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.ActivityMainBinding;
import com.zpp.mobile.zmusic.mainfragment.PageAdapter;
import com.zpp.mobile.zmusic.ui.MusicPlayerActivity;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import com.zpp.mobile.zmusic.utils.SongUtils;

import snow.player.PlaybackState;
import snow.player.Player;
import snow.player.audio.MusicItem;
import snow.player.lifecycle.PlayerViewModel;


public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
    PageAdapter pageAdapter;
    private PlayerViewModel mPlayerViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        StatusBarUtil.setTransparentForWindow(this);
        initAllViewModel();
        setContentView(mainBinding.getRoot());
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        setPageAdapter();
    }

    /**
     * 绑定播放器
     */
    private void initAllViewModel() {
        int[] location = new int[2];
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        PlayerUtil.initPlayerViewModel(this, mPlayerViewModel, MyMusicService.class);
        mPlayerViewModel.getPlayerClient().addOnPlaybackStateChangeListener(new Player.OnPlaybackStateChangeListener() {
            @Override
            public void onPlay(boolean stalled, int playProgress, long playProgressUpdateTime) {

            }

            @Override
            public void onPause(int playProgress, long updateTime) {

            }

            @Override
            public void onStop() {

            }

            @Override
            public void onError(int errorCode, String errorMessage) {
                SongUtils.handleError(MainActivity.this, mPlayerViewModel);
            }
        });
        mPlayerViewModel.getPlaybackState().observe(this, playbackState -> {
            switch (playbackState) {
                case PLAYING:
                case PAUSED:
                    mainBinding.mainNav.getLocationOnScreen(location);
                    EasyFloat.with(MainActivity.this)
                            // 设置浮窗xml布局文件/自定义View，并可设置详细信息
                            .setLayout(R.layout.music_flot, view -> {
                                setFloat(view);
                            })
                            // 设置浮窗显示类型，默认只在当前Activity显示，可选一直显示、仅前台显示
                            .setShowPattern(ShowPattern.CURRENT_ACTIVITY)
                            // 设置吸附方式，共15种模式，详情参考SidePattern
                            .setSidePattern(SidePattern.RESULT_HORIZONTAL)
                            // 设置浮窗的标签，用于区分多个浮窗
                            .setTag("musicFloat")
                            // 设置浮窗是否可拖拽
                            .setDragEnable(true)
                            // 浮窗是否包含EditText，默认不包含
                            .hasEditText(false)
                            .setMatchParent(true, false)
                            // 设置浮窗固定坐标，ps：设置固定坐标，Gravity属性和offset属性将无效
                            .setLocation(0, location[1] - ConvertUtils.dp2px(50)).show();
                    break;
                default:
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置首页框架
     */
    public void setPageAdapter() {
        mainBinding.musicViewpage.setOffscreenPageLimit(3);
        pageAdapter = new PageAdapter(this);
        mainBinding.musicViewpage.setAdapter(pageAdapter);
        mainBinding.musicViewpage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mainBinding.mainNav.getMenu().getItem(position).setChecked(true);
            }
        });
        mainBinding.mainNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.home:
                    mainBinding.musicViewpage.setCurrentItem(0, false);
                    break;
                case R.id.song_sheet:
                    mainBinding.musicViewpage.setCurrentItem(1, false);
                    break;
                case R.id.list:
                    mainBinding.musicViewpage.setCurrentItem(2, false);
                    break;
                default:
                    break;
            }
            return false;
        });
    }

    /**
     * @param view
     */
    public void setFloat(View view) {
        TextView title = view.findViewById(R.id.title);
        ImageView ivAlbumIcon = view.findViewById(R.id.ivAlbumIcon);
        mPlayerViewModel.getTitle().observe(this, s -> {
            title.setText(mPlayerViewModel.getTitle().getValue());
        });
        mPlayerViewModel.getPlayingMusicItem()
                .observe(this, musicItem -> {
                    Glide.with(MainActivity.this).load(musicItem.getIconUri()).error(R.mipmap.ic_player_album_default_icon_big).transform(new CenterCrop(), new CircleCrop())
                            .into(ivAlbumIcon);
                });
    }

}