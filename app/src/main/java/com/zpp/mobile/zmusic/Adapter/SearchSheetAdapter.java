package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.SheetItemInfoBinding;
import com.zpp.mobile.zmusic.enerty.SearchSheetEnerty;
import com.zpp.mobile.zmusic.utils.SongUtils;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: SearchSheetAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/21 13:34
 * @UpdateUser:
 * @UpdateDate: 2023/3/21 13:34
 * @UpdateRemark:
 */
public class SearchSheetAdapter extends BaseQuickAdapter<SearchSheetEnerty.ResultBean.PlaylistsBean, SearchSheetAdapter.ViewHolder> {
    SheetItemInfoBinding binding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable SearchSheetEnerty.ResultBean.PlaylistsBean playlistsBean) {
        Glide.with(getContext()).load(playlistsBean.getCoverImgUrl()).transform(new CenterCrop(),new RoundedCorners(15)).error(R.mipmap.a4).into(binding.cover);
        binding.title.setText(playlistsBean.getName());
        binding.singer.setText(new StringBuilder().append("by").append(playlistsBean.getCreator().getNickname()).append("-播放").append(SongUtils.convertToTenThousandFormat(playlistsBean.getPlayCount())).toString());
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding=SheetItemInfoBinding.inflate(LayoutInflater.from(context),viewGroup,false);
        return new ViewHolder(binding);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SheetItemInfoBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
