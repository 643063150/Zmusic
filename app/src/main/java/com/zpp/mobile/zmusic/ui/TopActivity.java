package com.zpp.mobile.zmusic.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.databinding.ToplayoutBinding;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui
 * @ClassName: TopActivity
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/22 14:54
 * @UpdateUser:
 * @UpdateDate: 2023/3/22 14:54
 * @UpdateRemark:
 */
public class TopActivity extends BaseActivity {
    ToplayoutBinding binding;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ToplayoutBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
    }
}
