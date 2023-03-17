package com.zpp.mobile.zmusic;
import android.content.Context;
import android.os.Bundle;
import android.os.PowerManager;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;
import com.leaf.library.StatusBarUtil;
import com.zpp.mobile.zmusic.app.BaseActivity;
import com.zpp.mobile.zmusic.app.MyMusicService;
import com.zpp.mobile.zmusic.databinding.ActivityMainBinding;
import com.zpp.mobile.zmusic.mainfragment.PageAdapter;
import com.zpp.mobile.zmusic.utils.PlayerUtil;
import snow.player.lifecycle.PlayerViewModel;


public class MainActivity extends BaseActivity {
    ActivityMainBinding mainBinding;
    PageAdapter pageAdapter;
    private PlayerViewModel mPlayerViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        StatusBarUtil.setTransparentForWindow(this);
        initAllViewModel();
        setContentView(mainBinding.getRoot());
        setPlayerClient(mPlayerViewModel.getPlayerClient());
        setPageAdapter();
    }

    /**
     * 绑定播放器
     */
    private void initAllViewModel() {
        ViewModelProvider viewModelProvider = new ViewModelProvider(this);
        mPlayerViewModel = viewModelProvider.get(PlayerViewModel.class);
        PlayerUtil.initPlayerViewModel(this, mPlayerViewModel, MyMusicService.class);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    /**
     * 设置首页框架
     */
    public void setPageAdapter(){
        mainBinding.musicViewpage.setOffscreenPageLimit(3);
        pageAdapter=new PageAdapter(this);
        mainBinding.musicViewpage.setAdapter(pageAdapter);
        mainBinding.musicViewpage.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                mainBinding.mainNav.getMenu().getItem(position).setChecked(true);
            }
        });
        mainBinding.mainNav.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.home:
                    mainBinding.musicViewpage.setCurrentItem(0,false);
                    break;
                case R.id.song_sheet:
                    mainBinding.musicViewpage.setCurrentItem(1,false);
                    break;
                case R.id.list:
                    mainBinding.musicViewpage.setCurrentItem(2,false);
                    break;
                default:
                    break;
            }
            return false;
        });
    }

}