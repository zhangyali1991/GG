package com.qb.ad.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.entity.DataTest;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.HttpGG.doGet02;
/**
 * 获取车场方法
 */
public class GetPark {

    //获取车场
    public static void getPark(String parkId, String partnerId) {
        try {
            Map<String, String> map = new HashMap<>();
            map.put( "parkId", parkId );
            map.put( "partnerId", partnerId );
            String json = JSONObject.toJSONString( map );
            System.out.println( json );
            String params = "?" + "parkId=" + parkId + "&" + "partnerId=" + partnerId;
            doGet02( DataTest.park_url_1 + params, json );  //只支持v1版本
        } catch (Exception e) {

        }
    }
}
