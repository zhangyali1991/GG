package com.qb.ad.openApi.pre;

import com.qb.ad.entity.DataPre;
import org.testng.annotations.Test;

import java.net.UnknownHostException;
import java.util.Map;

import static com.qb.ad.util.ApiUtilsPre.*;

/**
 * *************************预发布环境*************************
 * 根据车场ID【park_Id】获取广告---曝光，取出adId和url
 * 根据曝光返回的adId和url点击
 */

public class Open_Click {
    static String adPosId = "1";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****

//    static String park_Id = "010202008182005";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
//    文字链接
    static String park_Id = "010202008133253";  //3  测试专用-更新停车场0813172229  4   预发测试专用-更新停车场0818142058
//    bannner
//    static String park_Id = "010202008186558";  //这个park_Id 一定要修改为希望点击的车场010202008133253 010202008187576
    static int open_cnt  = 1;
    static int click_cnt = 1;
    static Map<String, String> result_map;
    static String adId ="";//65437254218907648
    static String url ="";
    @Test
    public static void Open_Click() throws Exception {
        //根据车场名parking_name查出partnerId和private_key

        try {
            for (int tmp1 = 0;tmp1 < open_cnt;tmp1++){
                result_map = exposure(park_Id , DataPre.partnerId ,DataPre.priv_key , adPosId);
                adId = result_map.get( "adId" );
//                非小程序
                url = result_map.get( "url" )+ "/api/v1/advert/redirect/";
//                小程序广告上报点击
//                url = result_map.get( "url" )+ "/api/v1/advert/click/";
                if(click_cnt-- > 0 && adId != null){
//                    click( url ,adId ,park_Id , DataPre.partnerId ,DataPre.priv_key);
                }
            }
        }catch (NullPointerException e){
            System.out.println("曝光失败，空指针异常！" );
        }catch (UnknownHostException e){
            System.out.println("曝光失败，域名无法访问！" );
        }
    }
}



