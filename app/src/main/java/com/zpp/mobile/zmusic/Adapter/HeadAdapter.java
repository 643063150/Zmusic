package com.zpp.mobile.zmusic.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseSingleItemAdapter;
import com.stx.xhb.androidx.transformers.Transformer;
import com.zpp.mobile.zmusic.R;
import com.zpp.mobile.zmusic.databinding.BanerviewBinding;
import com.zpp.mobile.zmusic.enerty.HomeBanner;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.Adapter
 * @ClassName: HeadAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/20 10:19
 * @UpdateUser:
 * @UpdateDate: 2023/3/20 10:19
 * @UpdateRemark:
 */
public class HeadAdapter extends BaseSingleItemAdapter<HomeBanner, HeadAdapter.ViewHolder> {
    BanerviewBinding binding;
    HomeBanner homeBanner;

    public HeadAdapter(HomeBanner homeBanner) {
        this.homeBanner = homeBanner;
    }

    @NonNull
    @Override
    protected ViewHolder onCreateViewHolder(@NonNull Context context, @NonNull ViewGroup viewGroup, int i) {
        binding = BanerviewBinding.inflate(LayoutInflater.from(context), viewGroup, false);
        return new ViewHolder(binding);
    }

    @Override
    protected void onBindViewHolder(@NonNull ViewHolder viewHolder, @Nullable HomeBanner homeBanner) {
        Log.e("更新banner", "-----------------------");
        if (this.homeBanner.getBanners() == null || this.homeBanner.getBanners().size() == 0) {
            return;
        }
        binding.banner4.setPageTransformer(Transformer.Default);
        binding.banner4.setBannerData(R.layout.home_banner, this.homeBanner.getBanners());
        binding.banner4.loadImage((banner, model, view, psition) -> {
            ImageView imageView = view.findViewById(R.id.bannerimg);
            Glide.with(getContext()).load(this.homeBanner.getBanners().get(psition).getPic()).into(imageView);
        });
    }

    public void setHomeBanner(HomeBanner homeBanner) {
        this.homeBanner = homeBanner;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull BanerviewBinding itemView) {
            super(itemView.getRoot());
        }
    }
}
