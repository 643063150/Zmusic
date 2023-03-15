package com.zpp.mobile.zmusic.mainfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;


import com.bumptech.glide.Glide;
import com.leaf.library.StatusBarUtil;
import com.stx.xhb.androidx.transformers.Transformer;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HomeAdapter;
import com.zpp.mobile.zmusic.Adapter.RecommendAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.HomeFragmentBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.HomeEnerty;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.ui.MusicPlayerActivity;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;
import com.zpp.mobile.zmusic.utils.Url;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import rxhttp.wrapper.param.RxHttp;


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
    RecommendAdapter recommendAdapter;
    HomeAdapter homeAdapter;
    ArrayList<HomeSongEnerty.DataBean.DailySongsBean> songEnertyArrayList = new ArrayList<>();

    public static HomeFragment getInstance() {
        HomeFragment homeFragment = new HomeFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = HomeFragmentBinding.inflate(inflater, container, false);
        StatusBarUtil.setPaddingTop(getActivity(), homeFragmentBinding.view);
        getBanner();
        getHomeSong();
        getListResult();
        setRecommend();
        setRecyclerView();
        setRefresh();
        return homeFragmentBinding.getRoot();
    }

    private void setRefresh() {
        homeFragmentBinding.refresh.setOnRefreshListener(() -> {
            getBanner();
            getHomeSong();
            getListResult();
        });
        homeFragmentBinding.search.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MusicPlayerActivity.class);
            getActivity().startActivity(intent);
        });
    }

    /**
     * 获取推荐歌曲
     */
    private void setRecyclerView() {
        homeFragmentBinding.songList.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeFragmentBinding.songList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.parseColor("#00000000"))
                        .sizeResId(R.dimen.dividers)
                        .build());
        homeAdapter = new HomeAdapter();
        homeFragmentBinding.songList.setAdapter(homeAdapter);
        homeAdapter.setOnItemClickListener((songBeanBaseQuickAdapter, view, integer) -> null);
    }

    /**
     * 推荐歌单
     */
    private void setRecommend() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        homeFragmentBinding.recomPlaylist.setLayoutManager(linearLayoutManager);
        recommendAdapter = new RecommendAdapter();
        homeFragmentBinding.recomPlaylist.setAdapter(recommendAdapter);
        recommendAdapter.setOnItemClickListener((vHotBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SongSheetInfo.class);
            intent.putExtra("id", recommendAdapter.getItems().get(integer).getId() + "");
            getActivity().startActivity(intent);
            return null;
        });
    }

    /**
     * 推荐banner
     *
     * @param homeBanner
     */
    private void setBanner(HomeBanner homeBanner) {
        homeFragmentBinding.banner4.setPageTransformer(Transformer.Default);
        homeFragmentBinding.banner4.setBannerData(R.layout.home_banner, homeBanner.getBanners());
        homeFragmentBinding.banner4.loadImage((banner, model, view, psition) -> {
            ImageView imageView = view.findViewById(R.id.bannerimg);
            Glide.with(getActivity()).load(homeBanner.getBanners().get(psition).getPic()).into(imageView);
        });
    }

    /**
     * 组装首页歌曲
     *
     * @param homeSongEnerty
     */
    private void setSongEnertyArrayList(HomeSongEnerty homeSongEnerty) {
        songEnertyArrayList.addAll(homeSongEnerty.getData().getDailySongs());
        homeAdapter.submitList(songEnertyArrayList);
    }

    /**
     * 每日推荐
     */
    private void getListResult() {
        RxHttp.postForm(Url.homeRecommend).toObservable(HomeEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeEnerty -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            recommendAdapter.submitList(homeEnerty.getResult());
        }, throwable -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }

    /**
     * 获取banner
     */
    private void getBanner() {
        RxHttp.get(Url.BANNER).add("type", 1).toObservable(HomeBanner.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeBanner -> {
            setBanner(homeBanner);
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

}
