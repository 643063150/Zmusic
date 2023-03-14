package com.zpp.mobile.zmusic.enerty;

import com.stx.xhb.androidx.entity.SimpleBannerInfo;

import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.enerty
 * @ClassName: HomeBanner
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 11:32
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 11:32
 * @UpdateRemark:
 */
public class HomeBanner {

    /**
     * result : 100
     * data : [{"type":"10002","id":"36042538","picUrl":"https://y.gtimg.cn/music/common/upload/MUSIC_FOCUS/4575224.jpg?max_age=2592000","h5Url":"https://y.qq.com/musicmac/v6/album/detail.html?albumid=36042538","typeStr":"album"},{"type":"10002","id":"36025070","picUrl":"https://y.gtimg.cn/music/common/upload/MUSIC_FOCUS/4573989.jpg?max_age=2592000","h5Url":"https://y.qq.com/musicmac/v6/album/detail.html?albumid=36025070","typeStr":"album"},{"type":"10002","id":"36056659","picUrl":"https://y.gtimg.cn/music/common/upload/MUSIC_FOCUS/4574744.jpg?max_age=2592000","h5Url":"https://y.qq.com/musicmac/v6/album/detail.html?albumid=36056659","typeStr":"album"},{"type":"10002","id":"35948592","picUrl":"https://y.gtimg.cn/music/common/upload/MUSIC_FOCUS/4574093.jpg?max_age=2592000","h5Url":"https://y.qq.com/musicmac/v6/album/detail.html?albumid=35948592","typeStr":"album"},{"type":"10002","id":"35873098","picUrl":"https://y.gtimg.cn/music/common/upload/t_musicmall_focus/4573879.jpg?max_age=2592000","h5Url":"https://y.qq.com/musicmac/v6/album/detail.html?albumid=35873098","typeStr":"album"}]
     */

    private int result;
    private List<DataBean> data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean extends SimpleBannerInfo {
        /**
         * type : 10002
         * id : 36042538
         * picUrl : https://y.gtimg.cn/music/common/upload/MUSIC_FOCUS/4575224.jpg?max_age=2592000
         * h5Url : https://y.qq.com/musicmac/v6/album/detail.html?albumid=36042538
         * typeStr : album
         */

        private String type;
        private String id;
        private String picUrl;
        private String h5Url;
        private String typeStr;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getH5Url() {
            return h5Url;
        }

        public void setH5Url(String h5Url) {
            this.h5Url = h5Url;
        }

        public String getTypeStr() {
            return typeStr;
        }

        public void setTypeStr(String typeStr) {
            this.typeStr = typeStr;
        }

        @Override
        public Object getXBannerUrl() {
            return null;
        }
    }
}
