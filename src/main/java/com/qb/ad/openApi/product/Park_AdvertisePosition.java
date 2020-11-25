package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;

import static com.qb.ad.util.ApiUtilsPro.*;

/**
 * *************************生产环境*************************
 * 创建车场、更新车场、获取车场
 * 新增广告位、更新广告位、获取广告位
 */
public class Park_AdvertisePosition {
    static String adPosIds = "1#2#3#4#5";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功
    static String medium = "1,2,3,4";//1:微信公众号 2:微信小程序 3:app
    @org.testng.annotations.Test
    public static void park_advertisePosition() throws Exception {

        //创建车场——根据traffic_name创建车场
        String parkId = createPark( DataProduct.partnerId, DataProduct.priv_key );
//        String parkId = "010202007217849";
//        String parkId = "010202007219736";
//        String parkId = "010202007302645";
        //新增或更新车场
//        updatePark(parkId, DataProduct.partnerId, DataProduct.priv_key );
        //获取车场
//        getPark(parkId , DataProduct.partnerId);//支持v1 v2系统异常

        //新增广告位
        createAdvertisePositionV1("1", parkId , DataProduct.partnerId , DataProduct.priv_key); //v1必须填status
//        createAdvertisePositionV2("2", parkId , DataProduct.partnerId , DataProduct.priv_key); //v1必须填status
//        createAdvertisePosition("3#4#5", parkId , DataProduct.partnerId , DataProduct.priv_key,medium);
        //更新广告位
//        createAdvertisePosition("1#2#3#4#5", parkId , DataProduct.partnerId , DataProduct.priv_key,mediumType);
//        createAdvertisePosition("1#2#3#4#5", parkId , DataProduct.partnerId , DataProduct.priv_key,medium);
        //获取广告位
//        getAdvertisePosition(parkId , DataProduct.partnerId , DataProduct.priv_key);//只支持v1
    }

}
