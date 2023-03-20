package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseSingleItemAdapter;
import com.stx.xhb.androidx.transformers.Transformer;
import com.yqritc.recyclerviewflexibledivider.VerticalDividerItemDecoration;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.BanerviewBinding;
import com.zpp.mobile.zmusic.databinding.HomeRecommLayoutBinding;
import com.zpp.mobile.zmusic.databinding.SonglistItemBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;
import com.zpp.mobile.zmusic.enerty.HomeEnerty;
import com.zpp.mobile.zmusic.ui.SongSheetInfo;

import java.util.List;

public class HomeHeadAdapter extends BaseSingleItemAdapter<HomeEnerty, HomeHeadAdapter.ViewHolder> {
    HomeRecommLayoutBinding binding;
    RecommendAdapter recommendAdapter;
    HomeEnerty homeEnerty;

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding = HomeRecommLayoutBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        recommendAdapter = new RecommendAdapter();
        return new ViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, @Nullable HomeEnerty homeBanner) {
        if (homeEnerty == null || homeEnerty.getResult().size() == 0) {
            return;
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        binding.recomPlaylist.setLayoutManager(linearLayoutManager);
        if (binding.recomPlaylist.getItemDecorationCount()==0){
            binding.recomPlaylist.addItemDecoration(
                    new VerticalDividerItemDecoration.Builder(getContext())
                            .color(Color.parseColor("#00000000"))
                            .sizeResId(R.dimen.dividers)
                            .build());
        }
        binding.recomPlaylist.setAdapter(recommendAdapter);
        recommendAdapter.submitList(homeEnerty.getResult());
        recommendAdapter.setOnItemClickListener((vHotBeanBaseQuickAdapter, view, integer) -> {
            Intent intent = new Intent();
            intent.setClass(getContext(), SongSheetInfo.class);
            intent.putExtra("id", recommendAdapter.getItems().get(integer).getId() + "");
            getContext().startActivity(intent);
            return null;
        });
    }

    public void setHomeEnerty(HomeEnerty homeEnerty) {
        this.homeEnerty = homeEnerty;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull HomeRecommLayoutBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
