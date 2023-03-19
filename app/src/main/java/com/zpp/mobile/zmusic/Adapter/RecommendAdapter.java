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
import com.zpp.mobile.zmusic.databinding.SonglistItemBinding;
import com.zpp.mobile.zmusic.enerty.HomeEnerty;

import java.util.List;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.Adapter
 * @ClassName: RecommendAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/8 13:40
 * @UpdateUser:
 * @UpdateDate: 2023/3/8 13:40
 * @UpdateRemark:
 */
public class RecommendAdapter extends BaseQuickAdapter<HomeEnerty.ResultBean, RecommendAdapter.ViewHolder> {
    SonglistItemBinding songlistItemBinding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable HomeEnerty.ResultBean vHotBean) {
        Glide.with(getContext()).load(vHotBean.getPicUrl()).transform(new CenterCrop(),new RoundedCorners(15)).into(songlistItemBinding.cover);
        songlistItemBinding.title.setText(vHotBean.getName());
        songlistItemBinding.counts.setText(vHotBean.getPlayCount()+"");
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        songlistItemBinding = SonglistItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(songlistItemBinding);
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends HomeEnerty.ResultBean> list) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SonglistItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
