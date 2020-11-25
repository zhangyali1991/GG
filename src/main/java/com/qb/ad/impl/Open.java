package com.qb.ad.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.HttpGG.doGet02;
import static org.apache.commons.lang3.RandomStringUtils.randomNumeric;
/**
 * 获取广告（曝光）方法
 */
public class Open {
    
    //曝光exposure
    public static String open(String park_Id, String partnerId, String private_key, String adPosId) throws Exception {
        String userLicense = "京A" + randomNumeric( 5 );
        String openId = randomNumeric( 8 );
        String userIp = randomNumeric( 2 ) + ".1.1." + randomNumeric( 2 );
        String responseData = "";
        Map<String, String> getAdvertMap = new HashMap<>();
        getAdvertMap.put( "parkId", park_Id );
        getAdvertMap.put( "partnerId", partnerId );
        getAdvertMap.put( "adPosId", adPosId );
        getAdvertMap.put( "userMobile", DataTest.userMobile );
        getAdvertMap.put( "userLicense", userLicense );
        getAdvertMap.put( "openId", openId );
        getAdvertMap.put( "userIp", userIp );
        String exposure_sign = ECCSignUtil.sign( private_key, getAdvertMap );
        getAdvertMap.put( "sign", exposure_sign );
        String exposure_json = JSONObject.toJSONString( getAdvertMap );
        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" + "openId=" + openId + "&" + "userMobile=" + DataTest.userMobile + "&" + "userLicense=" + userLicense + "&" + "userIp=" + userIp + "&" + "sign=" + exposure_sign;
//        String exposure_params = "?" + "adPosId=" + adPosId + "&" + "parkId=" + park_Id + "&" + "partnerId=" + partnerId + "&" +"openId="+openId + "&" + "userMobile=" + userMobile + "&"+ "userIp=" + userIp + "sign=" + exposure_sign;
        try {
            responseData = doGet02( DataTest.exposure_url + exposure_params, exposure_json );
        } catch (Exception e) {
            System.out.println( e );
        }

        Map<String, Object> resultMap = JSON.parseObject( responseData, Map.class );
        if (resultMap.get( "status" ).equals( "20000000" )) {
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject( result, new TypeReference<Map<String, String>>() {
            } );
            String adId = result_map.get( "adId" ).toString();
            System.out.println( "广告计划uuid - adId: " + adId );
            return adId;
        } else {
            System.out.println( "曝光失败！" );
            return null;
        }
    }

}
