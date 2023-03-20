package com.zpp.mobile.zmusic.mainfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.QuickAdapterHelper;
import com.chad.library.adapter.base.loadState.leading.LeadingLoadStateAdapter;
import com.leaf.library.StatusBarUtil;
import com.stx.xhb.androidx.transformers.Transformer;
import com.tencent.mmkv.MMKV;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HeadAdapter;
import com.zpp.mobile.zmusic.Adapter.HomeAdapter;
import com.zpp.mobile.zmusic.Adapter.HomeHeadAdapter;
import com.zpp.mobile.zmusic.Adapter.RecommendAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.HomeFragmentBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.HomeEnerty;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.enerty.PlayUrlsEnerty;
import com.zpp.mobile.zmusic.ui.MusicPlayerActivity;
import com.zpp.mobile.zmusic.ui.SearchActivity;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import com.zpp.mobile.zmusic.utils.SongUtils;
import com.zpp.mobile.zmusic.utils.Url;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import rxhttp.wrapper.param.RxHttp;
import snow.player.audio.MusicItem;
import snow.player.lifecycle.PlayerViewModel;
import snow.player.playlist.Playlist;


/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.mainfragment
 * @ClassName: HomeFragment
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 15:14
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 15:14
 * @UpdateRemark:
 */
public class HomeFragment extends Fragment {
    HomeFragmentBinding homeFragmentBinding;
    HomeAdapter homeAdapter;
    ArrayList<HomeSongEnerty.ResultBean> songEnertyArrayList = new ArrayList<>();
    HeadAdapter headAdapter;
    private PlayerViewModel mPlayerViewModel;
    QuickAdapterHelper helper;
    HomeBanner homeBanner;
    HomeHeadAdapter homeHeadAdapter;
    public static HomeFragment getInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false);
        StatusBarUtil.setPaddingTop(getActivity(), homeFragmentBinding.view);
        ViewModelProvider viewModelProvider = new ViewModelProvider(requireActivity());
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        PlayerUtil.initPlayerViewModel(getContext(), mPlayerViewModel, MyMusicService.class);
        setRecyclerView();
        getBanner();
        getHomeSong();
        getListResult();
        setRefresh();
        return homeFragmentBinding.getRoot();
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        homeFragmentBinding.refresh.setOnRefreshListener(() -> {
            getBanner();
            getHomeSong();
            getListResult();
        });
        homeFragmentBinding.search.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SearchActivity.class);
            getActivity().startActivity(intent);
        });
    }

    /**
     * 获取推荐歌曲
     */
    private void setRecyclerView() {
        homeFragmentBinding.songList.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeAdapter = new HomeAdapter();
        homeAdapter.setOnItemClickListener((songBeanBaseQuickAdapter, view, integer) -> null);
        helper = new QuickAdapterHelper.Builder(homeAdapter).build();
        homeFragmentBinding.songList.setAdapter(helper.getAdapter());
        setBanner();
        setRecommend();
    }

    /**
     * 推荐歌单
     */
    private void setRecommend() {
        homeHeadAdapter=new HomeHeadAdapter();
        helper.addBeforeAdapter(1,homeHeadAdapter);
    }

    /**
     * 推荐banner
     *
     */
    private void setBanner() {
        homeBanner = new HomeBanner();
        headAdapter = new HeadAdapter(homeBanner);
        helper.addBeforeAdapter(headAdapter);
    }

    /**
     * 组装首页歌曲
     *
     * @param homeSongEnerty
     */
    private void setSongEnertyArrayList(HomeSongEnerty homeSongEnerty) {
        songEnertyArrayList.addAll(homeSongEnerty.getResult());
        homeAdapter.submitList(songEnertyArrayList);
        homeAdapter.setOnItemClickListener((resultBeanBaseQuickAdapter, view, integer) -> {
            getMusicPlayerUrl(integer, SongUtils.getHomeSongId(songEnertyArrayList));
            return null;
        });
    }

    /**
     * 每日推荐
     */
    private void getListResult() {
        RxHttp.postForm(Url.homeRecommend).toObservable(HomeEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeEnerty -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            homeHeadAdapter.setHomeEnerty(homeEnerty);
        }, throwable -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }

    /**
     * 缓存当前歌单
     */
    private void playSongSheet(int integer, PlayUrlsEnerty playUrlsEnerty) {
        MMKV.defaultMMKV().putString("playlistInfo", SongUtils.getHomeSongId(songEnertyArrayList));
        ArrayList<MusicItem> arrayList = new ArrayList<>();
        for (int i = 0; i < homeAdapter.getItems().size(); i++) {
            HomeSongEnerty.ResultBean songlistBean = homeAdapter.getItems().get(i);
            for (int j = 0; j < playUrlsEnerty.getData().size(); j++) {
                PlayUrlsEnerty.DataBean dataBean = playUrlsEnerty.getData().get(j);
                if (dataBean.getId().equals(songlistBean.getId())) {
                    MusicItem song = new MusicItem.Builder()
                            .setTitle(songlistBean.getName())
                            .setArtist(songlistBean.getSong().getArtists().get(0).getName())
                            .setAlbum(songlistBean.getSong().getAlbum().getName())
                            .setDuration(dataBean.getTime())
                            .setUri(dataBean.getUrl() == null ? "" : dataBean.getUrl())
                            .setIconUri(songlistBean.getPicUrl())
                            .build();
                    arrayList.add(song);
                }
            }
        }
        Playlist playlist = new Playlist("", arrayList, true, null);
        mPlayerViewModel.getPlayerClient().setPlaylist(playlist, integer, true);
    }

    /**
     * 获取banner
     */
    private void getBanner() {
        RxHttp.get(Url.BANNER).add("type", 1).toObservable(HomeBanner.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeBanner -> {
            Log.e("更新banner","-----------------------");
            headAdapter.setHomeBanner(homeBanner);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

    /**
     * 每日推荐歌曲
     */
    private void getHomeSong() {
        RxHttp.get(Url.homeSong).toObservable(HomeSongEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(this::setSongEnertyArrayList, Throwable::printStackTrace);
    }

    /**
     * 获取播放链接
     */
    private void getMusicPlayerUrl(int integer, String songIds) {
        RxHttp.postForm(Url.songPlyer).add("id", songIds).add("level", "exhigh").toObservable(PlayUrlsEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(s -> {
            playSongSheet(integer, s);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

}
