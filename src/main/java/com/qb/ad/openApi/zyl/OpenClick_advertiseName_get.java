package com.qb.ad.openApi.zyl;

import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.*;

/**
 * 获取广告---曝光和点击
 * 传媒体类型，响应返回广告列表
 *点击按照返回的计划列表选择一个广告进行点击
 */

public class OpenClick_advertiseName_get {


    static int open_cnt = 1;
    static int click_cnt = 1;
    static String adId = "93373203034988544";//点击的时候传，曝光不需要该字段
    @DataProvider(name = "data")
    public static Object[][] dataPro() {
        return new Object[][]
//                流量主名称,车场名称，广告位id，媒体类型(1-公众号；2-小程序;4-支付宝;3-app)
//                {{"ZYL流量主Auto1021153856","MY车场Auto1022104100","3","4"}};
                {{"ZYL流量主Auto1119113247","MY车场Auto1119155342","5","1"}};
    }
    @Test(dataProvider = "data")
    public static void openClick_advertiseName(String traffic_name,String parking_name,String adPosId,String medium) throws Exception {
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
//        曝光点击
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
               String result=  exposure_GetNew(park_Id, partnerId, private_key, adPosId,medium);
                if (click_cnt-- > 0 && adId != null) {
                    //                    非小程序
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



