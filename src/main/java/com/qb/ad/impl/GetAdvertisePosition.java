package com.qb.ad.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.entity.DataTest;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.HttpGG.doGet02;
/**
 * 获取广告位方法
 */
public class GetAdvertisePosition {

    //获取广告位
    public static void getAdvertisePosition(String parkId, String partnerId, String private_key) {
        try {
            Map<String, String> adPosMap = new HashMap<>();
            adPosMap.put( "parkId", parkId );
            adPosMap.put( "partnerId", partnerId );
            String json = JSONObject.toJSONString( adPosMap );
            System.out.println( json );
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02( DataTest.adPos_url_1 + params, json );  //只支持v1版本
        } catch (Exception e) {
            System.out.println( "新增广告位失败！" );
        }
    }
}
