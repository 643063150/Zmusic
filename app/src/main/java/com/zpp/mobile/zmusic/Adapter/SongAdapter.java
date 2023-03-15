package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.SongItemBinding;
import com.zpp.mobile.zmusic.enerty.SongSheetInfoEnerty;
import com.zpp.mobile.zmusic.utils.SongUtils;

import java.security.spec.PSSParameterSpec;
import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: SongAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 16:14
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 16:14
 * @UpdateRemark:
 */
public class SongAdapter extends BaseQuickAdapter<SongSheetInfoEnerty.PlaylistBean.TracksBean, SongAdapter.ViewHolder> {
    SongItemBinding songItemBinding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable SongSheetInfoEnerty.PlaylistBean.TracksBean songlistBean) {
        Glide.with(getContext()).load(songlistBean.getAl().getPicUrl()).error(R.mipmap.a4).into(songItemBinding.cover);
        songItemBinding.title.setText(songlistBean.getName());
        songItemBinding.singer.setText(songlistBean.getAr().get(0).getName());
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        songItemBinding = SongItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(songItemBinding);
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends SongSheetInfoEnerty.PlaylistBean.TracksBean> list) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SongItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
