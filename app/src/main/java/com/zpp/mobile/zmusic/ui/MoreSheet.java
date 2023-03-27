package com.zpp.mobile.zmusic.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.GridLayoutManager;

import com.chad.library.adapter.base.QuickAdapterHelper;
import com.chad.library.adapter.base.loadState.LoadState;
import com.chad.library.adapter.base.loadState.trailing.TrailingLoadStateAdapter;
import com.leaf.library.StatusBarUtil;
import com.zpp.mobile.zmusic.Adapter.SongSheetAdapter;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.databinding.MorSheetBinding;
import com.zpp.mobile.zmusic.enerty.WebSongSheetEnerty;
import com.zpp.mobile.zmusic.utils.Url;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import rxhttp.wrapper.param.RxHttp;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: MoreSheet
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/27 10:36
 * @UpdateUser:
 * @UpdateDate: 2023/3/27 10:36
 * @UpdateRemark:
 */
public class MoreSheet extends BaseActivity {
    MorSheetBinding binding;
    String url;
    int type = 0;
    SongSheetAdapter songSheetAdapter;
    QuickAdapterHelper helper;
    int offset = 0;
    boolean load=true;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = MorSheetBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        StatusBarUtil.setGradientColor(this, binding.toolbar);
        type = getIntent().getIntExtra("type", 0);
        if (type == 0) {
            url = Url.webConUrl;
        } else {
            url = Url.authorityUrl;
        }
        setSongSheetAdapter();
        getAuthorityConcentration();
        setRefresh();
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        binding.refresh.setOnRefreshListener(() -> {
            offset = 0;
            getAuthorityConcentration();
        });
    }

    /**
     * 设置适配器
     */
    private void setSongSheetAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MoreSheet.this, 3);
        binding.sheetList.setLayoutManager(gridLayoutManager);
        songSheetAdapter = new SongSheetAdapter();
        helper = new QuickAdapterHelper.Builder(songSheetAdapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() {
            @Override
            public void onLoad() {
                offset = offset + 1;
                getAuthorityConcentration();
            }

            @Override
            public void onFailRetry() {

            }

            @Override
            public boolean isAllowLoading() {
                return load;
            }
        }).build();
        binding.sheetList.setAdapter(helper.getAdapter());
        songSheetAdapter.setOnItemClickListener((playlistsBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(MoreSheet.this, SongSheetInfo.class);
            intent.putExtra("id", songSheetAdapter.getItems().get(integer).getId() + "");
            startActivity(intent);
            return null;
        });
    }

    /**
     * 更多歌单
     */
    private void getAuthorityConcentration() {
        load=false;
        RxHttp.get(url).add("limit", 12).add("offset", offset).toObservable(WebSongSheetEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(webSongSheetEnerty -> {
            load=true;
            if (offset == 0) {
                songSheetAdapter.submitList(webSongSheetEnerty.getPlaylists());
            } else {
                songSheetAdapter.addAll(webSongSheetEnerty.getPlaylists());
            }
            binding.refresh.setRefreshing(false);
            helper.setTrailingLoadState(new LoadState.NotLoading(false));
        }, throwable -> {
            load=true;
            binding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }

}
