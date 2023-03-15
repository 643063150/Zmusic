package com.zpp.mobile.zmusic.ui;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.palette.graphics.Palette;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.leaf.library.StatusBarUtil;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.MusicPlayerBinding;
import com.zpp.mobile.zmusic.utils.AlbumIconAnimManager;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import com.zpp.mobile.zmusic.view.SongSheetBg;

import snow.player.PlaybackState;
import snow.player.lifecycle.PlayerViewModel;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: MusicPlayerActivity
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/13 15:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/13 15:15
 * @UpdateRemark:
 */
public class MusicPlayerActivity extends BaseActivity {
    MusicPlayerBinding binding;
    private PlayerViewModel mPlayerViewModel;
    private AlbumIconAnimManager mAlbumIconAnimManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = MusicPlayerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        StatusBarUtil.setGradientColor(this, binding.toolbar);
        initAllViewModel();
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        mAlbumIconAnimManager = new AlbumIconAnimManager(binding.ivAlbumIcon, this, mPlayerViewModel);
        setClick();
        setView();
    }

    private void setClick() {
        binding.btnNext.setOnClickListener(v -> {
            mPlayerClient.skipToNext();
        });
        binding.btnLast.setOnClickListener(v -> {
            mPlayerClient.skipToPrevious();
        });
        binding.btnPlayPause.setOnClickListener(v -> {
            mPlayerClient.playPause();
        });
    }

    /**
     * 配置view
     */
    private void setView() {
        binding.tvTitle.setText(mPlayerViewModel.getTitle().getValue());
        binding.tvArtist.setText(mPlayerViewModel.getArtist().getValue());
        mPlayerViewModel.getPlaybackState().observe(this, playbackState -> {
            if (playbackState == PlaybackState.PLAYING) {
                binding.btnPlayPause.setImageResource(R.mipmap.ic_pause);
            } else {
                binding.btnPlayPause.setImageResource(R.mipmap.ic_play);
            }
        });
        mPlayerViewModel.getTitle().observe(this, s -> {
            binding.tvTitle.setText(mPlayerViewModel.getTitle().getValue());
            binding.tvArtist.setText(mPlayerViewModel.getArtist().getValue());
        });
        mPlayerViewModel.getPlayingMusicItem()
                .observe(this, musicItem -> {
                    mAlbumIconAnimManager.reset();
                    if (musicItem == null) {
                        binding.ivAlbumIcon.setImageResource(R.mipmap.ic_player_album_default_icon_big);
                        return;
                    }
                    Glide.with(MusicPlayerActivity.this).asBitmap().addListener(new RequestListener<Bitmap>() {
                        @Override
                        public boolean onLoadFailed(@Nullable GlideException e, Object model, Target<Bitmap> target, boolean isFirstResource) {
                            binding.bg.setBackground(SongSheetBg.getDrawable(getColor(R.color.purple_200)));
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(Bitmap resource, Object model, Target<Bitmap> target, DataSource dataSource, boolean isFirstResource) {
                            Palette palette = Palette.from(resource).generate();
                            String hexColor;
                            try {
                                hexColor = String.format("#%06X", (0xFFFFFF & palette.getLightMutedSwatch().getRgb()));
                            } catch (Exception e) {
                                e.printStackTrace();
                                try {
                                    hexColor = String.format("#%06X", (0xFFFFFF & palette.getLightVibrantSwatch().getRgb()));
                                }catch (Exception e1){
                                    e1.printStackTrace();
                                    hexColor = "FFBB86FC";
                                }
                            }
                            binding.bg.setBackground(SongSheetBg.getDrawable(Color.parseColor(hexColor)));
                            return false;
                        }
                    }).load(musicItem.getIconUri()).error(R.mipmap.ic_player_album_default_icon_big).transform(new CenterCrop(), new CircleCrop())
                            .into(binding.ivAlbumIcon);

                });
        mPlayerViewModel.getDuration().observe(this, integer -> binding.musicSeek.setMax(integer));
        binding.musicSeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                mPlayerViewModel.onStartTrackingTouch(seekBar);
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("拖动",seekBar.getProgress()+"");
                mPlayerViewModel.onStopTrackingTouch(seekBar);
            }
        });
        mPlayerViewModel.getPlayProgress().observe(this, integer -> binding.musicSeek.setProgress(integer));
        mPlayerViewModel.getTextPlayProgress().observe(this, s -> {
            binding.tvTextProgress.setText(s);
        });
        mPlayerViewModel.getTextDuration().observe(this, s -> binding.tvTextDuration.setText(s));
    }

    /**
     * 绑定播放器
     */
    private void initAllViewModel() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        PlayerUtil.initPlayerViewModel(this, mPlayerViewModel, MyMusicService.class);
    }
}
