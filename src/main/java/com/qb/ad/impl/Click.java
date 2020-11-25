package com.qb.ad.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;
import static com.qb.ad.util.HttpGG.doGet02;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
/**
 * 广告点击方法
 */

public class Click {

    //点击click
    public static void click(String adId, String park_Id, String partnerId, String private_key) throws Exception {
        String openId = randomNumeric( 8 );
//        String userLicense = "川A" + randomNumeric(5);
        Map<String, String> clickMap = new HashMap<>();
        clickMap.put( "adId", adId );
        clickMap.put( "parkId", park_Id );
        clickMap.put( "partnerId", partnerId );
        clickMap.put( "userMobile", DataTest.userMobile );
//        clickMap.put("userLicense", userLicense);
        clickMap.put( "openId", openId );
        String click_sign = ECCSignUtil.sign( private_key, clickMap );
        clickMap.put( "sign", click_sign );
        String click_json = JSONObject.toJSONString( clickMap );
//        System.out.println(click_json);
//        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" +"openId="+openId+ "&" + "userLicense=" + userLicense +"&" + "userMobile=" + userMobile +"&"+ "sign=" + click_sign;
        String click_params = "?" + "adId=" + adId + "&" + "partnerId=" + partnerId + "&" + "parkId=" + park_Id + "&" + "openId=" + openId + "&" + "userMobile=" + DataTest.userMobile + "&" + "sign=" + click_sign;
        try {
            doGet02( DataTest.click_url + click_params, click_json );
        } catch (Exception e) {
            System.out.println( e );
        }

    }


}
