package com.qb.ad.openApi.product;

import com.qb.ad.entity.DataProduct;
import org.testng.annotations.Test;

import java.net.UnknownHostException;

import static com.qb.ad.util.ApiUtilsPro.exposure_new;
import static com.qb.ad.util.ApiUtilsPro.exposure_sjxp;

/**
 * *************************生产环境*************************
 * 据车场ID【park_Id】获取广告---曝光，取出adId和url
 * 根据曝光返回的adId和url点击
 */

public class Open_Click_sjxp {
    static String park_Id = "010202008182630";  //监控：010202007219736   010202007217849
    static int open_cnt  = 1;
    static int click_cnt = 1;
    static String result_map;
    static String adId ="";
    static String url ="";
    @Test
    public static void Open_Click() throws Exception {
        //根据车场名parking_name查出partnerId和private_key

        try {
            for (int tmp1 = 0;tmp1 < open_cnt;tmp1++){
                result_map = exposure_sjxp(park_Id , DataProduct.partnerId ,DataProduct.priv_key);
//                非小程序
//                url = result_map.get( "url" ) + "/api/v1/advert/redirect/";
//                if(click_cnt-- > 0 && adId != null){
//                    click( url ,adId ,park_Id , DataProduct.partnerId ,DataProduct.priv_key);
//                }
            }
        }catch (NullPointerException e){
            System.out.println("曝光失败，空指针异常！" );
        }catch (UnknownHostException e){
            System.out.println("曝光失败，域名无法访问！" );
        }
    }
}



