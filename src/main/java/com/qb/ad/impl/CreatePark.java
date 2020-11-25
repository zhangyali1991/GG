package com.qb.ad.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;

import static com.qb.ad.util.HttpGG.doPost;
/**
 * 创建车场方法
 */
public class CreatePark {

    //创建车场
    public static String createPark(String partnerId, String private_key) throws Exception {
        try {
            Map<String, String> parkMap = new HashMap<>();
//            parkMap.put("parkId", parkId);
            parkMap.put( "parkName", DataTest.parkName );
            parkMap.put( "cityId", DataTest.cityId );
            parkMap.put( "partnerId", partnerId );
            String parkSign = ECCSignUtil.sign( private_key, parkMap );
            parkMap.put( "sign", parkSign );
            String park_json = JSONObject.toJSONString( parkMap );
            String requestData = doPost( DataTest.park_url, park_json );
            Map<String, Object> resultMap = JSON.parseObject( requestData, Map.class );
            String result = resultMap.get( "result" ).toString();
            Map<String, String> result_map = JSONObject.parseObject( result, new TypeReference<Map<String, String>>() {
            } );
            String parkId = result_map.get( "parkId" ).toString();
            System.out.println( "车场ID parkId: " + parkId );
            return parkId;
        } catch (Exception e) {
            System.out.println( "新增车场失败：" + e );
        }
        return null;
    }

}
