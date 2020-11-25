//package com.qb.ad.impl;
//
//import com.alibaba.fastjson.JSONObject;
//import com.qb.ad.entity.DataTest;
//import com.zzrb.util.ECCSignUtil;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static com.qb.ad.util.HttpGG.doPut;
///**
// * 创建广告位方法
// */
//public class CreateAdvertisePosition {
//
//    //新增广告位
//    public static void createAdvertisePosition(String adPosIds, String parkId, String partnerId, String private_key) {
//        try {
//            Map<String, String> adPosMap = new HashMap<>();
//            adPosMap.put( "adPosIds", adPosIds );
//            adPosMap.put( "parkId", parkId );
//            adPosMap.put( "partnerId", partnerId );
////            adPosMap.put( "status", "1" );  //v2版本
//            String adPosSign = ECCSignUtil.sign( private_key, adPosMap );
//            adPosMap.put( "sign", adPosSign );
//            String adPos_json = JSONObject.toJSONString( adPosMap );
//            doPut( DataTest.adPos_url, adPos_json );
//        } catch (Exception e) {
//            System.out.println( "新增广告位失败！" );
//        }
//    }
//
//}
