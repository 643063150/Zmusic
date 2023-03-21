package com.zpp.mobile.zmusic.ui.modelview;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.zpp.mobile.zmusic.enerty.SearchEnerty;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.ui.modelview
 * @ClassName: SearchModelView
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/21 10:44
 * @UpdateUser:
 * @UpdateDate: 2023/3/21 10:44
 * @UpdateRemark:
 */
public class SearchModelView extends ViewModel {
    private MutableLiveData<String> key = new MutableLiveData<>();
    private MutableLiveData<SearchEnerty.ResultBean.SongsBean> songsBean = new MutableLiveData<>();
    public SearchModelView() {
        key.setValue("");
        songsBean.setValue(new SearchEnerty.ResultBean.SongsBean());
    }

    public MutableLiveData<String> getKey() {
        return key;
    }

    public MutableLiveData<SearchEnerty.ResultBean.SongsBean> getSongId() {
        return songsBean;
    }
}
