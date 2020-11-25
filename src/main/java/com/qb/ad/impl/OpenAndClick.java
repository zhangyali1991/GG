package com.qb.ad.impl;

import java.net.UnknownHostException;

import static com.qb.ad.impl.Click.click;
import static com.qb.ad.impl.Open.open;
/**
 * 曝光后拿到adId点击（跳转）
 */
public class OpenAndClick {

    //曝光并且点击
    public static void openAndClick(String park_Id, String partnerId, String private_key, String adPosId, int openCount, int clickCount) throws Exception {
        //首先曝光一次
        String adId = "";
        try {
//            adId = exposure(park_Id , partnerId ,private_key ,adPosId);
            for (int tmp1 = 0; tmp1 < openCount; tmp1++) {
                adId = open( park_Id, partnerId, private_key, adPosId );
                if (clickCount-- > 0 && adId != null) {
                    click( adId, park_Id, partnerId, private_key );
                }
            }
            //点击click
//            for (int tmp2 = 0;tmp2 < clickCount ;tmp2++){
//
//            }
        } catch (NullPointerException e) {
            System.out.println( "曝光失败，空指针异常！" );
        } catch (UnknownHostException e) {
            System.out.println( "曝光失败，域名无法访问！" );
        } catch (Exception e) {
            System.out.println( "其他异常：" + e );
        }
    }

}
