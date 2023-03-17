package com.zpp.mobile.zmusic.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.leaf.library.StatusBarUtil;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.SearchSongAdapter;
import com.zpp.mobile.zmusic.Adapter.SongAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.SerachLayoutBinding;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.enerty.SearchEnerty;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import com.zpp.mobile.zmusic.utils.Url;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Consumer;
import rxhttp.wrapper.param.RxHttp;
import snow.player.audio.MusicItem;
import snow.player.lifecycle.PlayerViewModel;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: SearchActivity
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/17 15:22
 * @UpdateUser:
 * @UpdateDate: 2023/3/17 15:22
 * @UpdateRemark:
 */
public class SearchActivity extends BaseActivity {
    SerachLayoutBinding binding;
    SearchSongAdapter searchSongAdapter;
    private PlayerViewModel mPlayerViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = SerachLayoutBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initAllViewModel();
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        StatusBarUtil.setGradientColor(this, binding.rlAction);
        setBinding();
        setSearchSongAdapter();
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
     * 视图操作
     */
    private void setBinding() {
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                search(s.toString().trim());
            }
        });
        binding.tvCancel.setOnClickListener(v -> {
            finish();
        });
        binding.ivSearchDelete.setOnClickListener(v -> binding.etSearch.setText(""));
    }

    private void setSearchSongAdapter() {
        binding.songList.setLayoutManager(new LinearLayoutManager(this));
        binding.songList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(this)
                        .color(Color.parseColor("#00000000"))
                        .sizeResId(R.dimen.dividers)
                        .build());
        searchSongAdapter = new SearchSongAdapter();
        binding.songList.setAdapter(searchSongAdapter);
        searchSongAdapter.setOnItemClickListener((songlistBeanBaseQuickAdapter, view, integer) -> {
            SearchEnerty.ResultBean.SongsBean songsBean = searchSongAdapter.getItems().get(integer);
            String songId = songsBean.getId();

            getMusicPlayerUrl(songId, songsBean);
            return null;
        });
    }

    /**
     *
     */
    public void search(String key) {
        RxHttp.get(Url.search).add("keywords", key).toObservable(SearchEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(searchEnerty -> {
            searchSongAdapter.submitList(searchEnerty.getResult().getSongs());
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

    /**
     * 获取播放链接
     */
    private void getMusicPlayerUrl(String songId, SearchEnerty.ResultBean.SongsBean songsBean) {
        RxHttp.postForm(Url.songPlyer).add("id", songId).add("level", "exhigh").toObservable(PlayUrlsEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            PlayUrlsEnerty.DataBean dataBean = s.getData().get(0);
            MusicItem song = new MusicItem.Builder()
                    .setTitle(songsBean.getName())
                    .setArtist(songsBean.getArtists().get(0).getName())
                    .setAlbum(songsBean.getAlbum().getName())
                    .setDuration(songsBean.getDuration())
                    .setUri(dataBean.getUrl() == null ? "" : dataBean.getUrl())
                    .setIconUri(songsBean.getAlbum().getArtist().getImg1v1Url())
                    .build();
            mPlayerViewModel.getPlayerClient().setNextPlay(song);
            mPlayerViewModel.getPlayerClient().skipToPosition(mPlayerViewModel.getPlayPosition().getValue()+1);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }
}
