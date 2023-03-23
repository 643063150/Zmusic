package com.zpp.mobile.zmusic.mainfragment;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.chad.library.adapter.base.QuickAdapterHelper;
import com.leaf.library.StatusBarUtil;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.HomeAdapter;
import com.zpp.mobile.zmusic.Adapter.TopAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.ListFrahmentBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.TopTypeList;
import com.zpp.mobile.zmusic.ui.SearchActivity;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;
import com.zpp.mobile.zmusic.utils.Url;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import rxhttp.wrapper.param.RxHttp;


/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.mainfragment
 * @ClassName: ListFragment
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 15:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 15:15
 * @UpdateRemark:
 */
public class ListFragment extends  Fragment {
    ListFrahmentBinding homeFragmentBinding;
    TopAdapter topAdapter;

    public static ListFragment getInstance() {
        ListFragment homeFragment = new ListFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = ListFrahmentBinding.inflate(inflater, container, false);
        StatusBarUtil.setPaddingTop(getActivity(), homeFragmentBinding.view);
        setRefresh();
        setTopAdapter();
        getTop();
        return homeFragmentBinding.getRoot();
    }

    private void setTopAdapter(){
        homeFragmentBinding.songList.setLayoutManager(new LinearLayoutManager(getActivity()));
        homeFragmentBinding.songList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.parseColor("#00000000"))
                        .sizeResId(R.dimen.dividers)
                        .build());
        topAdapter = new TopAdapter();
        topAdapter.setOnItemClickListener((songBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(getContext(), SongSheetInfo.class);
            intent.putExtra("id", topAdapter.getItems().get(integer).getId() + "");
            getContext().startActivity(intent);
            return null;
        });
        homeFragmentBinding.songList.setAdapter(topAdapter);
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        homeFragmentBinding.refresh.setOnRefreshListener(this::getTop);
    }

    /**
     * 获取排行榜
     */
    private void getTop() {
        RxHttp.get(Url.top).add("type", 1).toObservable(TopTypeList.class).observeOn(AndroidSchedulers.mainThread()).subscribe(topTypeList -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            topAdapter.submitList(topTypeList.getList());
        }, throwable -> {
            homeFragmentBinding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }
}
