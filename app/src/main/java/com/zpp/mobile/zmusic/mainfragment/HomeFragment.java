package com.zpp.mobile.zmusic.mainfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leaf.library.StatusBarUtil;
import com.stx.xhb.androidx.transformers.Transformer;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HomeAdapter;
import com.zpp.mobile.zmusic.Adapter.RecommendAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.HomeFragmentBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.HomeEnerty;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;
import com.zpp.mobile.zmusic.utils.Url;

import java.util.ArrayList;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
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
    ArrayList<HomeEnerty.DataBean.ListBean> arrayList = new ArrayList<>();
    HomeAdapter homeAdapter;
    ArrayList<HomeSongEnerty.DataBean.ListBean.SongBean> songEnertyArrayList = new ArrayList<>();

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
            Intent intent=new Intent();
            intent.setClass(getActivity(), SongSheetInfo.class);
            intent.putExtra("id",recommendAdapter.getItems().get(integer).getContent_id()+"");
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
        homeFragmentBinding.banner4.setBannerData(R.layout.home_banner, homeBanner.getData());
        homeFragmentBinding.banner4.loadImage((banner, model, view, psition) -> {
            ImageView imageView = view.findViewById(R.id.bannerimg);
            Glide.with(getActivity()).load(homeBanner.getData().get(psition).getPicUrl()).into(imageView);
        });
    }

    /**
     * 组装首页歌曲
     *
     * @param homeSongEnerty
     */
    private void setSongEnertyArrayList(HomeSongEnerty homeSongEnerty) {
        songEnertyArrayList.clear();
        for (int i = 0; i < homeSongEnerty.getData().get(0).getList().size(); i++) {
            songEnertyArrayList.addAll(homeSongEnerty.getData().get(0).getList().get(i).getSong());
        }
        homeAdapter.submitList(songEnertyArrayList);
    }

    /**
     * 每日推荐
     */
    private void getListResult() {
        RxHttp.postForm(Url.homeRecommend).toObservable(HomeEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeEnerty -> {
            arrayList.clear();
            homeFragmentBinding.refresh.setRefreshing(false);
            arrayList.addAll(homeEnerty.getData().getList());
            recommendAdapter.submitList(arrayList);
        }, throwable -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }

    /**
     * 获取banner
     */
    private void getBanner() {
        RxHttp.get(Url.BANNER).toObservable(HomeBanner.class).observeOn(AndroidSchedulers.mainThread()).subscribe(homeBanner -> {
            setBanner(homeBanner);
        }, throwable -> {
            throwable.printStackTrace();
        });
    }

    /**
     * 每日推荐歌曲
     */
    private void getHomeSong() {
        RxHttp.get(Url.homeSong).add("showDetail", 1).toObservable(HomeSongEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(this::setSongEnertyArrayList, Throwable::printStackTrace);
    }

}
