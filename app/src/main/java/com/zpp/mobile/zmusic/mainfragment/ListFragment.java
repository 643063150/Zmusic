package com.zpp.mobile.zmusic.mainfragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.zpp.mobile.zmusic.databinding.ListFrahmentBinding;


/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.mainfragment
 * @ClassName: ListFragment
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 15:15
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 15:15
 * @UpdateRemark:
 */
public class ListFragment extends  Fragment {
    ListFrahmentBinding homeFragmentBinding;

    public static ListFragment getInstance() {
        ListFragment homeFragment = new ListFragment();
        return homeFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        homeFragmentBinding = ListFrahmentBinding.inflate(inflater, container, false);
        return homeFragmentBinding.getRoot();
    }
}
