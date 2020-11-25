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
public class CreateFillAdPlan {

    //填充广告计划
    public static void createFillAdPlan(int adPos, int isApi) throws IOException {
        AdPlanVo adPlanVo = new AdPlanVo();
        TreeMap<String, Object> treeMap = new TreeMap<String, Object>();
        treeMap.putAll(adPlanVo.toMap(adPos));
        treeMap.remove( "autoFill" );
        treeMap.remove( "isSubstitution" );
        treeMap.remove( "matchCondition" );
        treeMap.remove( "publishTimeList" );
        treeMap.put( "trafficIds",AdPlanDataTest.nullArray );
        treeMap.put( "cityIds",AdPlanDataTest.nullArray );
        treeMap.put( "parkIds",AdPlanDataTest.nullArray );
        treeMap.put( "parkTypeIds",AdPlanDataTest.nullArray );
        treeMap.put( "scheduleIntervalCnt",0 );
        treeMap.put( "scheduleIntervalHours",0 );
        treeMap.put( "scheduleIntervalType",0 );
        treeMap.put( "scheduleType",2 );
        //判断广告类型为微信小程序传appId
        if ( Integer.parseInt(treeMap.get( "mediaType" ).toString()) == 3){
            treeMap.put( "appId",AdPlanDataTest.appId );
        }
        //判断是否api接口投放
        treeMap.put( "isApi",isApi );
        if (Integer.parseInt(treeMap.get( "isApi" ).toString()) == 1){
            treeMap.put( "imageUri","" );
            treeMap.put( "mediaType",1 );
            treeMap.put( "url","" );
        }

        String treeMapStr = JSONObject.toJSONString( treeMap );
        HttpGG.doPost2( DataTest.plan_create_url, treeMapStr, DataTest.Access_Token );
    }
}
