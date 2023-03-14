package com.zpp.mobile.zmusic.enerty;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @ProjectName: Zmusic
 * @Package: com.zpp.mobile.zmusic.enerty
 * @ClassName: SongEnerty
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/10 11:45
 * @UpdateUser:
 * @UpdateDate: 2023/3/10 11:45
 * @UpdateRemark:
 */
public class SongEnerty {


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


        private String lan;
        private int type;
        private List<ListBean> list;

        public String getLan() {
            return lan;
        }

        public void setLan(String lan) {
            this.lan = lan;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 399788022
             * type : 0
             * mid : 003LJP9L2hcPg9
             * name : 祝你平安
             * title : 祝你平安
             * subtitle : 《保你平安》电影主题曲
             * singer : [{"id":1507534,"mid":"001BHDR33FZVZ0","name":"毛不易","title":"毛不易","type":0,"uin":0,"pmid":""}]
             * album : {"id":36025070,"mid":"001kVoZ90nSpPX","name":"祝你平安","title":"祝你平安","subtitle":"《保你平安》电影主题曲","time_public":"2023-03-08","pmid":"001kVoZ90nSpPX_1"}
             * mv : {"id":2062106,"vid":"002EwMKn3KtL5d","name":"","title":"","vt":0}
             * interval : 262
             * isonly : 0
             * language : 0
             * genre : 37
             * index_cd : 0
             * index_album : 1
             * time_public : 2023-03-08
             * status : 31
             * fnote : 0
             * file : {"media_mid":"003LJP9L2hcPg9","size_24aac":0,"size_48aac":1593737,"size_96aac":3192800,"size_192ogg":5363155,"size_192aac":6330013,"size_128mp3":4193582,"size_320mp3":10483659,"size_ape":0,"size_flac":51232474,"size_dts":0,"size_try":960887,"try_begin":0,"try_end":0,"url":"","size_hires":0,"hires_sample":0,"hires_bitdepth":0,"b_30s":0,"e_30s":60000,"size_96ogg":2840703,"size_360ra":[],"size_dolby":0,"size_new":[163685077,24501337,63637311,10191025]}
             * pay : {"pay_month":0,"price_track":0,"price_album":0,"pay_play":0,"pay_down":0,"pay_status":0,"time_free":0}
             * action : {"switch":81683,"msgid":0,"alert":11,"icons":135752,"msgshare":0,"msgfav":0,"msgdown":0,"msgpay":0,"switch2":0,"icon2":0}
             * ksong : {"id":71520950,"mid":"0026d2XX0v8BmF"}
             * volume : {"gain":-5.901,"peak":0.954,"lra":11.928}
             * label : 0
             * url :
             * bpm : 0
             * version : 0
             * trace :
             * data_type : 0
             * modify_stamp : 0
             * pingpong :
             * aid : 0
             * ppurl :
             * tid : 0
             * ov : 0
             * sa : 1024
             * es :
             * vs : ["060okM9R49CWVF","","","000Ks3NV13X7CF","004XSbcG0HUZsj"]
             * vi : [1903625]
             * ktag : 0
             */

            private int id;
            private int type;
            private String mid;
            private String name;
            private String title;
            private String subtitle;
            private AlbumBean album;
            private MvBean mv;
            private int interval;
            private int isonly;
            private int language;
            private int genre;
            private int index_cd;
            private int index_album;
            private String time_public;
            private int status;
            private int fnote;
            private FileBean file;
            private PayBean pay;
            private ActionBean action;
            private KsongBean ksong;
            private VolumeBean volume;
            private String label;
            private String url;
            private int bpm;
            private int version;
            private String trace;
            private int data_type;
            private int modify_stamp;
            private String pingpong;
            private int aid;
            private String ppurl;
            private int tid;
            private int ov;
            private int sa;
            private String es;
            private String ktag;
            private List<SingerBean> singer;
            private List<String> vs;
            private List<Integer> vi;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public String getMid() {
                return mid;
            }

            public void setMid(String mid) {
                this.mid = mid;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getSubtitle() {
                return subtitle;
            }

            public void setSubtitle(String subtitle) {
                this.subtitle = subtitle;
            }

            public AlbumBean getAlbum() {
                return album;
            }

            public void setAlbum(AlbumBean album) {
                this.album = album;
            }

            public MvBean getMv() {
                return mv;
            }

            public void setMv(MvBean mv) {
                this.mv = mv;
            }

            public int getInterval() {
                return interval;
            }

            public void setInterval(int interval) {
                this.interval = interval;
            }

            public int getIsonly() {
                return isonly;
            }

            public void setIsonly(int isonly) {
                this.isonly = isonly;
            }

            public int getLanguage() {
                return language;
            }

            public void setLanguage(int language) {
                this.language = language;
            }

            public int getGenre() {
                return genre;
            }

            public void setGenre(int genre) {
                this.genre = genre;
            }

            public int getIndex_cd() {
                return index_cd;
            }

            public void setIndex_cd(int index_cd) {
                this.index_cd = index_cd;
            }

            public int getIndex_album() {
                return index_album;
            }

            public void setIndex_album(int index_album) {
                this.index_album = index_album;
            }

            public String getTime_public() {
                return time_public;
            }

            public void setTime_public(String time_public) {
                this.time_public = time_public;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getFnote() {
                return fnote;
            }

            public void setFnote(int fnote) {
                this.fnote = fnote;
            }

            public FileBean getFile() {
                return file;
            }

            public void setFile(FileBean file) {
                this.file = file;
            }

            public PayBean getPay() {
                return pay;
            }

            public void setPay(PayBean pay) {
                this.pay = pay;
            }

            public ActionBean getAction() {
                return action;
            }

            public void setAction(ActionBean action) {
                this.action = action;
            }

            public KsongBean getKsong() {
                return ksong;
            }

            public void setKsong(KsongBean ksong) {
                this.ksong = ksong;
            }

            public VolumeBean getVolume() {
                return volume;
            }

            public void setVolume(VolumeBean volume) {
                this.volume = volume;
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getUrl() {
                return url;
            }

            public void setUrl(String url) {
                this.url = url;
            }

            public int getBpm() {
                return bpm;
            }

            public void setBpm(int bpm) {
                this.bpm = bpm;
            }

            public int getVersion() {
                return version;
            }

            public void setVersion(int version) {
                this.version = version;
            }

            public String getTrace() {
                return trace;
            }

            public void setTrace(String trace) {
                this.trace = trace;
            }

            public int getData_type() {
                return data_type;
            }

            public void setData_type(int data_type) {
                this.data_type = data_type;
            }

            public int getModify_stamp() {
                return modify_stamp;
            }

            public void setModify_stamp(int modify_stamp) {
                this.modify_stamp = modify_stamp;
            }

            public String getPingpong() {
                return pingpong;
            }

            public void setPingpong(String pingpong) {
                this.pingpong = pingpong;
            }

            public int getAid() {
                return aid;
            }

            public void setAid(int aid) {
                this.aid = aid;
            }

            public String getPpurl() {
                return ppurl;
            }

            public void setPpurl(String ppurl) {
                this.ppurl = ppurl;
            }

            public int getTid() {
                return tid;
            }

            public void setTid(int tid) {
                this.tid = tid;
            }

            public int getOv() {
                return ov;
            }

            public void setOv(int ov) {
                this.ov = ov;
            }

            public int getSa() {
                return sa;
            }

            public void setSa(int sa) {
                this.sa = sa;
            }

            public String getEs() {
                return es;
            }

            public void setEs(String es) {
                this.es = es;
            }

            public String getKtag() {
                return ktag;
            }

            public void setKtag(String ktag) {
                this.ktag = ktag;
            }

            public List<SingerBean> getSinger() {
                return singer;
            }

            public void setSinger(List<SingerBean> singer) {
                this.singer = singer;
            }

            public List<String> getVs() {
                return vs;
            }

            public void setVs(List<String> vs) {
                this.vs = vs;
            }

            public List<Integer> getVi() {
                return vi;
            }

            public void setVi(List<Integer> vi) {
                this.vi = vi;
            }

            public static class AlbumBean {
                /**
                 * id : 36025070
                 * mid : 001kVoZ90nSpPX
                 * name : 祝你平安
                 * title : 祝你平安
                 * subtitle : 《保你平安》电影主题曲
                 * time_public : 2023-03-08
                 * pmid : 001kVoZ90nSpPX_1
                 */

                private int id;
                private String mid;
                private String name;
                private String title;
                private String subtitle;
                private String time_public;
                private String pmid;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getSubtitle() {
                    return subtitle;
                }

                public void setSubtitle(String subtitle) {
                    this.subtitle = subtitle;
                }

                public String getTime_public() {
                    return time_public;
                }

                public void setTime_public(String time_public) {
                    this.time_public = time_public;
                }

                public String getPmid() {
                    return pmid;
                }

                public void setPmid(String pmid) {
                    this.pmid = pmid;
                }
            }

            public static class MvBean {
                /**
                 * id : 2062106
                 * vid : 002EwMKn3KtL5d
                 * name :
                 * title :
                 * vt : 0
                 */

                private int id;
                private String vid;
                private String name;
                private String title;
                private int vt;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getVid() {
                    return vid;
                }

                public void setVid(String vid) {
                    this.vid = vid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getVt() {
                    return vt;
                }

                public void setVt(int vt) {
                    this.vt = vt;
                }
            }

            public static class FileBean {
                /**
                 * media_mid : 003LJP9L2hcPg9
                 * size_24aac : 0
                 * size_48aac : 1593737
                 * size_96aac : 3192800
                 * size_192ogg : 5363155
                 * size_192aac : 6330013
                 * size_128mp3 : 4193582
                 * size_320mp3 : 10483659
                 * size_ape : 0
                 * size_flac : 51232474
                 * size_dts : 0
                 * size_try : 960887
                 * try_begin : 0
                 * try_end : 0
                 * url :
                 * size_hires : 0
                 * hires_sample : 0
                 * hires_bitdepth : 0
                 * b_30s : 0
                 * e_30s : 60000
                 * size_96ogg : 2840703
                 * size_360ra : []
                 * size_dolby : 0
                 * size_new : [163685077,24501337,63637311,10191025]
                 */

                private String media_mid;
                private int size_24aac;
                private int size_48aac;
                private int size_96aac;
                private int size_192ogg;
                private int size_192aac;
                private int size_128mp3;
                private int size_320mp3;
                private int size_ape;
                private int size_flac;
                private int size_dts;
                private int size_try;
                private int try_begin;
                private int try_end;
                private String url;
                private int size_hires;
                private int hires_sample;
                private int hires_bitdepth;
                private int b_30s;
                private int e_30s;
                private int size_96ogg;
                private int size_dolby;
                private List<?> size_360ra;
                private List<Integer> size_new;

                public String getMedia_mid() {
                    return media_mid;
                }

                public void setMedia_mid(String media_mid) {
                    this.media_mid = media_mid;
                }

                public int getSize_24aac() {
                    return size_24aac;
                }

                public void setSize_24aac(int size_24aac) {
                    this.size_24aac = size_24aac;
                }

                public int getSize_48aac() {
                    return size_48aac;
                }

                public void setSize_48aac(int size_48aac) {
                    this.size_48aac = size_48aac;
                }

                public int getSize_96aac() {
                    return size_96aac;
                }

                public void setSize_96aac(int size_96aac) {
                    this.size_96aac = size_96aac;
                }

                public int getSize_192ogg() {
                    return size_192ogg;
                }

                public void setSize_192ogg(int size_192ogg) {
                    this.size_192ogg = size_192ogg;
                }

                public int getSize_192aac() {
                    return size_192aac;
                }

                public void setSize_192aac(int size_192aac) {
                    this.size_192aac = size_192aac;
                }

                public int getSize_128mp3() {
                    return size_128mp3;
                }

                public void setSize_128mp3(int size_128mp3) {
                    this.size_128mp3 = size_128mp3;
                }

                public int getSize_320mp3() {
                    return size_320mp3;
                }

                public void setSize_320mp3(int size_320mp3) {
                    this.size_320mp3 = size_320mp3;
                }

                public int getSize_ape() {
                    return size_ape;
                }

                public void setSize_ape(int size_ape) {
                    this.size_ape = size_ape;
                }

                public int getSize_flac() {
                    return size_flac;
                }

                public void setSize_flac(int size_flac) {
                    this.size_flac = size_flac;
                }

                public int getSize_dts() {
                    return size_dts;
                }

                public void setSize_dts(int size_dts) {
                    this.size_dts = size_dts;
                }

                public int getSize_try() {
                    return size_try;
                }

                public void setSize_try(int size_try) {
                    this.size_try = size_try;
                }

                public int getTry_begin() {
                    return try_begin;
                }

                public void setTry_begin(int try_begin) {
                    this.try_begin = try_begin;
                }

                public int getTry_end() {
                    return try_end;
                }

                public void setTry_end(int try_end) {
                    this.try_end = try_end;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
                }

                public int getSize_hires() {
                    return size_hires;
                }

                public void setSize_hires(int size_hires) {
                    this.size_hires = size_hires;
                }

                public int getHires_sample() {
                    return hires_sample;
                }

                public void setHires_sample(int hires_sample) {
                    this.hires_sample = hires_sample;
                }

                public int getHires_bitdepth() {
                    return hires_bitdepth;
                }

                public void setHires_bitdepth(int hires_bitdepth) {
                    this.hires_bitdepth = hires_bitdepth;
                }

                public int getB_30s() {
                    return b_30s;
                }

                public void setB_30s(int b_30s) {
                    this.b_30s = b_30s;
                }

                public int getE_30s() {
                    return e_30s;
                }

                public void setE_30s(int e_30s) {
                    this.e_30s = e_30s;
                }

                public int getSize_96ogg() {
                    return size_96ogg;
                }

                public void setSize_96ogg(int size_96ogg) {
                    this.size_96ogg = size_96ogg;
                }

                public int getSize_dolby() {
                    return size_dolby;
                }

                public void setSize_dolby(int size_dolby) {
                    this.size_dolby = size_dolby;
                }

                public List<?> getSize_360ra() {
                    return size_360ra;
                }

                public void setSize_360ra(List<?> size_360ra) {
                    this.size_360ra = size_360ra;
                }

                public List<Integer> getSize_new() {
                    return size_new;
                }

                public void setSize_new(List<Integer> size_new) {
                    this.size_new = size_new;
                }
            }

            public static class PayBean {
                /**
                 * pay_month : 0
                 * price_track : 0
                 * price_album : 0
                 * pay_play : 0
                 * pay_down : 0
                 * pay_status : 0
                 * time_free : 0
                 */

                private int pay_month;
                private int price_track;
                private int price_album;
                private int pay_play;
                private int pay_down;
                private int pay_status;
                private int time_free;

                public int getPay_month() {
                    return pay_month;
                }

                public void setPay_month(int pay_month) {
                    this.pay_month = pay_month;
                }

                public int getPrice_track() {
                    return price_track;
                }

                public void setPrice_track(int price_track) {
                    this.price_track = price_track;
                }

                public int getPrice_album() {
                    return price_album;
                }

                public void setPrice_album(int price_album) {
                    this.price_album = price_album;
                }

                public int getPay_play() {
                    return pay_play;
                }

                public void setPay_play(int pay_play) {
                    this.pay_play = pay_play;
                }

                public int getPay_down() {
                    return pay_down;
                }

                public void setPay_down(int pay_down) {
                    this.pay_down = pay_down;
                }

                public int getPay_status() {
                    return pay_status;
                }

                public void setPay_status(int pay_status) {
                    this.pay_status = pay_status;
                }

                public int getTime_free() {
                    return time_free;
                }

                public void setTime_free(int time_free) {
                    this.time_free = time_free;
                }
            }

            public static class ActionBean {
                /**
                 * switch : 81683
                 * msgid : 0
                 * alert : 11
                 * icons : 135752
                 * msgshare : 0
                 * msgfav : 0
                 * msgdown : 0
                 * msgpay : 0
                 * switch2 : 0
                 * icon2 : 0
                 */

                @SerializedName("switch")
                private int switchX;
                private int msgid;
                private int alert;
                private int icons;
                private int msgshare;
                private int msgfav;
                private int msgdown;
                private int msgpay;
                private int switch2;
                private int icon2;

                public int getSwitchX() {
                    return switchX;
                }

                public void setSwitchX(int switchX) {
                    this.switchX = switchX;
                }

                public int getMsgid() {
                    return msgid;
                }

                public void setMsgid(int msgid) {
                    this.msgid = msgid;
                }

                public int getAlert() {
                    return alert;
                }

                public void setAlert(int alert) {
                    this.alert = alert;
                }

                public int getIcons() {
                    return icons;
                }

                public void setIcons(int icons) {
                    this.icons = icons;
                }

                public int getMsgshare() {
                    return msgshare;
                }

                public void setMsgshare(int msgshare) {
                    this.msgshare = msgshare;
                }

                public int getMsgfav() {
                    return msgfav;
                }

                public void setMsgfav(int msgfav) {
                    this.msgfav = msgfav;
                }

                public int getMsgdown() {
                    return msgdown;
                }

                public void setMsgdown(int msgdown) {
                    this.msgdown = msgdown;
                }

                public int getMsgpay() {
                    return msgpay;
                }

                public void setMsgpay(int msgpay) {
                    this.msgpay = msgpay;
                }

                public int getSwitch2() {
                    return switch2;
                }

                public void setSwitch2(int switch2) {
                    this.switch2 = switch2;
                }

                public int getIcon2() {
                    return icon2;
                }

                public void setIcon2(int icon2) {
                    this.icon2 = icon2;
                }
            }

            public static class KsongBean {
                /**
                 * id : 71520950
                 * mid : 0026d2XX0v8BmF
                 */

                private int id;
                private String mid;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }
            }

            public static class VolumeBean {
                /**
                 * gain : -5.901
                 * peak : 0.954
                 * lra : 11.928
                 */

                private double gain;
                private double peak;
                private double lra;

                public double getGain() {
                    return gain;
                }

                public void setGain(double gain) {
                    this.gain = gain;
                }

                public double getPeak() {
                    return peak;
                }

                public void setPeak(double peak) {
                    this.peak = peak;
                }

                public double getLra() {
                    return lra;
                }

                public void setLra(double lra) {
                    this.lra = lra;
                }
            }

            public static class SingerBean {
                /**
                 * id : 1507534
                 * mid : 001BHDR33FZVZ0
                 * name : 毛不易
                 * title : 毛不易
                 * type : 0
                 * uin : 0
                 * pmid :
                 */

                private int id;
                private String mid;
                private String name;
                private String title;
                private int type;
                private int uin;
                private String pmid;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String mid) {
                    this.mid = mid;
                }

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getUin() {
                    return uin;
                }

                public void setUin(int uin) {
                    this.uin = uin;
                }

                public String getPmid() {
                    return pmid;
                }

                public void setPmid(String pmid) {
                    this.pmid = pmid;
                }
            }
        }
    }
}
