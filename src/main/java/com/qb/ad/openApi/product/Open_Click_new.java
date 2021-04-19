package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.qb.ad.entity.DataProduct.*;
import static com.qb.ad.util.ApiUtilsPro.*;

/**
 * *************************生产环境*************************
 * 据车场ID【park_Id】获取广告---曝光，取出adId和url
 * 根据曝光返回的adId和url点击
 */

public class Open_Click_new {
    static String adPosId = "4";//1入场推送，2出场推送，3输入车牌 ，4支付页面，5付款成功  *****需要创建计划类型*****
    static String park_Id = "010202007217849";  //监控：010202007219736   010202007217849
    static int open_cnt  = 1;
    static int click_cnt = 1;
    static String result_map;
    static String adId ="3211-134612638067974144";
    static String medium = "1";//1:微信公众号 2:微信小程序
    @Test
    public static void Open_Click() throws Exception {
        //根据车场名parking_name查出partnerId和private_key

        try {
            for (int tmp1 = 0;tmp1 < open_cnt;tmp1++) {
//                曝光
//                result_map = exposure_new(park_Id , DataProduct.partnerId ,DataProduct.priv_key , adPosId,medium);
//                if(click_cnt-- > 0 && adId != null){
                //              点击 ==  非小程序
                click(click_url, adId, park_Id, DataProduct.partnerId, DataProduct.priv_key);
//              点击 == 小程序
//                click_POST(adId, park_Id, DataProduct.partnerId, DataProduct.priv_key);
//            }

            }
        }catch (NullPointerException e){
            System.out.println("曝光失败，空指针异常！" );
        }catch (UnknownHostException e){
            System.out.println("曝光失败，域名无法访问！" );
        }
    }
}



