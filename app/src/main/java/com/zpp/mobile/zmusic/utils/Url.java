package com.zpp.mobile.zmusic.utils;

import rxhttp.wrapper.annotation.DefaultDomain;

/**
 * @ProjectName: MyMusic
 * @Package: com.zpp.mobile.mymusic.utils
 * @ClassName: Url
 * @Description:
 * @Author: zpp
 * @CreateDate: 2023/3/6 15:04
 * @UpdateUser:
 * @UpdateDate: 2023/3/6 15:04
 * @UpdateRemark:
 */
public class Url {
    @DefaultDomain
    public static String baseUrl = " http://txwrku.natappfree.cc";

    public static String homeRecommend = "/personalized";

    public static String BANNER = "/banner";

    public static String homeSong = "/personalized/newsong";

    public static String songsheetinfo = "/playlist/detail";

    public static String songPlyer = "/song/url/v1";

    public static String search = "/search";
}
