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
import com.zpp.mobile.zmusic.databinding.SongItemBinding;
import com.zpp.mobile.zmusic.databinding.TopItemBinding;
import com.zpp.mobile.zmusic.enerty.TopTypeList;
import com.zpp.mobile.zmusic.utils.SongUtils;

import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: TopAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/22 14:14 * @UpdateUser:
 * @UpdateDate: 2023/3/22 14:14
 * @UpdateRemark:
 */
public class TopAdapter extends BaseQuickAdapter<TopTypeList.ListBean, TopAdapter.ViewHolder> {
    TopItemBinding itemBinding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable TopTypeList.ListBean listBean) {
        Glide.with(getContext()).load(listBean.getCoverImgUrl()).transform(new CenterCrop(), new RoundedCorners(15)).into(itemBinding.cover);
        itemBinding.playCount.setText("播放:" + SongUtils.convertToTenThousandFormat(listBean.getPlayCount()));
        itemBinding.updateTime.setText(listBean.getUpdateFrequency());
        itemBinding.description.setText(listBean.getDescription());
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends TopTypeList.ListBean> list) {
        return position;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        itemBinding = TopItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(itemBinding);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull TopItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
