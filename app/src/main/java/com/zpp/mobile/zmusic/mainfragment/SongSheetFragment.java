package com.zpp.mobile.zmusic.mainfragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.leaf.library.StatusBarUtil;
import com.zpp.mobile.zmusic.Adapter.SongSheetAdapter;
import com.zpp.mobile.zmusic.databinding.SongsheetGragmentBinding;
import com.zpp.mobile.zmusic.enerty.WebSongSheetEnerty;
import com.zpp.mobile.zmusic.ui.MoreSheet;
import com.zpp.mobile.zmusic.ui.MusicPlayerActivity;
import com.zpp.mobile.zmusic.ui.SearchActivity;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;
import com.zpp.mobile.zmusic.utils.Url;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import rxhttp.wrapper.param.RxHttp;


/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.mainfragment
 * @ClassName: SongSheetFragment
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 15:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 15:15
 * @UpdateRemark:
 */
public class SongSheetFragment extends Fragment {
    SongsheetGragmentBinding songsheetGragmentBinding;
    SongSheetAdapter songSheetAdapter;
    SongSheetAdapter songSheetAdapter2;

    public static SongSheetFragment getInstance() {
        SongSheetFragment homeFragment = new SongSheetFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        songsheetGragmentBinding = SongsheetGragmentBinding.inflate(inflater, container, false);
        StatusBarUtil.setPaddingTop(getActivity(), songsheetGragmentBinding.view);
        setSongsheetGragmentBinding();
        setSongSheetAdapter();
        setSongSheetAdapter2();
        getWebConcentration();
        getAuthorityConcentration();
        setRefresh();
        return songsheetGragmentBinding.getRoot();
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        songsheetGragmentBinding.refresh.setOnRefreshListener(() -> {
            getWebConcentration();
            getAuthorityConcentration();
        });
        songsheetGragmentBinding.search.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SearchActivity.class);
            getActivity().startActivity(intent);
        });
        songsheetGragmentBinding.webMore.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("type", 0);
            intent.setClass(getActivity(), MoreSheet.class);
            getActivity().startActivity(intent);
        });
        songsheetGragmentBinding.bouMore.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.putExtra("type", 1);
            intent.setClass(getActivity(), MoreSheet.class);
            getActivity().startActivity(intent);
        });
    }

    /**
     * 网友推荐
     */
    private void setSongSheetAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        songsheetGragmentBinding.webConcentration.setLayoutManager(gridLayoutManager);
        songSheetAdapter = new SongSheetAdapter();
        songsheetGragmentBinding.webConcentration.setAdapter(songSheetAdapter);
        songSheetAdapter.setOnItemClickListener((playlistsBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SongSheetInfo.class);
            intent.putExtra("id", songSheetAdapter.getItems().get(integer).getId() + "");
            getActivity().startActivity(intent);
            return null;
        });
    }

    /**
     * 官方推荐
     */
    private void setSongSheetAdapter2() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        songsheetGragmentBinding.boutiqueConcentration.setLayoutManager(gridLayoutManager);
        songSheetAdapter2 = new SongSheetAdapter();
        songsheetGragmentBinding.boutiqueConcentration.setAdapter(songSheetAdapter2);
        songSheetAdapter2.setOnItemClickListener((playlistsBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), SongSheetInfo.class);
            intent.putExtra("id", songSheetAdapter2.getItems().get(integer).getId() + "");
            getActivity().startActivity(intent);
            return null;
        });
    }


    /**
     * 设置view
     */
    private void setSongsheetGragmentBinding() {
        songsheetGragmentBinding.search.setOnClickListener(v -> {
            Intent intent = new Intent();
            intent.setClass(getActivity(), MusicPlayerActivity.class);
            getActivity().startActivity(intent);
        });
    }

    /**
     * 网友精选
     */
    private void getWebConcentration() {
        RxHttp.get(Url.webConUrl).add("limit", 6).toObservable(WebSongSheetEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(webSongSheetEnerty -> {
            songSheetAdapter.submitList(webSongSheetEnerty.getPlaylists());
        }, throwable -> throwable.printStackTrace());
    }

    /**
     * 官方推荐
     */
    private void getAuthorityConcentration() {
        RxHttp.get(Url.authorityUrl).add("limit", 24).toObservable(WebSongSheetEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(webSongSheetEnerty -> {
            songSheetAdapter2.submitList(webSongSheetEnerty.getPlaylists());
            songsheetGragmentBinding.refresh.setRefreshing(false);
        }, throwable -> {
            songsheetGragmentBinding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }
}
