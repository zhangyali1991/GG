package com.qb.ad.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.util.HttpGG;
import com.qb.ad.entity.DataTest;
import com.zzrb.util.ECCSignUtil;

import java.util.HashMap;
import java.util.Map;
/**
 * 更新车场
 */
public class UpdatePark {

    //更新车场
    public static void updatePark(String parkId, String partnerId, String private_key) throws Exception {
        try {
            Map<String, String> parkMap = new HashMap<>();
            parkMap.put( "parkName", DataTest.updateparkName );
            parkMap.put( "cityId", DataTest.parkCityId );
//            parkMap.put( "status", "1" );    //v2需要注释
            parkMap.put( "partnerId", partnerId );
            parkMap.put( "parkId", parkId );
            String parkSign = ECCSignUtil.sign( private_key, parkMap );
            parkMap.put( "sign", parkSign );
            String park_json = JSONObject.toJSONString( parkMap );
            HttpGG.doPut( DataTest.park_url, park_json );

        } catch (Exception e) {
            System.out.println( "更新车场失败：" + e );
        }
    }

}
