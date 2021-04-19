package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;

import static com.qb.ad.util.ApiUtilsPre.*;

/**
 * *************************预发布环境*************************
 * 创建车场、更新车场、获取车场
 * 新增广告位、更新广告位、获取广告位
 */
public class Park_AdvertisePosition {

    static String medium = "1,2";//1:微信公众号 2:微信小程序 3:app
    static String adPosIds = "3";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功

    @org.testng.annotations.Test
    public static void park_advertisePosition() throws Exception {

        //创建车场——根据traffic_name创建车场
        String parkId = createPark(DataPre.partnerId, DataPre.priv_key);
//        String parkId = "010202010288568";
//        String parkId = "";
//        String parkId = "";
        //更新车场
        System.out.println("========更新车场开始=======");
//        updatePark(parkId, DataPre.partnerId, DataPre.priv_key);
        System.out.println("========更新车场结束=======");
        //获取车场
        System.out.println("========获取车场开始=======");
//        getPark(parkId, DataPre.partnerId);//支持v1 v2系统异常
        System.out.println("========获取车场结束=======");
        //新增广告位V1
        createAdvertisePosition_v1("3", parkId, DataPre.partnerId, DataPre.priv_key);
        //新增广告位V2
//        createAdvertisePosition_v2(adPosIds, parkId, DataPre.partnerId, DataPre.priv_key);

        //新增广告位V3
        System.out.println("========新增广告位开始=======");
//        createAdvertisePosition("3", parkId, DataPre.partnerId, DataPre.priv_key,medium); //v1必须填status
        System.out.println("========新增广告位结束=======");
        //更新广告位
        System.out.println("========更新广告位开始=======");
//        createAdvertisePosition("1#2#3#4#5", parkId, DataPre.partnerId, DataPre.priv_key,medium);
        System.out.println("========更新广告位结束=======");
        //获取广告位
        System.out.println("========获取广告位开始=======");
//        getAdvertisePosition(parkId, DataPre.partnerId, DataPre.priv_key);//只支持v1
        System.out.println("========获取广告位结束=======");
    }

}
