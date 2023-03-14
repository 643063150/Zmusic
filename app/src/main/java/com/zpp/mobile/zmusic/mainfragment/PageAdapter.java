package com.zpp.mobile.zmusic.mainfragment;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.mainfragment
 * @ClassName: PageAdapter
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 15:31
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 15:31
 * @UpdateRemark:
 */
public class PageAdapter extends FragmentStateAdapter {
    HomeFragment homeFragment;
    SongSheetFragment songSheetFragment;
    ListFragment listFragment;


    public PageAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                }
                return homeFragment;
            case 1:
                if (songSheetFragment == null) {
                    songSheetFragment = new SongSheetFragment();
                }
                return songSheetFragment;
            case 2:
                if (listFragment == null) {
                    listFragment = new ListFragment();
                }
                return listFragment;
            default:
                break;
        }
        return null;
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
