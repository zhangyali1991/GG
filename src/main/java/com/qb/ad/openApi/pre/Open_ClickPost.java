package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.entity.DataPre.click_url;
import static com.qb.ad.entity.DataPre.click_url_up;
import static com.qb.ad.util.ApiUtilsPre.*;

/**
 * *************************预发布环境*************************
 * 根据车场ID【park_Id】获取广告---曝光，取出adId和url
 * 根据曝光返回的adId和url点击
 */

public class Open_ClickPost {
    static String adPosId = "3";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****

//        static String park_Id = "010202008182005";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
//    文字链接
    static String park_Id = "010202008133253";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
    //    bannner
//    static String park_Id = "010202008186558";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
    static int open_cnt = 1;
    static int click_cnt = 1;
    static String medium = "1";//1-公众号；2-小程序
    static String adId = "803-134286538686779392";//点击必填
    static String url = "";
    static Map<String, String> result_map;

    @Test
    public static void Open_Click() throws Exception {
        //根据车场名parking_name查出partnerId和private_key
        try {
            for (int tmp1 = 0; tmp1 < open_cnt; tmp1++) {
//                result_map = exposure(park_Id , DataPre.partnerId ,DataPre.priv_key , adPosId,mediumType);
                result_map = exposure_post(park_Id, DataPre.partnerId, DataPre.priv_key, adPosId, medium);

//                url = result_map.get( "url" )+ "/api/v1/advert/click/";
                if (click_cnt-- > 0 && adId != null) {
                    //                非小程序

//                    click(click_url, adId, park_Id, DataPre.partnerId, DataPre.priv_key);
                    //                小程序
                    click_POST(adId, park_Id, DataPre.partnerId, DataPre.priv_key);

                }

            }
        } catch (NullPointerException e) {
            System.out.println("曝光失败，空指针异常！");
        } catch (UnknownHostException e) {
            System.out.println("曝光失败，域名无法访问！");
        }
    }
}



