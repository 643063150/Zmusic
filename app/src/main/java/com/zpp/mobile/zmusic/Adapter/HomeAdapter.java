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
import com.zpp.mobile.zmusic.enerty.HomeEnerty;
import com.zpp.mobile.zmusic.enerty.HomeSongEnerty;
import com.zpp.mobile.zmusic.enerty.SongEnerty;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: HomeAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/9 9:07
 * @UpdateUser:
 * @UpdateDate: 2023/3/9 9:07
 * @UpdateRemark:
 */
public class HomeAdapter extends BaseQuickAdapter<HomeSongEnerty.DataBean.ListBean.SongBean, HomeAdapter.ViewHolder> {
    SongItemBinding binding;



    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding = SongItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable HomeSongEnerty.DataBean.ListBean.SongBean songBean) {
        Glide.with(getContext()).load(songBean.getCover()).into(binding.cover);
        binding.title.setText(songBean.getTitle());
        binding.singer.setText(songBean.getSingerName());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SongItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
