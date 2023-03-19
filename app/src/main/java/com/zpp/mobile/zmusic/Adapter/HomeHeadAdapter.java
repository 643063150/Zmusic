package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.BanerviewBinding;
import com.zpp.mobile.zmusic.databinding.SonglistItemBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;

import java.util.List;

public class HomeHeadAdapter extends BaseQuickAdapter<HomeBanner, HomeHeadAdapter.ViewHolder> {
    BanerviewBinding binding;

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, int i, @Nullable HomeBanner homeBanner) {
        binding.banner4.setPageTransformer(Transformer.Default);
        binding.banner4.setBannerData(R.layout.home_banner, homeBanner.getBanners());
        binding.banner4.loadImage((banner, model, view, psition) -> {
            ImageView imageView = view.findViewById(R.id.bannerimg);
            Glide.with(getContext()).load(homeBanner.getBanners().get(psition).getPic()).into(imageView);
        });
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding=BanerviewBinding.inflate(LayoutInflater.from(context),viewGroup,false);
        return new ViewHolder(binding);
    }

    @Override
    protected int getItemViewType(int position, @NonNull List<? extends HomeBanner> list) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull BanerviewBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
