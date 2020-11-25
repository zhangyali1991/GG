package com.qb.ad.impl;

import com.alibaba.fastjson.JSONObject;
import com.qb.ad.common.AdPlanVo;
import com.qb.ad.entity.AdPlanDataTest;
import com.qb.ad.entity.DataTest;
import com.qb.ad.util.HttpGG;

import java.io.IOException;
import java.util.TreeMap;

/**
 * 创建计划方法
 */
public class CreateShareAdPlan {

    //共享广告计划
    public static void createShareAdPlan(int adPos) throws IOException {
        AdPlanVo adPlanVo = new AdPlanVo();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        treeMap.putAll(adPlanVo.toMap(adPos));
        treeMap.remove( "isSubstitution" );
        treeMap.put( "scheduleType",1 );
        if ( Integer.parseInt(treeMap.get( "mediaType" ).toString()) == 3){
            treeMap.put( "appId",AdPlanDataTest.appId );
        }
        String treeMapStr = JSONObject.toJSONString( treeMap );
        HttpGG.doPost2( DataTest.plan_create_url, treeMapStr, DataTest.Access_Token );
    }
}
