package com.zpp.mobile.zmusic.enerty;

import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.enerty
 * @ClassName: HomeSongEnerty
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 11:52
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 11:52
 * @UpdateRemark:
 */
public class HomeSongEnerty {


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

    public static class DataBean {
        /**
         * title : 巅峰榜
         * list : [{"value":62,"topId":62,"label":"飙升榜","intro":"QQ音乐站内播放热度飙升最快的前100首歌曲，每日更新。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":18633712,"song":[{"rank":1,"rankType":6,"rankValue":"31%","recType":0,"songId":392702643,"vid":"","albumMid":"002sygnA1T984u","title":"是妈妈是女儿","singerName":"黄绮珊/希林娜依高","singerMid":"001nMsEp1RMsiO","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002sygnA1T984u_2.jpg","mvid":0},{"rank":2,"rankType":6,"rankValue":"23%","recType":0,"songId":5144030,"vid":"","albumMid":"000EgPSh3G89kL","title":"背叛 (Live)","singerName":"曹格","singerMid":"001iHAHQ3FTqQX","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000000EgPSh3G89kL_1.jpg","mvid":0},{"rank":3,"rankType":6,"rankValue":"18%","recType":0,"songId":7124843,"vid":"","albumMid":"001txJcS1MIlDi","title":"背叛","singerName":"杨宗纬","singerMid":"003tMm0y0TuewY","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001txJcS1MIlDi.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000002Mg4yA3OccTc.jpg"},{"value":26,"topId":26,"label":"热歌榜","intro":"QQ音乐站内播放热度前300首歌曲，每日更新。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":19100000,"song":[{"rank":1,"rankType":3,"rankValue":"0","recType":0,"songId":384263699,"vid":"","albumMid":"002PwL9x3TiVdh","title":"乌梅子酱","singerName":"李荣浩","singerMid":"000aHmbL2aPXWH","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002PwL9x3TiVdh_1.jpg","mvid":0},{"rank":2,"rankType":3,"rankValue":"0","recType":0,"songId":368139519,"vid":"","albumMid":"002HcXA60aeTLD","title":"就让这大雨全都落下","singerName":"容祖儿","singerMid":"001uXFgt1kpLyI","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002HcXA60aeTLD_1.jpg","mvid":0},{"rank":3,"rankType":1,"rankValue":"11","recType":0,"songId":392702643,"vid":"","albumMid":"002sygnA1T984u","title":"是妈妈是女儿","singerName":"黄绮珊/希林娜依高","singerMid":"001nMsEp1RMsiO","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002sygnA1T984u_2.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000003Gy87o2tD6wl.jpg"},{"value":27,"topId":27,"label":"新歌榜","intro":"QQ音乐站内播放热度排名前100首新歌，每日更新。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":170217,"song":[{"rank":1,"rankType":3,"rankValue":"0","recType":0,"songId":396710011,"vid":"","albumMid":"0027gqTJ2vh1Fz","title":"苦咖啡·唯一","singerName":"那奇沃夫/KKECHO","singerMid":"0043ujuR27z2p8","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000027gqTJ2vh1Fz_1.jpg","mvid":0},{"rank":2,"rankType":3,"rankValue":"0","recType":0,"songId":399068181,"vid":"","albumMid":"001Vl5kJ2vk6Ut","title":"5:23PM","singerName":"宋亚轩","singerMid":"003yal7K3fzAGl","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001Vl5kJ2vk6Ut_1.jpg","mvid":0},{"rank":3,"rankType":3,"rankValue":"0","recType":0,"songId":396112160,"vid":"","albumMid":"0042mJP52iOjn5","title":"忘了","singerName":"周林枫","singerMid":"002LlLHa3jSdoa","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000042mJP52iOjn5_2.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000003OKubC2dkExs.jpg"},{"value":4,"topId":4,"label":"流行指数榜","intro":"QQ音乐站内播放相对涨幅排名前100首歌曲，每日更新。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":7953220,"song":[{"rank":1,"rankType":6,"rankValue":"183%","recType":0,"songId":399068181,"vid":"","albumMid":"001Vl5kJ2vk6Ut","title":"5:23PM","singerName":"宋亚轩","singerMid":"003yal7K3fzAGl","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001Vl5kJ2vk6Ut_1.jpg","mvid":0},{"rank":2,"rankType":6,"rankValue":"106%","recType":0,"songId":395463211,"vid":"","albumMid":"000S7U533pd8KZ","title":"感谢有你陪在我身旁","singerName":"薛朋朋/古文豪/左文正","singerMid":"0034EH151w7FdC","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000000S7U533pd8KZ_1.jpg","mvid":0},{"rank":3,"rankType":6,"rankValue":"106%","recType":0,"songId":393949802,"vid":"","albumMid":"000WDNPt4XUrXs","title":"谁","singerName":"曲肖冰","singerMid":"001ZVMXf3ZYVX7","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000000WDNPt4XUrXs_2.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000000CgGsZ2LBTWY.jpg"},{"value":57,"topId":57,"label":"喜力电音榜","intro":"QQ音乐播放热度最高的电音歌曲TOP50，每周更新。","period":"2023_9","updateTime":"2023-03-02","listenNum":1403255,"song":[{"rank":1,"rankType":4,"rankValue":"0","recType":0,"songId":397447822,"vid":"","albumMid":"001d3W0x4DRn3z","title":"Not Cinderella","singerName":"宋雨琦/하이퍼타임","singerMid":"003GgG3V1fkAFf","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001d3W0x4DRn3z_1.jpg","mvid":0},{"rank":2,"rankType":2,"rankValue":"1","recType":0,"songId":394444590,"vid":"","albumMid":"0035N8lV3X7fWw","title":"冰川之泪 Tears from the Ice River","singerName":"Terry Zhong 钟天利/考拉kora","singerMid":"001pW4WY4TWNk4","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000035N8lV3X7fWw_4.jpg","mvid":0},{"rank":3,"rankType":1,"rankValue":"2","recType":0,"songId":390980914,"vid":"","albumMid":"0036ZLdt4djv3M","title":"春时·雪梅赋","singerName":"Onism./Bumpÿ/故茕","singerMid":"004RrX0B0WU9fb","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000036ZLdt4djv3M.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000000od6Ek0EBX8U.jpg"},{"value":52,"topId":52,"label":"腾讯音乐人原创榜","intro":"QQ音乐最新最热的腾讯音乐人原创作品TOP100。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":427884,"song":[{"rank":1,"rankType":5,"rankValue":"0","recType":0,"songId":399329081,"vid":"","albumMid":"004fbbQ24Ta2rW","title":"50-1+3 KG","singerName":"张羽涵Leezi","singerMid":"0038ZmmO06QH29","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000004fbbQ24Ta2rW_3.jpg","mvid":0},{"rank":2,"rankType":1,"rankValue":"18","recType":0,"songId":398109445,"vid":"","albumMid":"00065VH52AYdH3","title":"绯红色抱枕","singerName":"Feiii","singerMid":"002gJz1W0d4YeR","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M00000065VH52AYdH3_2.jpg","mvid":0},{"rank":3,"rankType":5,"rankValue":"0","recType":0,"songId":399372248,"vid":"","albumMid":"004fbbQ24Ta2rW","title":"Mannequin 塑料模特","singerName":"SIENA","singerMid":"004U5DLR42AjcN","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000004fbbQ24Ta2rW_3.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000003huepp3Eb99q.jpg"},{"value":67,"topId":67,"label":"听歌识曲榜","intro":"QQ音乐用户使用\u201c听歌识曲\u201d功能捕捉热度最高的歌曲TOP100，每日更新。","period":"2023-03-09","updateTime":"2023-03-09","listenNum":3049800,"song":[{"rank":1,"rankType":3,"rankValue":"0","recType":0,"songId":357531938,"vid":"","albumMid":"003DFrnj26SMZU","title":"可能","singerName":"程响","singerMid":"003iPzNg35cWzp","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000003DFrnj26SMZU_2.jpg","mvid":0},{"rank":2,"rankType":3,"rankValue":"0","recType":0,"songId":396112160,"vid":"","albumMid":"0042mJP52iOjn5","title":"忘了","singerName":"周林枫","singerMid":"002LlLHa3jSdoa","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000042mJP52iOjn5_2.jpg","mvid":0},{"rank":3,"rankType":3,"rankValue":"0","recType":0,"songId":396710011,"vid":"","albumMid":"0027gqTJ2vh1Fz","title":"苦咖啡·唯一","singerName":"那奇沃夫/KKECHO","singerMid":"0043ujuR27z2p8","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000027gqTJ2vh1Fz_1.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000004MEydx4XLOUV.jpg"},{"value":201,"topId":201,"label":"MV榜","intro":"QQ音乐播放得分最高的官方MV TOP排行榜，发行期90天内。","period":"","updateTime":"","listenNum":1450225,"song":[{"rank":1,"rankType":0,"rankValue":"","recType":1,"songId":0,"vid":"000ZWMj02OdhhA","albumMid":"0048dhTB024igd","title":"意犹在 (大理寺日志第二季OP)","singerName":"周深","singerMid":"003fA5G40k6hKc","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M0000048dhTB024igd_1.jpg","mvid":0},{"rank":2,"rankType":0,"rankValue":"","recType":1,"songId":0,"vid":"0034Z4yM2RG9m0","albumMid":"003zzzm62mna7A","title":"부석순 (SEVENTEEN) '파이팅 해야지 (Feat. 이영지)' Official MV (Choreography Version)","singerName":"BSS/李泳知","singerMid":"001J1wmG2twrzz","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000003zzzm62mna7A_2.jpg","mvid":0},{"rank":3,"rankType":0,"rankValue":"","recType":1,"songId":0,"vid":"001BFqNN1ogb9G","albumMid":"001rb1ah0bFKMo","title":"花开忘忧","singerName":"周深","singerMid":"003fA5G40k6hKc","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001rb1ah0bFKMo_1.jpg","mvid":0}],"picUrl":"http://y.gtimg.cn/music/photo_new/T003R500x500M000004bIrgE1SREYJ.jpg"}]
         */

        private String title;
        private List<ListBean> list;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * value : 62
             * topId : 62
             * label : 飙升榜
             * intro : QQ音乐站内播放热度飙升最快的前100首歌曲，每日更新。
             * period : 2023-03-09
             * updateTime : 2023-03-09
             * listenNum : 18633712
             * song : [{"rank":1,"rankType":6,"rankValue":"31%","recType":0,"songId":392702643,"vid":"","albumMid":"002sygnA1T984u","title":"是妈妈是女儿","singerName":"黄绮珊/希林娜依高","singerMid":"001nMsEp1RMsiO","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000002sygnA1T984u_2.jpg","mvid":0},{"rank":2,"rankType":6,"rankValue":"23%","recType":0,"songId":5144030,"vid":"","albumMid":"000EgPSh3G89kL","title":"背叛 (Live)","singerName":"曹格","singerMid":"001iHAHQ3FTqQX","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000000EgPSh3G89kL_1.jpg","mvid":0},{"rank":3,"rankType":6,"rankValue":"18%","recType":0,"songId":7124843,"vid":"","albumMid":"001txJcS1MIlDi","title":"背叛","singerName":"杨宗纬","singerMid":"003tMm0y0TuewY","songType":0,"uuidCnt":0,"cover":"http://y.gtimg.cn/music/photo_new/T002R300x300M000001txJcS1MIlDi.jpg","mvid":0}]
             * picUrl : http://y.gtimg.cn/music/photo_new/T003R500x500M000002Mg4yA3OccTc.jpg
             */

            private int value;
            private int topId;
            private String label;
            private String intro;
            private String period;
            private String updateTime;
            private int listenNum;
            private String picUrl;
            private List<SongBean> song;

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public int getTopId() {
                return topId;
            }

            public void setTopId(int topId) {
                this.topId = topId;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getIntro() {
                return intro;
            }

            public void setIntro(String intro) {
                this.intro = intro;
            }

            public String getPeriod() {
                return period;
            }

            public void setPeriod(String period) {
                this.period = period;
            }

            public String getUpdateTime() {
                return updateTime;
            }

            public void setUpdateTime(String updateTime) {
                this.updateTime = updateTime;
            }

            public int getListenNum() {
                return listenNum;
            }

            public void setListenNum(int listenNum) {
                this.listenNum = listenNum;
            }

            public String getPicUrl() {
                return picUrl;
            }

            public void setPicUrl(String picUrl) {
                this.picUrl = picUrl;
            }

            public List<SongBean> getSong() {
                return song;
            }

            public void setSong(List<SongBean> song) {
                this.song = song;
            }

            public static class SongBean {
                /**
                 * rank : 1
                 * rankType : 6
                 * rankValue : 31%
                 * recType : 0
                 * songId : 392702643
                 * vid :
                 * albumMid : 002sygnA1T984u
                 * title : 是妈妈是女儿
                 * singerName : 黄绮珊/希林娜依高
                 * singerMid : 001nMsEp1RMsiO
                 * songType : 0
                 * uuidCnt : 0
                 * cover : http://y.gtimg.cn/music/photo_new/T002R300x300M000002sygnA1T984u_2.jpg
                 * mvid : 0
                 */

                private int rank;
                private int rankType;
                private String rankValue;
                private int recType;
                private int songId;
                private String vid;
                private String albumMid;
                private String title;
                private String singerName;
                private String singerMid;
                private int songType;
                private int uuidCnt;
                private String cover;
                private int mvid;

                public int getRank() {
                    return rank;
                }

                public void setRank(int rank) {
                    this.rank = rank;
                }

                public int getRankType() {
                    return rankType;
                }

                public void setRankType(int rankType) {
                    this.rankType = rankType;
                }

                public String getRankValue() {
                    return rankValue;
                }

                public void setRankValue(String rankValue) {
                    this.rankValue = rankValue;
                }

                public int getRecType() {
                    return recType;
                }

                public void setRecType(int recType) {
                    this.recType = recType;
                }

                public int getSongId() {
                    return songId;
                }

                public void setSongId(int songId) {
                    this.songId = songId;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getAlbumMid() {
                    return albumMid;
                }

                public void setAlbumMid(String albumMid) {
                    this.albumMid = albumMid;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSingerName() {
                    return singerName;
                }

                public void setSingerName(String singerName) {
                    this.singerName = singerName;
                }

                public String getSingerMid() {
                    return singerMid;
                }

                public void setSingerMid(String singerMid) {
                    this.singerMid = singerMid;
                }

                public int getSongType() {
                    return songType;
                }

                public void setSongType(int songType) {
                    this.songType = songType;
                }

                public int getUuidCnt() {
                    return uuidCnt;
                }

                public void setUuidCnt(int uuidCnt) {
                    this.uuidCnt = uuidCnt;
                }

                public String getCover() {
                    return cover;
                }

                public void setCover(String cover) {
                    this.cover = cover;
                }

                public int getMvid() {
                    return mvid;
                }

                public void setMvid(int mvid) {
                    this.mvid = mvid;
                }
            }
        }
    }
}
