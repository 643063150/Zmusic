package com.zpp.mobile.zmusic.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;

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
import com.zpp.mobile.zmusic.search.SearchSheetFragment;
import com.zpp.mobile.zmusic.search.SearchSongFragment;
import com.zpp.mobile.zmusic.ui.modelview.SearchModelView;
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
    private PlayerViewModel mPlayerViewModel;
    SearchModelView searchModelView;
    SearchSongFragment searchSongFragment;
    SearchSheetFragment searchSheetFragment;
    SearchPageAdapter searchPageAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding = SerachLayoutBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        initAllViewModel();
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        StatusBarUtil.setTransparentForWindow(this);
        StatusBarUtil.setPaddingTop(this,binding.view);
        setBinding();
    }

    /**
     * 绑定播放器
     */
    private void initAllViewModel() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        searchModelView = viewModelProvider.get(SearchModelView.class);
        PlayerUtil.initPlayerViewModel(this, mPlayerViewModel, MyMusicService.class);
    }

    /**
     * 视图操作
     */
    private void setBinding() {
        searchPageAdapter=new SearchPageAdapter(getSupportFragmentManager());
        binding.searchPage.setAdapter(searchPageAdapter);
        binding.tlTabs.setViewPager(binding.searchPage);
        binding.etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                searchModelView.getKey().setValue(s.toString().trim());
            }
        });
        binding.tvCancel.setOnClickListener(v -> {
            finish();
        });
        binding.ivSearchDelete.setOnClickListener(v -> binding.etSearch.setText(""));
        searchModelView.getSongId().observe(this, s -> {
            getMusicPlayerUrl(s.getId(), s);
        });
    }

    /**
     * 获取播放链接
     */
    private void getMusicPlayerUrl(String songId, SearchEnerty.ResultBean.SongsBean songsBean) {
        RxHttp.postForm(Url.songPlyer).add("id", songId).add("level", "exhigh").add("timestamp",System.currentTimeMillis()).toObservable(PlayUrlsEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            if (s.getData().size()!=0){
                PlayUrlsEnerty.DataBean dataBean = s.getData().get(0);
                MusicItem song = new MusicItem.Builder()
                        .setTitle(songsBean.getName())
                        .setArtist(songsBean.getAr().get(0).getName())
                        .setAlbum(songsBean.getAl().getName())
                        .setDuration(songsBean.getDt())
                        .setUri(dataBean.getUrl() == null ? "" : dataBean.getUrl())
                        .setIconUri(songsBean.getAl().getPicUrl())
                        .build();
                mPlayerViewModel.getPlayerClient().setNextPlay(song);
                mPlayerViewModel.getPlayerClient().skipToPosition(mPlayerViewModel.getPlayPosition().getValue() + 1);
            }
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

    private class SearchPageAdapter extends FragmentPagerAdapter {


        public SearchPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    if (searchSongFragment == null) {
                        searchSongFragment = SearchSongFragment.getInstance();
                    }
                    return searchSongFragment;
                case 1:
                    if (searchSheetFragment == null) {
                        searchSheetFragment = SearchSheetFragment.getInstance();
                    }
                    return searchSheetFragment;
                default:
                    break;
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "单曲";

                case 1:
                    return "歌单";
                default:
                    break;
            }
            return null;
        }
    }
}
