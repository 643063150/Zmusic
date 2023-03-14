package com.zpp.mobile.zmusic.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.leaf.library.StatusBarUtil;
import com.zpp.mobile.zmusic.databinding.MusicPlayerBinding;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: MusicPlayerActivity
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/13 15:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/13 15:15
 * @UpdateRemark:
 */
public class MusicPlayerActivity extends AppCompatActivity {
    MusicPlayerBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        binding=MusicPlayerBinding.inflate(getLayoutInflater());
        super.onCreate(savedInstanceState);
        setContentView(binding.getRoot());
        StatusBarUtil.setGradientColor(this, binding.toolbar);
    }
}
