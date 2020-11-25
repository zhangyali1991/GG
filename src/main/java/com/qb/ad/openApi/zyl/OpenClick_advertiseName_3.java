package com.qb.ad.openApi.zyl;

import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.click;
import static com.qb.ad.util.ApiUtilsTest.exposure_POST;

/**
 * 根据车场名称、流量主名称获取对应的partnerId和private_key和park_Id
 * 获取广告---曝光和点击
 * 无媒体类型,返回一个计划(代码默认媒体是微信公众号)
 */

public class OpenClick_advertiseName_3 {

    static int open_cnt = 1;
    static int click_cnt = 1;
    static String  adId ="adclick7addd6bfd5b347f1b42c6653d0d42171";

    @DataProvider(name = "data")
    public static Object[][] dataPro() {
        return new Object[][]
//                流量主名称,车场名称，广告位id(1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功)
//                {{"ZYL流量主Auto1021153856","MY车场Auto1022104100","5"}};
                {{"ZYL流量主Auto1119113247","MY车场Auto1119155342","5"}};
    }

    @Test(dataProvider = "data")
    public static void openClick_advertiseName(String traffic_name,String parking_name,String adPosId ) throws Exception {
//        根据traffic_name找到traffic_id,partnerId和private_key
        String select_sql_1 = "select id,partner_id,private_key  from traffic_info where traffic_name='" + traffic_name + "'";
        String[] str = new String[]{"id", "partner_id", "private_key"};
        Map<String, String> map = MysqlDeal.mysqlDeal(select_sql_1, str);
        String partnerId = map.get("partner_id");
        String private_key = map.get("private_key");
        String traffic_id = map.get("id");
//        根据车场名称，流量主id找park_Id
        String select_sql_2="select id,serial_number from parking_info where traffic_id='"+traffic_id+"' and parking_name='"+parking_name+"'";
       String[] str2=new String[]{"id","serial_number"};
        Map<String, String> map1 = MysqlDeal.mysqlDeal(select_sql_2, str2);
        String park_Id = map1.get("serial_number").split("-")[1];
//        曝光、点击
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
                System.out.println("========="+adPosId);
                adId=exposure_POST(park_Id, partnerId, private_key, adPosId);
                if (click_cnt-- > 0 && adId != null) {
                    //                    非小程序
//                    adId="78796845277548544";//指定点击某个广告
//                    click(DataTest.click_url,adId, park_Id, partnerId, private_key);
//                    小程序
//                    click(DataTest.click_url_landing,adId, park_Id, partnerId, private_key);
                }
            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }

}



