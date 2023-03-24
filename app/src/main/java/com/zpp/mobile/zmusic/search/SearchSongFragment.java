package com.zpp.mobile.zmusic.search;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.chad.library.adapter.base.QuickAdapterHelper;
import com.chad.library.adapter.base.loadState.LoadState;
import com.chad.library.adapter.base.loadState.trailing.TrailingLoadStateAdapter;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;
import com.zpp.mobile.zmusic.Adapter.SearchSongAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.SearchLayoutBinding;
import com.zpp.mobile.zmusic.enerty.SearchEnerty;
import com.zpp.mobile.zmusic.ui.modelview.SearchModelView;
import com.zpp.mobile.zmusic.utils.Url;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import rxhttp.wrapper.param.RxHttp;


/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.search
 * @ClassName: SearchSongFragment
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/21 10:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/21 10:15
 * @UpdateRemark:
 */
public class SearchSongFragment extends Fragment {
    public static String TAG="搜索";
    SearchLayoutBinding binding;
    SearchSongAdapter searchSongAdapter;
    QuickAdapterHelper helper;
    SearchModelView searchModelView;
    int offset = 0;
    boolean load=true;

    public static SearchSongFragment getInstance() {
        SearchSongFragment searchSheetFragment = new SearchSongFragment();
        return searchSheetFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = SearchLayoutBinding.inflate(inflater, container, false);
        searchModelView = new ViewModelProvider(getActivity()).get(SearchModelView.class);
        setRefresh();
        setSearchSongAdapter();
        setSearch();
        return binding.getRoot();
    }

    /**
     * 开始搜索
     */
    private void setSearch() {
        searchModelView.getKey().observe(getActivity(), s -> {
            offset = 0;
            search(s);
        });
    }

    /**
     * 刷新
     */
    private void setRefresh() {
        binding.refresh.setOnRefreshListener(() -> {
            offset = 0;
            search(searchModelView.getKey().getValue());
        });
    }

    /**
     * 设置适配器
     */
    private void setSearchSongAdapter() {
        binding.songList.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.songList.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(Color.parseColor("#00000000"))
                        .sizeResId(R.dimen.dividers)
                        .build());
        searchSongAdapter = new SearchSongAdapter();
        helper = new QuickAdapterHelper.Builder(searchSongAdapter).setTrailingLoadStateAdapter(new TrailingLoadStateAdapter.OnTrailingListener() {
            @Override
            public void onLoad() {
                Log.e(TAG,"加载下一页");
                offset = offset + 1;
                search(searchModelView.getKey().getValue());
            }

            @Override
            public void onFailRetry() {

            }

            @Override
            public boolean isAllowLoading() {
                return load;
            }
        }).build();
        binding.songList.setAdapter(helper.getAdapter());
        searchSongAdapter.setOnItemClickListener((songlistBeanBaseQuickAdapter, view, integer) -> {
            SearchEnerty.ResultBean.SongsBean songsBean = searchSongAdapter.getItems().get(integer);
            searchModelView.getSongId().setValue(songsBean);
            return null;
        });
    }

    /**
     *
     */
    public void search(String key) {
        load=false;
        RxHttp.get(Url.search).add("limit", 20).add("offset", offset).add("keywords", key).toObservable(SearchEnerty.class).observeOn(AndroidSchedulers.mainThread()).subscribe(searchEnerty -> {
            binding.refresh.setRefreshing(false);
            load=true;
            if (offset == 0) {
                searchSongAdapter.submitList(searchEnerty.getResult().getSongs());
            } else {
                searchSongAdapter.addAll(searchEnerty.getResult().getSongs());
            }
            helper.setTrailingLoadState(new LoadState.NotLoading(false));
        }, throwable -> {
            load=true;
            binding.refresh.setRefreshing(false);
            throwable.printStackTrace();
        });
    }
}
