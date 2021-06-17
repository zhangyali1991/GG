package com.qb.ad.openApi.zyl;

import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import com.zzrb.enumm.CityIdEnum;
import com.zzrb.enumm.CityIdEnumOld;

import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.*;


/**
 * 创建车场、新增广告位
 */
public class CreateParkAdvertisePosition_2 {
    /*v3:adPos_url_3    v2:adPos_url    v1:adPos_url_1*/
//    static String url = DataTest.adPos_url;
//    static String url = DataTest.adPos_url_1;
    static String traffic_name = "ZYL流量主Auto0422135558"; // 需要新增车场广告位的流量主  运营管理-流量主列表
//    static String cityId = CityIdEnum.BEIJING.getCode();
    static String cityId = DataTest.cityId;
    static String adPosIds = "6";//1#2#3#4#5  1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功
    static String medium = "1";//1#2#41:微信公众号 2:微信小程序 3:app 4:支付宝

    @org.testng.annotations.Test
    public static void createParkAdvertisePosition() throws Exception {
        //根据流量主名查出partnerId和private_key
        String select_sql = "SELECT partner_id,private_key FROM traffic_info WHERE traffic_name = '" + traffic_name + "'";
        String[] str = new String[]{"partner_id", "private_key"};
        Map<String, String> selectMap = MysqlDeal.mysqlDeal(select_sql, str);
        System.out.print("selectMap: " + selectMap);
        String partnerId = selectMap.get("partner_id").toString();
        String private_key = selectMap.get("private_key").toString();

        //创建车场——根据traffic_name创建车场
//        String parkId = createPark(partnerId, private_key);
//        String parkId = "110100202105073682";
//        新增或更新车场
//        updatePark(parkId, partnerId, private_key );
//        获取车场
//        getPark(parkId , partnerId);//支持v1 v2系统异常
//        新增广告位v1版本
//        String parkId="010202010214097";
//        createAdvertisePosition_v1(adPosIds, parkId , partnerId , private_key );
//        新增广告位v2版本
//        createAdvertisePosition_v2(adPosIds, parkId , partnerId , private_key );
//        新增广告位v3版本,新增mediumType版本
//        String parkId="110100202105073682";
//        createAdvertisePosition_v3(adPosIds, parkId, partnerId, private_key, medium);
//                更新广告位v1
//        createAdvertisePosition_v1(adPosIds, parkId , partnerId , private_key);
//        更新广告位v2
//        createAdvertisePosition_v2(adPosIds, parkId , partnerId , private_key);
//        更新广告位v3
//        createAdvertisePosition_v3(adPosIds, parkId , partnerId , private_key,medium);
        //获取广告位
        String parkId="110100202105144891";
        getAdvertisePosition(parkId , partnerId , private_key);   //只支持v1

    }

}
