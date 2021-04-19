package com.qb.ad.openApi.zyl;

import com.qb.ad.entity.DataTest;
import com.qb.ad.jdbc.MysqlDeal;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsTest.*;
/**
 * =====对接场景获取商家小票接口=====
 * */
public class OPenClick_sjxp_scene {
    static int open_cnt = 1;
    static String adId = "78796845277548544";

    @DataProvider(name = "data")
    public static Object[][] dataPro() {
        return new Object[][]
//                流量主名称,车场名称
//                {{"ZYL流量主Auto1021153856","MY车场Auto1022104100"}};
//                {{"ZYL流量主Auto1021153856", "MY车场Auto1021164628"}};
                {{"ZYL流量主Auto1119113247", "MY车场Auto1119155342"}};
    }

    @Test(dataProvider = "data")
    public static void openClick_advertiseName(String traffic_name, String parking_name) throws Exception {
//        根据traffic_name找到traffic_id,partnerId和private_key
        String select_sql_1 = "select id,partner_id,private_key  from traffic_info where traffic_name='" + traffic_name + "'";
        String[] str = new String[]{"id", "partner_id", "private_key"};
        Map<String, String> map = MysqlDeal.mysqlDeal(select_sql_1, str);
        String partnerId = map.get("partner_id");
        String private_key = map.get("private_key");
        String traffic_id = map.get("id");
//        根据车场名称，流量主id找park_Id
        String select_sql_2 = "select id,serial_number from parking_info where traffic_id='" + traffic_id + "' and parking_name='" + parking_name + "'";
        String[] str2 = new String[]{"id", "serial_number"};
        Map<String, String> map1 = MysqlDeal.mysqlDeal(select_sql_2, str2);
        String gridId = map1.get("serial_number").split("-")[1];
//        曝光、点击
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
//                曝光GET
//                exposure_sjxp_scene_get(gridId, partnerId, private_key);
////                曝光POST
//                exposure_sjxp_scene_Post(gridId, partnerId, private_key);
//
//                //                    非小程序
                clickSceneGet(DataTest.click_url_scene, adId, gridId, partnerId, private_key);

            }
            } catch(NullPointerException e){
                System.out.println("曝光失败，空指针异常！");
            } catch(UnknownHostException e){
                System.out.println("曝光失败，域名无法访问！");
            }


    }
}
