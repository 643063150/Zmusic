package com.zpp.mobile.zmusic.app;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.PowerManager;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import snow.player.PlayerClient;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.app
 * @ClassName: BaseActivity
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/15 14:27
 * @UpdateUser:
 * @UpdateDate: 2023/3/15 14:27
 * @UpdateRemark:
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    protected PlayerClient mPlayerClient;

    public void setPlayerClient(@Nullable PlayerClient playerClient) {
        mPlayerClient = playerClient;
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mPlayerClient != null && !mPlayerClient.isConnected()) {
            mPlayerClient.connect();
        }
    }
}
