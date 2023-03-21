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
import com.zpp.mobile.zmusic.databinding.SongItemBinding;
import com.zpp.mobile.zmusic.enerty.SearchEnerty;
import java.util.List;
import snow.player.util.ProgressClock;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: SearchSongAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/17 15:43
 * @UpdateUser:
 * @UpdateDate: 2023/3/17 15:43
 * @UpdateRemark:
 */
public class SearchSongAdapter extends BaseQuickAdapter<SearchEnerty.ResultBean.SongsBean, SearchSongAdapter.ViewHolder> {
    SongItemBinding songItemBinding;
    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable SearchEnerty.ResultBean.SongsBean songlistBean) {
        Glide.with(getContext()).load(songlistBean.getAl().getPicUrl()).transform(new CenterCrop(),new RoundedCorners(15)).error(R.mipmap.a4).into(songItemBinding.cover);
        songItemBinding.title.setText(songlistBean.getName());
        songItemBinding.singer.setText(songlistBean.getAr().get(0).getName()+"-"+songlistBean.getAl().getName());
        songItemBinding.time.setText(ProgressClock.asText(songlistBean.getDt()/1000));
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        songItemBinding = SongItemBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(songItemBinding);
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends SearchEnerty.ResultBean.SongsBean> list) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull SongItemBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
