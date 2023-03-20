package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zpp.mobile.zmusic.databinding.SongItemBinding;
import com.zpp.mobile.zmusic.databinding.SongSheetItemBinding;
import com.zpp.mobile.zmusic.enerty.WebSongSheetEnerty;
import com.zpp.mobile.zmusic.utils.SongUtils;

import java.util.List;

public class SongSheetAdapter extends BaseQuickAdapter<WebSongSheetEnerty.PlaylistsBean, SongSheetAdapter.ViewHolder> {
    SongSheetItemBinding binding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable WebSongSheetEnerty.PlaylistsBean playlistsBean) {
        Glide.with(getContext()).load(playlistsBean.getCoverImgUrl()).into(binding.cover);
        binding.title.setText(playlistsBean.getName());
        binding.counts.setText(SongUtils.convertToTenThousandFormat(playlistsBean.getPlayCount())+"");
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding=SongSheetItemBinding.inflate(LayoutInflater.from(context),viewGroup,false);
        return new ViewHolder(binding);
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends WebSongSheetEnerty.PlaylistsBean> list) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SongSheetItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
