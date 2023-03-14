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
    public static String baseUrl="http://xyjnsk.natappfree.cc";

    public static String homeRecommend="/recommend/playlist/u";

    public static String BANNER="/recommend/banner";

    public static String RECOMMENDSONG="/new/songs";

    public static String homeSong="/top/category";

    public static String songsheetinfo="/songlist";

    public static String songPlyer="/song/urls";
}
