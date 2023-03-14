package com.zpp.mobile.zmusic.enerty;

import java.util.List;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.enerty
 * @ClassName: HomeEnerty
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/3 16:54
 * @UpdateUser:
 * @UpdateDate: 2023/3/3 16:54
 * @UpdateRemark:
 */
public class HomeEnerty {
    private int result;
    private DataBean data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * list : [{"album_pic_mid":"","content_id":7745421521,"cover":"http://qpic.y.qq.com/music_cover/zQII3lJrGSNNoWObRlPoys4sNl35qyw1JX0NNIVlGDR9GDu4dK7R4Q/300?n=1","creator":2749180238,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":44250084,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"时代少年团｜我们一起并肩前行","tjreport":"","type":10014,"username":"顾雨菲"},{"album_pic_mid":"004QHJ0A3rXB9Y","content_id":7675104902,"cover":"http://qpic.y.qq.com/music_cover/NdzibUgT17lZoDhtI4ozl86fWZOuXuCfP7iaduiauuv9kxiciayXicoXp1icQ/300?n=1","creator":2186002180,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":14004025,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"纯音乐☁超治愈☁适合学习喔～","tjreport":"","type":10014,"username":"平泽唯唯"},{"album_pic_mid":"","content_id":3540484302,"cover":"http://qpic.y.qq.com/music_cover/Cz8Z9ECDQia3gE2YticLiaJ22KNOu00Czu4RYkZmia3kAhUCYhiaPZ6qXQg/300?n=1","creator":931905769,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":70847393,"pic_mid":"000r2wk20Ko2OZ","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"学霸必备：专心写作业 享受轻音乐好时光","tjreport":"","type":10014,"username":"陈哲"},{"album_pic_mid":"003SK5X22P15Fc","content_id":8029241405,"cover":"http://qpic.y.qq.com/music_cover/kGLjZpdYBzic5qRiclmCYnIqA1cicEhE2iaiaVQ2VsrNfkDL3VTlF41vQeicJo3TORyjEP/300?n=1","creator":1152921504768511500,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":2901501,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"『独家欧美』晚风踩着云朵贩卖爱","tjreport":"","type":10014,"username":"honeysea🍯"},{"album_pic_mid":"000I5jJB3blWeN","content_id":892344800,"cover":"http://qpic.y.qq.com/music_cover/H4L7icoRhSgTiaJ9e6rNiaM8UDZPUUVp2YNicNcGwXfIBevr2FUPTEia5Tg/300?n=1","creator":1587080800,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":11579863,"pic_mid":"002SOanN36Cn6W","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"\u201c三杰\u201d 时光荏苒,追寻逝去流年","tjreport":"","type":10014,"username":"鲸落化为孤岛"},{"album_pic_mid":"","content_id":4144081013,"cover":"http://qpic.y.qq.com/music_cover/sCdyUKgxMOFRx0cRlichSyiblJsoZwNMjfXbCsSHFN5VzMaPKfiaVvKLw/300?n=1","creator":294109499,"edge_mark":"","id":0,"is_dj":false,"is_vip":false,"jump_url":"","listen_num":5446994,"pic_mid":"001kKNCs05X1U7","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"Trap Rap丨慵懒毒性的迷幻说唱","tjreport":"","type":10014,"username":"冷山集"},{"album_pic_mid":"004BMRwh1rFgxf","content_id":7915412634,"cover":"http://qpic.y.qq.com/music_cover/ebxVDMSrIr0KHic07h73iaczzoeyZsjb9j01rmmlCafZmJSH4TfF4aKQ/300?n=1","creator":1242012453,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":2355965,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"纯音入眠佳曲: 治愈午后小时光","tjreport":"","type":10014,"username":"自渡·"},{"album_pic_mid":"","content_id":7727231376,"cover":"http://qpic.y.qq.com/music_cover/EXVh00J0l1orGx5nKZymFUySLctkBibpFtNX47YA5Hxo07icA9KtVvPQ/300?n=1","creator":2638819171,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":3524679,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"中文MC感情麦：喊出人生道理","tjreport":"","type":10014,"username":"王亚鹏"},{"album_pic_mid":"0032YJyg2yF6Dd","content_id":7950589030,"cover":"http://qpic.y.qq.com/music_cover/Zqn9d9hvgT1O39PeFzU41Hp5NT1aq0rvZlanf9D1ediaAKibx9NIOSlQ/300?n=1","creator":2900403492,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":88742525,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"「独享时光」独处是一个人的清欢","tjreport":"","type":10014,"username":"安可"},{"album_pic_mid":"000tgRoL13FtLP","content_id":8119485961,"cover":"http://qpic.y.qq.com/music_cover/S9gjdWgE7YHcVKbco05ibzZicnhn2uZ8YcQg0yaqBpxMHCW5h38NJV8Q/300?n=1","creator":471328934,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":6905727,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"古风戏腔 |戏已开场 八方开听","tjreport":"","type":10014,"username":"青春猪头少年"},{"album_pic_mid":"000n3m8q2rGbs7","content_id":8039753464,"cover":"http://qpic.y.qq.com/music_cover/DuKUYHgAKNJF4HrKEl0FiazorlnZJYhBuT2vib9xCILP21q5tVPyibqew/300?n=1","creator":1805446925,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":18170569,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"片段翻唱 ｜把落日余晖藏在心里","tjreport":"","type":10014,"username":"半岛"},{"album_pic_mid":"002PWhAB3xF3YX","content_id":8054858756,"cover":"http://qpic.y.qq.com/music_cover/It6JAhhBKnxpIb5RK4NEW74QhjWicIRqXys99libXsibAteuJy7kribNicCtGEhaUQ1icy/300?n=1","creator":1152921505114010400,"edge_mark":"","id":0,"is_dj":false,"is_vip":true,"jump_url":"","listen_num":5193804,"pic_mid":"","rcmdcontent":"","rcmdtemplate":"编辑推荐","rcmdtype":0,"singerid":0,"title":"Rapper情话看世间万物皆是浪漫","tjreport":"","type":10014,"username":"Koi"}]
         * count : 12
         */

        private int count;
        private List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * album_pic_mid :
             * content_id : 7745421521
             * cover : http://qpic.y.qq.com/music_cover/zQII3lJrGSNNoWObRlPoys4sNl35qyw1JX0NNIVlGDR9GDu4dK7R4Q/300?n=1
             * creator : 2749180238
             * edge_mark :
             * id : 0
             * is_dj : false
             * is_vip : true
             * jump_url :
             * listen_num : 44250084
             * pic_mid :
             * rcmdcontent :
             * rcmdtemplate : 编辑推荐
             * rcmdtype : 0
             * singerid : 0
             * title : 时代少年团｜我们一起并肩前行
             * tjreport :
             * type : 10014
             * username : 顾雨菲
             */

            private String album_pic_mid;
            private long content_id;
            private String cover;
            private long creator;
            private String edge_mark;
            private int id;
            private boolean is_dj;
            private boolean is_vip;
            private String jump_url;
            private int listen_num;
            private String pic_mid;
            private String rcmdcontent;
            private String rcmdtemplate;
            private int rcmdtype;
            private int singerid;
            private String title;
            private String tjreport;
            private int type;
            private String username;

            public String getAlbum_pic_mid() {
                return album_pic_mid;
            }

            public void setAlbum_pic_mid(String album_pic_mid) {
                this.album_pic_mid = album_pic_mid;
            }

            public long getContent_id() {
                return content_id;
            }

            public void setContent_id(long content_id) {
                this.content_id = content_id;
            }

            public String getCover() {
                return cover;
            }

            public void setCover(String cover) {
                this.cover = cover;
            }

            public long getCreator() {
                return creator;
            }

            public void setCreator(long creator) {
                this.creator = creator;
            }

            public String getEdge_mark() {
                return edge_mark;
            }

            public void setEdge_mark(String edge_mark) {
                this.edge_mark = edge_mark;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isIs_dj() {
                return is_dj;
            }

            public void setIs_dj(boolean is_dj) {
                this.is_dj = is_dj;
            }

            public boolean isIs_vip() {
                return is_vip;
            }

            public void setIs_vip(boolean is_vip) {
                this.is_vip = is_vip;
            }

            public String getJump_url() {
                return jump_url;
            }

            public void setJump_url(String jump_url) {
                this.jump_url = jump_url;
            }

            public int getListen_num() {
                return listen_num;
            }

            public void setListen_num(int listen_num) {
                this.listen_num = listen_num;
            }

            public String getPic_mid() {
                return pic_mid;
            }

            public void setPic_mid(String pic_mid) {
                this.pic_mid = pic_mid;
            }

            public String getRcmdcontent() {
                return rcmdcontent;
            }

            public void setRcmdcontent(String rcmdcontent) {
                this.rcmdcontent = rcmdcontent;
            }

            public String getRcmdtemplate() {
                return rcmdtemplate;
            }

            public void setRcmdtemplate(String rcmdtemplate) {
                this.rcmdtemplate = rcmdtemplate;
            }

            public int getRcmdtype() {
                return rcmdtype;
            }

            public void setRcmdtype(int rcmdtype) {
                this.rcmdtype = rcmdtype;
            }

            public int getSingerid() {
                return singerid;
            }

            public void setSingerid(int singerid) {
                this.singerid = singerid;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getTjreport() {
                return tjreport;
            }

            public void setTjreport(String tjreport) {
                this.tjreport = tjreport;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getUsername() {
                return username;
            }

            public void setUsername(String username) {
                this.username = username;
            }
        }
    }
}
